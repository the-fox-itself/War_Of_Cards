package Client.Mechanic;

import Client.Objects.Essences.Essence;
import Client.Objects.GameObjects.GameObject;
import Client.Objects.Grounds.Ground;
import Client.Objects.TechnicalObjects.Quest;

import javax.swing.*;
import java.awt.*;
import java.util.ConcurrentModificationException;

import static Client.Mechanic.MainGUIVariables.*;
import static Client.Mechanic.SwingPlus.Methods.*;

public class DrawPanel extends JPanel {
    DrawPanel() {
        printNote("Creating an object of class DrawPanel", NOTE_TYPE_DONE);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (repaintPhase) {
            case REPAINT_MENU:
                g.drawImage(ICON_MENU_BACKGROUND, frame.getWidth()/2- ICON_MENU_BACKGROUND.getWidth(null)/2, frame.getHeight()/2- ICON_MENU_BACKGROUND.getHeight(null)/2,null);
                g.drawImage(ICON_MENU_TITLE, frame.getWidth()/2- ICON_MENU_TITLE.getWidth(null)/2, -20,null);
//                g.drawImage(iconQuestion, frame.getWidth()-iconQuestion.getWidth(null)-10, frame.getHeight()-iconQuestion.getHeight(null)-25, null);
                break;

            case REPAINT_GAME:
                for (Ground ground : worldCurrent.listOfGrounds) {
                    g.drawImage(ground.icon, ground.x, ground.y, null);
                }
                paintObject(COLOR_GAME_PLAYER_SHADOW, playerXFrame - 20, playerYFrame + 5, 40, 30, "Oval", g);

                drawImageObjectsByType("Object", "Gold", g);
                drawImageObjectsByType("Object", "Diamond", g);
                paintObjectsByType("Object", "Water", "Oval", g);
                g.drawImage(iconPlayerCurrent, playerXFrame - iconPlayerCurrent.getWidth(this)/2, playerYFrame - iconPlayerCurrent.getHeight(this)/2, this);
                drawImageObjectsByType("Essence", "Wolf", g);
                drawImageObjectsByType("Object", "Stone", g);
                drawImageObjectsByType("Object", "SmallStone", g);
                drawImageObjectsByType("Object", "Wood", g);
                paintObjectsByType("Object", "Barrier", "Rect", g);

                paintObject(COLOR_GAME_INTERFACE_BACK, 10, frame.getHeight() - (frame.getWidth() / 11 * 15 / 10 + 10) - 30, frame.getWidth() / 11, frame.getWidth() / 11 * 15 / 10, "Rect", g);
                paintObject(COLOR_GAME_INTERFACE_FRONT, 20, frame.getHeight() - (frame.getWidth() / 11 * 15 / 10) - 30, frame.getWidth() / 11 - 20, frame.getWidth() / 11 * 15 / 10 - 20, "Rect", g);
                paintObject(COLOR_GAME_INTERFACE_BACK, frame.getWidth() - (frame.getWidth() / 11 + 10) - 10, frame.getHeight() - (frame.getWidth() / 11 * 15 / 10 + 10) - 30, frame.getWidth() / 11, frame.getWidth() / 11 * 15 / 10, "Rect", g);
                paintObject(COLOR_GAME_INTERFACE_FRONT, frame.getWidth() - (frame.getWidth() / 11 + 10), frame.getHeight() - (frame.getWidth() / 11 * 15 / 10) - 30, frame.getWidth() / 11 - 20, frame.getWidth() / 11 * 15 / 10 - 20, "Rect", g);
                paintObject(COLOR_GAME_INTERFACE_BACK, frame.getWidth() - 250, 20, 220, 220, "Rect", g);
                paintObject(COLOR_GAME_INTERFACE_FRONT, frame.getWidth() - 240, 30, 200, 200, "Rect", g);

                paintHealth(g);

                if (timerDrawPanelRepaintGame == TIME_DRAW_PANEL_REPAINT_GAME_GO) {
                    if (worldCurrent.listOfQuests.size() > playerCurrent.amountOfCompletedQuests) {
                        if (!worldCurrent.listOfQuests.get(playerCurrent.amountOfCompletedQuests).isCompleted()) {
                            textQuests.setText("         Квесты\n\n " + worldCurrent.listOfQuests.get(playerCurrent.amountOfCompletedQuests).getNumberOfQuest() + ". "
                                    + worldCurrent.listOfQuests.get(playerCurrent.amountOfCompletedQuests).getGoal() + "\n\n Добыто: "
                                    + worldCurrent.listOfQuests.get(playerCurrent.amountOfCompletedQuests).getReachCards().size() + "/"
                                    + worldCurrent.listOfQuests.get(playerCurrent.amountOfCompletedQuests).getGoalNumber() + ".");
                            if (!worldCurrent.listOfQuests.get(playerCurrent.amountOfCompletedQuests).isNow()) {
                                worldCurrent.listOfQuests.get(playerCurrent.amountOfCompletedQuests).setNow(true);
                            }
                        } else {
                            for (Quest quest : worldCurrent.listOfQuests) {
                                quest.setNow(false);
                            }
                            playerCurrent.amountOfCompletedQuests++;
                        }
                    } else {
                        textQuests.setText(" Все квесты\n пройдены!\n Поздравляем!");
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
                    for (GameObject gameObject : worldCurrent.listOfObjects) {
                        if (gameObject.name.equals("Barrier")) {
                            g.drawLine(gameObject.xOnFrame+4-6, gameObject.yOnFrame+4-6, gameObject.xOnFrame+4+6, gameObject.yOnFrame+4-6);
                            g.drawLine(gameObject.xOnFrame+4-6, gameObject.yOnFrame+4-6, gameObject.xOnFrame+4-6, gameObject.yOnFrame+4+6);
                            g.drawLine(gameObject.xOnFrame+4+6, gameObject.yOnFrame+4+6, gameObject.xOnFrame+4-6, gameObject.yOnFrame+4+6);
                            g.drawLine(gameObject.xOnFrame+4+6, gameObject.yOnFrame+4+6, gameObject.xOnFrame+4+6, gameObject.yOnFrame+4-6);
                        } else {
                            g.drawLine(gameObject.xOnFrame-40, gameObject.yOnFrame-40, gameObject.xOnFrame+40, gameObject.yOnFrame-40);
                            g.drawLine(gameObject.xOnFrame-40, gameObject.yOnFrame-40, gameObject.xOnFrame-40, gameObject.yOnFrame+40);
                            g.drawLine(gameObject.xOnFrame+40, gameObject.yOnFrame+40, gameObject.xOnFrame-40, gameObject.yOnFrame+40);
                            g.drawLine(gameObject.xOnFrame+40, gameObject.yOnFrame+40, gameObject.xOnFrame+40, gameObject.yOnFrame-40);
                        }
                    }
                    g.setColor(COLOR_INTERFACE_ORANGE);
                    g.setFont(f20);
                    g.drawString("x: " + (0- playerCurrent.xOfPlayer) + ", y: " + (0- playerCurrent.yOfPlayer), 10, 20);
                    if (!playerCurrent.listOfNearbyGameObjects.isEmpty()) {
                        g.drawString("type: " + playerCurrent.listOfNearbyGameObjects.get(0).name + ", x: " + (playerCurrent.listOfNearbyGameObjects.get(0).xOnWorld) + ", y: " + (0 - playerCurrent.listOfNearbyGameObjects.get(0).yOnWorld), 10, 40);
                    } else {
                        g.drawString("no nearby objects", 10, 40);
                    }
                }

                g.setColor(COLOR_INTERFACE_ORANGE);
                g.setFont(f20);
                int completedThings = 0;
                int wholeThings = 0;
                for (Quest quest : worldCurrent.listOfQuests) {
                    completedThings += quest.getReachCards().size();
                    wholeThings += quest.getGoalNumber();
                }
                worldCurrent.percentComplete = (double) completedThings / wholeThings*100;
                g.drawString("Прогресс: "+(int)worldCurrent.percentComplete+"%", frame.getWidth()/2-60, 20);

                if (inventoryOpen) {
                    paintObject(COLOR_GAME_INVENTORY_BACKGROUND, 260, 100, frame.getWidth()-520, frame.getHeight()-240, "Rect", g);
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
            paintObject(COLOR_GAME_PLAYER_HEALTH_BACKGROUND, x, y, 30, 30, "Rect", g);
            x += 40;
        }

        int x1 = frame.getWidth()/2-390/2;
        int y1 = frame.getHeight() - 60;
        for (int h = 0; h < playerCurrent.health; h++) {
            if (h % 10 == 0) {
                y1 -= 40;
                x1 = frame.getWidth()/2-390/2;
            }
            paintObject(COLOR_GAME_PLAYER_HEALTH, x1, y1, 30, 30, "Rect", g);
            x1 += 40;
        }
    }

    private void paintObjectsByType(String type, String name, String shape, Graphics g) {
        try {
            switch (type) {
                case "Object":
                    for (GameObject gameObject : worldCurrent.listOfObjects) {
                        if (gameObject.name.equals(name)) {
                            g.setColor(gameObject.color);
                            switch (shape) {
                                case "Rect":
                                    g.fillRect(gameObject.xOnFrame, gameObject.yOnFrame, gameObject.width, gameObject.height);
                                case "Oval":
                                    g.fillOval(gameObject.xOnFrame, gameObject.yOnFrame, gameObject.width, gameObject.height);
                            }
                        }
                    }
                    break;
                case "Essence":
                    for (Essence essence : worldCurrent.listOfEssences) {
                        if (essence.name.equals(name)) {
                            g.setColor(essence.color);
                            switch (shape) {
                                case "Rect":
                                    g.fillRect(essence.xOnFrame, essence.yOnFrame, essence.width, essence.height);
                                case "Oval":
                                    g.fillOval(essence.xOnFrame, essence.yOnFrame, essence.width, essence.height);
                            }
                        }
                    }
                    break;
            }
        } catch (ConcurrentModificationException ex) {
            System.out.println("ConcurrentModificationException");
            ex.printStackTrace();
        }
    }
    private void drawImageObjectsByType(String type, String name, Graphics g) {
        try {
            switch (type) {
                case "Object":
                    for (GameObject gameObject : worldCurrent.listOfObjects) {
                        if (gameObject.name.equals(name)) {
                            g.drawImage(gameObject.isNearby ? gameObject.iconOfNearby : gameObject.iconOfFar, gameObject.isNearby ? gameObject.xOnFrame - gameObject.iconOfNearby.getWidth(null) / 2 : gameObject.xOnFrame - gameObject.iconOfFar.getWidth(null) / 2, gameObject.isNearby ? gameObject.yOnFrame - gameObject.iconOfNearby.getHeight(null) / 2 : gameObject.yOnFrame - gameObject.iconOfFar.getHeight(null) / 2, this);
                        }
                    }
                    break;
                case "Essence":
                    for (Essence essence : worldCurrent.listOfEssences) {
                        if (essence.name.equals(name)) {
                            g.drawImage(essence.icon, essence.xOnFrame - essence.icon.getWidth(null) / 2, essence.yOnFrame - essence.icon.getHeight(null) / 2, this);
                        }
                    }
                    break;
            }
        } catch (ConcurrentModificationException ex) {
            System.out.println("ConcurrentModificationException");
            ex.printStackTrace();
        }
    }
    private void paintObject(Color color, int x, int y, int w, int h, String shape, Graphics g) {
        g.setColor(color);
        switch (shape) {
            case "Rect":
                g.fillRect(x, y, w, h);
                break;
            case "Oval":
                g.fillOval(x, y, w, h);
                break;
        }
    }
}
