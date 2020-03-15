package Client.Mechanic;

import Client.Objects.Essences.Essence;
import Client.Objects.GameObjects.GameObject;
import Client.Objects.Ground.Ground;
import Client.Objects.Quest;

import javax.swing.*;
import java.awt.*;

import static Client.Mechanic.MainVariables.*;

public class DrawPanel extends JPanel {
    DrawPanel() {
        System.out.println("Creating object of class DrawPanel...");
        System.out.println("Finished creating object of class DrawPanel.");
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (phaseOfRepaint) {
            case 1:
                paintObject(colorStartBackground, 0, 0, 2000, 1000, "Rect", g);
                paintObject(colorStartPictureBackground, 0, 0, 2000, 200, "Rect", g);
                paintObject(colorStartPictureBlue, 590, 100, 60, 60, "Oval", g);
                paintObject(colorStartPictureRed, 1100, 80, 60, 60, "Oval", g);
                paintObject(colorStartPictureRed, 900, 20, 60, 60, "Oval", g);
                paintObject(colorStartPartitions, 0, 200, 2000, 20, "Rect", g);
                paintObject(colorStartPartitions, 0, 800, 2000, 20, "Rect", g);

//                Image image = new ImageIcon("C:\\Users\\Cripton\\Pictures\\1Icon.png").getImage();
//                g.drawImage(image, mainFrame.getWidth()/2-image.getWidth(null)/2, mainFrame.getHeight()/2-image.getHeight(null)/2,null);

                break;
            case 2:
                for (Ground ground : worldNow.listOfGrounds) {
                    g.drawImage(ground.icon, ground.x, ground.y, null);
                }
                paintObject(colorGamePlayerBackground, xOfPlayerOnFrame - 20, yOfPlayerOnFrame + 5, 40, 30, "Oval", g);

                paintImageTypeObjects("Object", "Gold", g);
                paintImageTypeObjects("Object", "Diamond", g);
                paintTypeObjects("Object", "Water", "Oval", g);
                g.drawImage(iconPlayer, xOfPlayerOnFrame - iconPlayer.getWidth(this)/2, yOfPlayerOnFrame - iconPlayer.getHeight(this)/2, this);
                paintImageTypeObjects("Essence", "Wolf", g);
                paintImageTypeObjects("Object", "Stone", g);
                paintImageTypeObjects("Object", "SmallStone", g);
                paintImageTypeObjects("Object", "Wood", g);
                paintTypeObjects("Object", "Barrier", "Rect", g);

                paintObject(colorGameHandBackground1, 10, mainFrame.getHeight() - (mainFrame.getWidth() / 10 * 15 / 10 + 10) - 30, mainFrame.getWidth() / 10, mainFrame.getWidth() / 10 * 15 / 10, "Rect", g);
                paintObject(colorGameHandBackground2, 20, mainFrame.getHeight() - (mainFrame.getWidth() / 10 * 15 / 10) - 30, mainFrame.getWidth() / 10 - 20, mainFrame.getWidth() / 10 * 15 / 10 - 20, "Rect", g);
                paintObject(colorGameHandBackground1, mainFrame.getWidth() - (mainFrame.getWidth() / 10 + 10) - 10, mainFrame.getHeight() - (mainFrame.getWidth() / 10 * 15 / 10 + 10) - 30, mainFrame.getWidth() / 10, mainFrame.getWidth() / 10 * 15 / 10, "Rect", g);
                paintObject(colorGameHandBackground2, mainFrame.getWidth() - (mainFrame.getWidth() / 10 + 10), mainFrame.getHeight() - (mainFrame.getWidth() / 10 * 15 / 10) - 30, mainFrame.getWidth() / 10 - 20, mainFrame.getWidth() / 10 * 15 / 10 - 20, "Rect", g);
                paintObject(colorGameHandBackground1, mainFrame.getWidth() - 250, 20, 220, 220, "Rect", g);

                int y = mainFrame.getHeight() - 60;
                int x = mainFrame.getWidth() /3 + 75;
                for (int h = 0; h < worldNow.maxHealth; h++) {
                    if (h % 10 == 0) {
                        y -= 40;
                        x = mainFrame.getWidth() /5;
                    }
                    paintObject(colorMaxHealth, x, y, 30, 30, "Rect", g);
                    x += 40;
                }

                int y1 = mainFrame.getHeight() - 60;
                int x1 = mainFrame.getWidth() /3 + 75;
                for (int h = 0; h < worldNow.health; h++) {
                    if (h % 10 == 0) {
                        y1 -= 40;
                        x1 = mainFrame.getWidth() /5;
                    }
                    paintObject(colorHealth, x1, y1, 30, 30, "Rect", g);
                    x1 += 40;
                }

                if (timerStatementRepaint == 5) {
                    for (JLabel label : listOfLabelsNotification) {
                        if (listOfLabelsNotificationBool.get(listOfLabelsNotification.indexOf(label))) {
                            listOfLabelsNotificationBool.add(listOfLabelsNotification.indexOf(label), false);
                            Runnable runnable = () -> {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                for (int x2 = 230; x2 > 0; x2--) {
                                    label.setForeground(new Color(0, 0, 0, x2));
                                    try {
                                        Thread.sleep(2);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                visFalse(label);
                                label.setForeground(new Color(0, 0, 0, 230));
                            };
                            Thread thread = new Thread(runnable);
                            thread.start();
                        }
                    }
                    if (worldNow.listOfQuests.size() > worldNow.amountOfCompletedQuests) {
                        if (!worldNow.listOfQuests.get(worldNow.amountOfCompletedQuests).isCompleted()) {
                            textOfQuests.setText(" Квесты:\n " + worldNow.listOfQuests.get(worldNow.amountOfCompletedQuests).getNumberOfQuest() + ". "
                                    + worldNow.listOfQuests.get(worldNow.amountOfCompletedQuests).getGoal() + "\n Добыто: "
                                    + worldNow.listOfQuests.get(worldNow.amountOfCompletedQuests).getReachCards().size() + "/"
                                    + worldNow.listOfQuests.get(worldNow.amountOfCompletedQuests).getGoalNumber() + ".");
                            if (!worldNow.listOfQuests.get(worldNow.amountOfCompletedQuests).isNow()) {
                                worldNow.listOfQuests.get(worldNow.amountOfCompletedQuests).setNow(true);
                            }
                        } else {
                            for (Quest quest : worldNow.listOfQuests) {
                                quest.setNow(false);
                            }
                            worldNow.amountOfCompletedQuests++;
                        }
                    } else {
                        textOfQuests.setText(" Все квесты\n пройдены!\n Поздравляем!");
                    }
                    timerStatementRepaint = 0;
                } else {
                    timerStatementRepaint++;
                }
                if (isHitBoxMode) {
                    g.setColor(new Color(240, 50, 50));
                    g.drawLine(xOfPlayerOnFrame, yOfPlayerOnFrame, xOfPlayerOnFrame, yOfPlayerOnFrame + iconPlayer.getHeight(null) / 2);
                    g.drawLine(xOfPlayerOnFrame, yOfPlayerOnFrame, xOfPlayerOnFrame, yOfPlayerOnFrame - iconPlayer.getHeight(null) / 2);
                    g.drawLine(xOfPlayerOnFrame, yOfPlayerOnFrame, xOfPlayerOnFrame + iconPlayer.getWidth(null) / 2, yOfPlayerOnFrame);
                    g.drawLine(xOfPlayerOnFrame, yOfPlayerOnFrame, xOfPlayerOnFrame - iconPlayer.getWidth(null) / 2, yOfPlayerOnFrame);

                    for (Essence essence : worldNow.listOfEssences) {
                        g.drawLine(essence.xOnFrame, essence.yOnFrame, essence.xOnFrame, essence.yOnFrame + iconPlayer.getHeight(null) / 2);
                        g.drawLine(essence.xOnFrame, essence.yOnFrame, essence.xOnFrame, essence.yOnFrame - iconPlayer.getHeight(null) / 2);
                        g.drawLine(essence.xOnFrame, essence.yOnFrame, essence.xOnFrame + iconPlayer.getWidth(null) / 2, essence.yOnFrame);
                        g.drawLine(essence.xOnFrame, essence.yOnFrame, essence.xOnFrame - iconPlayer.getWidth(null) / 2, essence.yOnFrame);

                        g.drawLine(essence.xOnFrame-5, essence.yOnFrame-5, essence.xOnFrame+5, essence.yOnFrame-5);
                        g.drawLine(essence.xOnFrame-5, essence.yOnFrame-5, essence.xOnFrame-5, essence.yOnFrame+5);
                        g.drawLine(essence.xOnFrame+5, essence.yOnFrame+5, essence.xOnFrame-5, essence.yOnFrame+5);
                        g.drawLine(essence.xOnFrame+5, essence.yOnFrame+5, essence.xOnFrame+5, essence.yOnFrame-5);
                    }
                    for (GameObject gameObject : worldNow.listOfObjects) {
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
                }

                break;
            case 3:
                paintObject(colorGameInventorySlotsBackground, 0, 0, mainFrame.getWidth(), mainFrame.getHeight(), "Rect", g);

                paintObject(colorGameHandBackground1, 10, mainFrame.getHeight() - (mainFrame.getWidth() / 10 * 15 / 10 + 10) - 30, mainFrame.getWidth() / 10, mainFrame.getWidth() / 10 * 15 / 10, "Rect", g);
                paintObject(colorGameHandBackground2, 20, mainFrame.getHeight() - (mainFrame.getWidth() / 10 * 15 / 10) - 30, mainFrame.getWidth() / 10 - 20, mainFrame.getWidth() / 10 * 15 / 10 - 20, "Rect", g);
                paintObject(colorGameHandBackground1, mainFrame.getWidth() - (mainFrame.getWidth() / 10 + 10) - 10, mainFrame.getHeight() - (mainFrame.getWidth() / 10 * 15 / 10 + 10) - 30, mainFrame.getWidth() / 10, mainFrame.getWidth() / 10 * 15 / 10, "Rect", g);
                paintObject(colorGameHandBackground2, mainFrame.getWidth() - (mainFrame.getWidth() / 10 + 10), mainFrame.getHeight() - (mainFrame.getWidth() / 10 * 15 / 10) - 30, mainFrame.getWidth() / 10 - 20, mainFrame.getWidth() / 10 * 15 / 10 - 20, "Rect", g);
                paintObject(colorGameHandBackground1, mainFrame.getWidth() - 250, 20, 220, 220, "Rect", g);

                int y3 = mainFrame.getHeight() - 60;
                int x3 = mainFrame.getWidth() /3 + 75;
                for (int h = 0; h < worldNow.maxHealth; h++) {
                    if (h % 10 == 0) {
                        y3 -= 40;
                        x3 = mainFrame.getWidth() / 5;
                    }
                    paintObject(colorMaxHealth, x3, y3, 30, 30, "Rect", g);
                    x3 += 40;
                }

                int y2 = mainFrame.getHeight() - 60;
                int x2 = mainFrame.getWidth() /3 + 75;
                for (int h = 0; h < worldNow.health; h++) {
                    if (h % 10 == 0) {
                        y2 -= 40;
                        x2 = mainFrame.getWidth() / 5;
                    }
                    paintObject(colorHealth, x2, y2, 30, 30, "Rect", g);
                    x2 += 40;
                }
                break;
        }
    }
    private void paintTypeObjects(String type, String name, String shape, Graphics g) {
        int lengthOfList = -1;
        switch (type) {
            case "Object":
                lengthOfList = worldNow.listOfObjects.size() - 1;
                break;
            case "Essence":
                lengthOfList = worldNow.listOfEssences.size() - 1;
                break;
        }
        while (lengthOfList >= 0) {
            switch (type) {
                case "Object":
                    if (worldNow.listOfObjects.get(lengthOfList).name.equals(name)) {
                        g.setColor(worldNow.listOfObjects.get(lengthOfList).color);
                        switch (shape) {
                            case "Rect":
                                g.fillRect(worldNow.listOfObjects.get(lengthOfList).xOnFrame, worldNow.listOfObjects.get(lengthOfList).yOnFrame, worldNow.listOfObjects.get(lengthOfList).width, worldNow.listOfObjects.get(lengthOfList).height);
                            case "Oval":
                                g.fillOval(worldNow.listOfObjects.get(lengthOfList).xOnFrame, worldNow.listOfObjects.get(lengthOfList).yOnFrame, worldNow.listOfObjects.get(lengthOfList).width, worldNow.listOfObjects.get(lengthOfList).height);
                        }
                    }
                    lengthOfList--;
                    break;
                case "Essence":
                    if (worldNow.listOfEssences.get(lengthOfList).name.equals(name)) {
                        g.setColor(worldNow.listOfEssences.get(lengthOfList).color);
                        switch (shape) {
                            case "Rect":
                                g.fillRect(worldNow.listOfEssences.get(lengthOfList).xOnFrame, worldNow.listOfEssences.get(lengthOfList).yOnFrame, worldNow.listOfEssences.get(lengthOfList).width, worldNow.listOfEssences.get(lengthOfList).height);
                            case "Oval":
                                g.fillOval(worldNow.listOfEssences.get(lengthOfList).xOnFrame, worldNow.listOfEssences.get(lengthOfList).yOnFrame, worldNow.listOfEssences.get(lengthOfList).width, worldNow.listOfEssences.get(lengthOfList).height);
                        }
                    }
                    lengthOfList--;
                    break;
            }
        }
    }
    private void paintImageTypeObjects(String type, String name, Graphics g) {
        int lengthOfList = -1;
        switch (type) {
            case "Object":
                lengthOfList = worldNow.listOfObjects.size() - 1;
                break;
            case "Essence":
                lengthOfList = worldNow.listOfEssences.size() - 1;
                break;
        }
        while (lengthOfList >= 0) {
            switch (type) {
                case "Object":
                    if (worldNow.listOfObjects.get(lengthOfList).name.equals(name)) {
                        g.drawImage(worldNow.listOfObjects.get(lengthOfList).isNearby ? worldNow.listOfObjects.get(lengthOfList).iconOfNearby : worldNow.listOfObjects.get(lengthOfList).iconOfFar, worldNow.listOfObjects.get(lengthOfList).isNearby ? worldNow.listOfObjects.get(lengthOfList).xOnFrame - worldNow.listOfObjects.get(lengthOfList).iconOfNearby.getWidth(null)/2 : worldNow.listOfObjects.get(lengthOfList).xOnFrame - worldNow.listOfObjects.get(lengthOfList).iconOfFar.getWidth(null)/2, worldNow.listOfObjects.get(lengthOfList).isNearby ? worldNow.listOfObjects.get(lengthOfList).yOnFrame - worldNow.listOfObjects.get(lengthOfList).iconOfNearby.getHeight(null)/2 : worldNow.listOfObjects.get(lengthOfList).yOnFrame - worldNow.listOfObjects.get(lengthOfList).iconOfFar.getHeight(null)/2, this);
                    }
                    lengthOfList--;
                    break;
                case "Essence":
                    if (worldNow.listOfEssences.get(lengthOfList).name.equals(name)) {
                        g.drawImage(worldNow.listOfEssences.get(lengthOfList).icon, worldNow.listOfEssences.get(lengthOfList).xOnFrame - worldNow.listOfEssences.get(lengthOfList).icon.getWidth(null)/2, worldNow.listOfEssences.get(lengthOfList).yOnFrame - worldNow.listOfEssences.get(lengthOfList).icon.getHeight(null)/2, this);
                    }
                    lengthOfList--;
                    break;
            }
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
