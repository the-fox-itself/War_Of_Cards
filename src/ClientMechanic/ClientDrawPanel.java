package ClientMechanic;

import GameMechanic.Objects.Essences.Essence;
import GameMechanic.Objects.Essences.EssenceWolf;
import GameMechanic.Objects.GameObjects.GameObject;
import GameMechanic.Objects.Grounds.Ground;
import GameMechanic.Objects.TechnicalObjects.Quest;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import static GameMechanic.GameMainVariables.*;
import static Libraries.Methods.*;

public class ClientDrawPanel extends JPanel {
    ClientDrawPanel() {
        printNote("Creating an object of class DrawPanel", NOTE_TYPE_DONE);
    }

    public final static String TYPE_OBJECT = "object";
    public final static String TYPE_ESSENCE = "essence";

    public final static String PAINT_RECT = "rect";
    public final static String PAINT_OVAL = "oval";

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (repaintPhase) {
            case REPAINT_MENU:
                g.drawImage(ICON_MENU_BACKGROUND, frame.getWidth()/2-ICON_MENU_BACKGROUND.getWidth(null)/2,
                        frame.getHeight()/2-ICON_MENU_BACKGROUND.getHeight(null)/2,null);
                g.drawImage(ICON_MENU_TITLE, frame.getWidth()/2-ICON_MENU_TITLE.getWidth(null)/2, -20,null);
                break;

            case REPAINT_GAME:
                for (Map.Entry<Ground, int[]> groundSet : worldCurrent.listOfGrounds.entrySet()) {
                    Ground ground = groundSet.getKey();
                    g.drawImage(ground.icon, ground.getXOfFrame(), ground.getYOfFrame(), null);
                }

                for (Map.Entry<GameObject, int[]> gameObjectSet : worldCurrent.listOfObjects.entrySet()) {
                    GameObject gameObject = gameObjectSet.getKey();
                    if (!gameObject.name.equals(GameObject.NAME_BARRIER)) {
                        g.drawImage(gameObject.isNearby ? gameObject.iconOfNearby : gameObject.iconOfFar,
                                gameObject.isNearby ? gameObject.getXOfFrame() - gameObject.iconOfNearby.getWidth(null) / 2 :
                                        gameObject.getXOfFrame() - gameObject.iconOfFar.getWidth(null) / 2, gameObject.isNearby ?
                                        gameObject.getYOfFrame() - gameObject.iconOfNearby.getHeight(null) / 2 : gameObject.getYOfFrame()
                                        - gameObject.iconOfFar.getHeight(null) / 2, null);
                    } else {
                        g.setColor(gameObject.color);
                        g.fillRect(gameObject.getXOfFrame(), gameObject.getYOfFrame(), gameObject.width, gameObject.height);
                    }
                }

                for (Essence essence : worldCurrent.listOfEssences) {
                    g.drawImage(essence.icon, essence.xOnFrame - essence.icon.getWidth(null) / 2, essence.yOnFrame -
                            essence.icon.getHeight(null) / 2, this);
                }

                g.drawImage(iconPlayerCurrent, playerXFrame - iconPlayerCurrent.getWidth(this)/2, playerYFrame -
                        iconPlayerCurrent.getHeight(this), this);

                if (timerDrawPanelRepaintGame == TIME_DRAW_PANEL_REPAINT_GAME_GO) {
                    if (worldCurrent.listOfQuests.size() > playerCurrent.amountOfCompletedQuests) {
                        if (!worldCurrent.listOfQuests.get(playerCurrent.amountOfCompletedQuests).isCompleted()) {
                            textQuests.setText("         Квесты\n\n " + worldCurrent.listOfQuests.get(playerCurrent.amountOfCompletedQuests).getNumberOfQuest() + ". "
                                    + worldCurrent.listOfQuests.get(playerCurrent.amountOfCompletedQuests).getGoal() + "\n\n\n Добыто: "
                                    + worldCurrent.listOfQuests.get(playerCurrent.amountOfCompletedQuests).getReachedNumber() + "/"
                                    + worldCurrent.listOfQuests.get(playerCurrent.amountOfCompletedQuests).getGoalNumber() + ".");
                        } else {
                            playerCurrent.amountOfCompletedQuests++;
                            worldCurrent.listOfQuests.get(playerCurrent.amountOfCompletedQuests).runnableOn();
                        }
                    } else {
                        textQuests.setText(" Все квесты пройдены! Поздравляем!");
                    }
                    timerDrawPanelRepaintGame = 0;
                } else {
                    timerDrawPanelRepaintGame++;
                }

                if (hitBoxModeOn) {
                    g.setColor(new Color(240, 50, 50));
                    g.drawLine(playerXFrame, playerYFrame, playerXFrame, playerYFrame + iconPlayerCurrent.getHeight(null) / 2);
                    g.drawLine(playerXFrame, playerYFrame, playerXFrame, playerYFrame - iconPlayerCurrent.getHeight(null) / 2);
                    g.drawLine(playerXFrame, playerYFrame, playerXFrame + iconPlayerCurrent.getWidth(null) / 2, playerYFrame);
                    g.drawLine(playerXFrame, playerYFrame, playerXFrame - iconPlayerCurrent.getWidth(null) / 2, playerYFrame);

                    for (Essence essence : worldCurrent.listOfEssences) {
                        g.drawLine(essence.xOnFrame, essence.yOnFrame, essence.xOnFrame, essence.yOnFrame + iconPlayerCurrent.getHeight(null) / 2);
                        g.drawLine(essence.xOnFrame, essence.yOnFrame, essence.xOnFrame, essence.yOnFrame - iconPlayerCurrent.getHeight(null) / 2);
                        g.drawLine(essence.xOnFrame, essence.yOnFrame, essence.xOnFrame + iconPlayerCurrent.getWidth(null) / 2, essence.yOnFrame);
                        g.drawLine(essence.xOnFrame, essence.yOnFrame, essence.xOnFrame - iconPlayerCurrent.getWidth(null) / 2, essence.yOnFrame);

                        g.drawLine(essence.xOnFrame-5, essence.yOnFrame-5, essence.xOnFrame+5, essence.yOnFrame-5);
                        g.drawLine(essence.xOnFrame-5, essence.yOnFrame-5, essence.xOnFrame-5, essence.yOnFrame+5);
                        g.drawLine(essence.xOnFrame+5, essence.yOnFrame+5, essence.xOnFrame-5, essence.yOnFrame+5);
                        g.drawLine(essence.xOnFrame+5, essence.yOnFrame+5, essence.xOnFrame+5, essence.yOnFrame-5);
                    }
                    for (Map.Entry<GameObject, int[]> gameObjectSet : worldCurrent.listOfObjects.entrySet()) {
                        GameObject gameObject = gameObjectSet.getKey();
                        if (gameObject.name.equals(GameObject.NAME_BARRIER)) {
                            g.drawLine(gameObject.getXOfFrame()+4-6, gameObject.getYOfFrame()+4-6, gameObject.getXOfFrame()+4+6, gameObject.getYOfFrame()+4-6);
                            g.drawLine(gameObject.getXOfFrame()+4-6, gameObject.getYOfFrame()+4-6, gameObject.getXOfFrame()+4-6, gameObject.getYOfFrame()+4+6);
                            g.drawLine(gameObject.getXOfFrame()+4+6, gameObject.getYOfFrame()+4+6, gameObject.getXOfFrame()+4-6, gameObject.getYOfFrame()+4+6);
                            g.drawLine(gameObject.getXOfFrame()+4+6, gameObject.getYOfFrame()+4+6, gameObject.getXOfFrame()+4+6, gameObject.getYOfFrame()+4-6);
                        } else {
                            g.drawLine(gameObject.getXOfFrame()-50, gameObject.getYOfFrame()-50, gameObject.getXOfFrame()+50, gameObject.getYOfFrame()-50);
                            g.drawLine(gameObject.getXOfFrame()-50, gameObject.getYOfFrame()-50, gameObject.getXOfFrame()-50, gameObject.getYOfFrame()+50);
                            g.drawLine(gameObject.getXOfFrame()+50, gameObject.getYOfFrame()+50, gameObject.getXOfFrame()-50, gameObject.getYOfFrame()+50);
                            g.drawLine(gameObject.getXOfFrame()+50, gameObject.getYOfFrame()+50, gameObject.getXOfFrame()+50, gameObject.getYOfFrame()-50);
                        }
                    }
                    g.setColor(COLOR_INTERFACE_ORANGE);
                    g.setFont(f15);
                    g.drawString("Версия игры: "+version, 10, 20);
                    g.drawString("Координаты игрока: x = " + (new BigDecimal(Double.toString(playerCurrent.xOfPlayer)).setScale(1, RoundingMode.HALF_UP).doubleValue())
                            + ", y = " + (new BigDecimal(Double.toString(playerCurrent.yOfPlayer)).setScale(1, RoundingMode.HALF_UP).doubleValue()), 10, 40);
                    if (!playerCurrent.listOfNearbyGameObjects.isEmpty()) {
                        int y = 60;
                        g.drawString("Ближайшие объекты:", 10, y);
                        for (GameObject gameObject : playerCurrent.listOfNearbyGameObjects) {
                            y += 20;
                            g.drawString("-  name = " + gameObject.name + ", x = " + (gameObject.xOnWorld) + ", y = " + (gameObject.yOnWorld) + "\n", 10, y);
                        }
                    } else {
                        g.drawString("Ближайшие объекты: Не найдено", 10, 60);
                    }
                }

                paintObject(COLOR_GAME_INTERFACE_BACK, 10, frame.getHeight() - (frame.getWidth() / 11 * 15 / 10 + 10) - 30, frame.getWidth() / 11,
                        frame.getWidth() / 11 * 15 / 10, PAINT_RECT, g);
                paintObject(COLOR_GAME_INTERFACE_FRONT, 20, frame.getHeight() - (frame.getWidth() / 11 * 15 / 10) - 30, frame.getWidth() / 11 - 20,
                        frame.getWidth() / 11 * 15 / 10 - 20, PAINT_RECT, g);
                paintObject(COLOR_GAME_INTERFACE_BACK, frame.getWidth() - (frame.getWidth() / 11 + 10) - 10, frame.getHeight() - (frame.getWidth() / 11 * 15 / 10 + 10)
                        - 30, frame.getWidth() / 11, frame.getWidth() / 11 * 15 / 10, PAINT_RECT, g);
                paintObject(COLOR_GAME_INTERFACE_FRONT, frame.getWidth() - (frame.getWidth() / 11 + 10), frame.getHeight() - (frame.getWidth() / 11 * 15 / 10) - 30,
                        frame.getWidth() / 11 - 20, frame.getWidth() / 11 * 15 / 10 - 20, PAINT_RECT, g);
                paintObject(COLOR_GAME_INTERFACE_BACK, frame.getWidth() - 250, 20, 220, 220, PAINT_RECT, g);
                paintObject(COLOR_GAME_INTERFACE_FRONT, frame.getWidth() - 240, 30, 200, 200, PAINT_RECT, g);

                if (!godModeOn) {
                    paintHealth(g);
                }

                g.setColor(COLOR_INTERFACE_ORANGE);
                g.setFont(f20);
                int completedThings = 0;
                int wholeThings = 0;
                for (Quest quest : worldCurrent.listOfQuests) {
                    completedThings += quest.getReachedNumber();
                    wholeThings += quest.getGoalNumber();
                }
                worldCurrent.percentComplete = (double) completedThings / wholeThings*100;
                g.drawString("Прогресс: "+(int)worldCurrent.percentComplete+"%", frame.getWidth()/2-60, 30);

                if (inventoryOpen) {
                    paintObject(COLOR_GAME_INVENTORY_BACKGROUND, 260, 100, frame.getWidth()-520, frame.getHeight()-240, PAINT_RECT, g);
                }

                for (GameObject gameObject : playerCurrent.listOfNearbyGameObjects) {
                    if (!gameObject.name.equals(GameObject.NAME_BARRIER)) {
                        g.drawImage(ICON_OBJECT_FRAME, gameObject.getXOfFrame() - ICON_OBJECT_FRAME.getWidth(null) / 2, gameObject.getYOfFrame() -
                                ICON_OBJECT_FRAME.getHeight(null) / 2, null);
                    }
                }
                break;
        }
    }

    private void paintHealth(Graphics g) {
        int x = frame.getWidth()/2-390/2;
        int y = frame.getHeight() - 60;
        for (int h = 0; h < playerCurrent.maxHealth; h++) {
            if (h % 10 == 0) {
                y -= 40;
                x = frame.getWidth()/2-390/2;
            }
            paintObject(COLOR_GAME_PLAYER_HEALTH_BACKGROUND, x, y, 30, 30, PAINT_RECT, g);
            x += 40;
        }

        int x1 = frame.getWidth()/2-390/2;
        int y1 = frame.getHeight() - 60;
        for (int h = 0; h < playerCurrent.health; h++) {
            if (h % 10 == 0) {
                y1 -= 40;
                x1 = frame.getWidth()/2-390/2;
            }
            paintObject(COLOR_GAME_PLAYER_HEALTH, x1, y1, 30, 30, PAINT_RECT, g);
            x1 += 40;
        }
    }

    private void paintObject(Color color, int x, int y, int w, int h, String shape, Graphics g) {
        g.setColor(color);
        switch (shape) {
            case PAINT_RECT:
                g.fillRect(x, y, w, h);
                break;
            case PAINT_OVAL:
                g.fillOval(x, y, w, h);
                break;
        }
    }
}
