package Client.Mechanic;

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
                paintObject(colorStartBackground, 0, 0, 1000, 1000, "Rect", g);
                paintObject(colorStartPictureBackground, 0, 0, 600, 180, "Rect", g);
                paintObject(colorStartPictureBlue, 90, 100, 60, 60, "Oval", g);
                paintObject(colorStartPictureRed, 460, 80, 60, 60, "Oval", g);
                paintObject(colorStartPictureRed, 300, 20, 60, 60, "Oval", g);
                paintObject(colorStartPartitions, 0, 180, 600, 20, "Rect", g);
                paintObject(colorStartPartitions, 0, 500, 600, 20, "Rect", g);

//                if (!textNick.getText().equals("") && !textAge.getText().equals("") && !textPassword.getText().equals(""))
//                    paintObject(colorStartLabelAccountBackground, 20, 535, 260, 50, "Rect", g);
                break;
            case 2:
                paintObject(colorGameBackground, 0, -5, widthOfFrame, heightOfFrame, "Rect", g);
                paintObject(colorGamePlayerBackground, xOfPlayerOnFrame - 20, yOfPlayerOnFrame - 20 + 10, 40, 30, "Oval", g);

                paintImageTypeObjects("Object", "Gold", g);
                paintImageTypeObjects("Object", "Diamond", g);
                paintTypeObjects("Object", "Water", "Oval", g);
                g.drawImage(iconOfPlayer, xOfPlayerOnFrame - iconOfPlayer.getWidth(this)/2, (yOfPlayerOnFrame - iconOfPlayer.getHeight(this)/2) - 15, this);
                paintImageTypeObjects("Essence", "Wolf", g);
                paintImageTypeObjects("Object", "Stone", g);
                paintImageTypeObjects("Object", "SmallStone", g);
                paintImageTypeObjects("Object", "Wood", g);
                paintTypeObjects("Object", "Barrier", "Rect", g);

                paintObject(colorGameHandBackground1, 10, heightOfFrame - (widthOfFrame / 10 * 15 / 10 + 10) - 30, widthOfFrame / 10, widthOfFrame / 10 * 15 / 10, "Rect", g);
                paintObject(colorGameHandBackground2, 20, heightOfFrame - (widthOfFrame / 10 * 15 / 10) - 30, widthOfFrame / 10 - 20, widthOfFrame / 10 * 15 / 10 - 20, "Rect", g);
                paintObject(colorGameHandBackground1, widthOfFrame - (widthOfFrame / 10 + 10) - 10, heightOfFrame - (widthOfFrame / 10 * 15 / 10 + 10) - 30, widthOfFrame / 10, widthOfFrame / 10 * 15 / 10, "Rect", g);
                paintObject(colorGameHandBackground2, widthOfFrame - (widthOfFrame / 10 + 10), heightOfFrame - (widthOfFrame / 10 * 15 / 10) - 30, widthOfFrame / 10 - 20, widthOfFrame / 10 * 15 / 10 - 20, "Rect", g);
                paintObject(colorGameHandBackground1, widthOfFrame - 250, 20, 220, 220, "Rect", g);

                int y = heightOfFrame - 60;
                int x = widthOfFrame/3 + 75;
                for (int h = 0; h < worldNow.maxHealth; h++) {
                    if (h % 10 == 0) {
                        y -= 40;
                        x = widthOfFrame/5;
                    }
                    paintObject(colorMaxHealth, x, y, 30, 30, "Rect", g);
                    x += 40;
                }

                int y1 = heightOfFrame - 60;
                int x1 = widthOfFrame/3 + 75;
                for (int h = 0; h < worldNow.health; h++) {
                    if (h % 10 == 0) {
                        y1 -= 40;
                        x1 = widthOfFrame/5;
                    }
                    paintObject(colorHealth, x1, y1, 30, 30, "Rect", g);
                    x1 += 40;
                }

                mainFrame.setLayout(null);
                labelNick.setText(accountNow.nick);
                labelNick.setBounds(xOfPlayerOnFrame - 30, yOfPlayerOnFrame - 55, 80, 20);
//                String questText;
//                for (Quest quest : quests) {
//
//                }
//                textOfQuests.setText(" Квесты:\n " + quests.get(amountOfCompetedQuests).numberOfQuest + ". " + quests.get(amountOfCompetedQuests).getGoal() + "\n Добыто: " + quests.get(amountOfCompetedQuests).getReachNumber() + "/" + quests.get(amountOfCompetedQuests).getGoalNumber() + ".");
                textOfQuests.setBounds(widthOfFrame - 240, 30, 200, 200);
                mainFrame.setLayout(new BorderLayout());

                break;
            case 3:
                paintObject(colorGameInventorySlotsBackground, 0, 0, widthOfFrame, heightOfFrame, "Rect", g);

                paintObject(colorGameHandBackground1, 10, heightOfFrame - (widthOfFrame / 10 * 15 / 10 + 10) - 30, widthOfFrame / 10, widthOfFrame / 10 * 15 / 10, "Rect", g);
                paintObject(colorGameHandBackground2, 20, heightOfFrame - (widthOfFrame / 10 * 15 / 10) - 30, widthOfFrame / 10 - 20, widthOfFrame / 10 * 15 / 10 - 20, "Rect", g);
                paintObject(colorGameHandBackground1, widthOfFrame - (widthOfFrame / 10 + 10) - 10, heightOfFrame - (widthOfFrame / 10 * 15 / 10 + 10) - 30, widthOfFrame / 10, widthOfFrame / 10 * 15 / 10, "Rect", g);
                paintObject(colorGameHandBackground2, widthOfFrame - (widthOfFrame / 10 + 10), heightOfFrame - (widthOfFrame / 10 * 15 / 10) - 30, widthOfFrame / 10 - 20, widthOfFrame / 10 * 15 / 10 - 20, "Rect", g);
                paintObject(colorGameHandBackground1, widthOfFrame - 250, 20, 220, 220, "Rect", g);

                int y3 = heightOfFrame - 60;
                int x3 = widthOfFrame/3 + 75;
                for (int h = 0; h < worldNow.maxHealth; h++) {
                    if (h % 10 == 0) {
                        y3 -= 40;
                        x3 = widthOfFrame/5;
                    }
                    paintObject(colorMaxHealth, x3, y3, 30, 30, "Rect", g);
                    x3 += 40;
                }

                int y2 = heightOfFrame - 60;
                int x2 = widthOfFrame/3 + 75;
                for (int h = 0; h < worldNow.health; h++) {
                    if (h % 10 == 0) {
                        y2 -= 40;
                        x2 = widthOfFrame/5;
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
