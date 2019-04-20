package Client.Mechanic;

import javax.swing.*;
import java.awt.*;

import static Client.Mechanic.GameGUI.*;

public class DrawPanel extends JPanel {
    protected void paintComponent(Graphics g) {
        switch (phase) {
            case 0:
                super.paintComponent(g);
                g.setColor(colorStartBackground);
                g.fillRect(0, 0, 1000, 1000);
                g.setColor(colorStartPictureBackground);
                g.fillRect(0, 0, 600, 180);
                g.setColor(colorStartPictureBlue);
                g.fillOval(90, 100, 60, 60);
                g.setColor(colorStartPictureRed);
                g.fillOval(460, 80, 60, 60);
                g.fillOval(300, 20, 60, 60);
                g.setColor(colorStartPartitions);
                g.fillRect(0, 180, 600, 20);
                g.fillRect(0, 500, 600, 20);
                if (!nick.equals("") && age != 0 && !password.equals("")) {
                    g.setColor(colorStartLabelAccountBackground);
                    g.fillRect(20, 535, 260, 50);
                }
                break;
            case 1:
                super.paintComponent(g);
                g.setColor(colorGameBackground);
                g.fillRect(0, 0, widthOfFrame, heightOfFrame);
                g.setColor(colorGamePlayerBackground);
                g.fillOval(xOfPlayer - helpGroundXMinus, yOfPlayer - helpGroundYMinus, 50, 50);

                int v = listOfObjects.size() - 1;
                while (v >= 0) {
                    if (listOfObjects.get(v).name.equals("Золото")) {
                        g.setColor(listOfObjects.get(v).color);
                        g.fillOval(listOfObjects.get(v).x, listOfObjects.get(v).y, listOfObjects.get(v).width, listOfObjects.get(v).height);
                    }
                    v--;
                }
                int w = listOfObjects.size() - 1;
                while (w >= 0) {
                    if (listOfObjects.get(w).name.equals("Вода")) {
                        g.setColor(listOfObjects.get(w).color);
                        g.fillOval(listOfObjects.get(w).x, listOfObjects.get(w).y, listOfObjects.get(w).width, listOfObjects.get(w).height);
                    }
                    w--;
                }

                g.setColor(colorGamePlayer);
                g.fillOval(960, 570, 10, 10);
                Image image = new ImageIcon("/home/creeper/Изображения/Нищий.gif").getImage();
                g.drawImage(image, 935, 545, this);

                int q = listOfEssences.size() - 1;
                while (q >= 0) {
                    if (listOfEssences.get(q).name.equals("Волк")) {
                        g.setColor(listOfEssences.get(q).color);
                        g.fillOval(listOfEssences.get(q).x, listOfEssences.get(q).y, listOfEssences.get(q).width, listOfEssences.get(q).height);
                    }
                    q--;
                }

                int y = listOfObjects.size() - 1;
                while (y >= 0) {
                    if (listOfObjects.get(y).name.equals("Камень")) {
                        g.setColor(listOfObjects.get(y).color);
                        g.fillRect(listOfObjects.get(y).x, listOfObjects.get(y).y, listOfObjects.get(y).width, listOfObjects.get(y).height);
                    }
                    y--;
                }
                int z = listOfObjects.size() - 1;
                while (z >= 0) {
                    if (listOfObjects.get(z).name.equals("Маленький камень")) {
                        g.setColor(listOfObjects.get(z).color);
                        g.fillRect(listOfObjects.get(z).x, listOfObjects.get(z).y, listOfObjects.get(z).width, listOfObjects.get(z).height);
                    }
                    z--;
                }

                int x = listOfObjects.size() - 1;
                while (x >= 0) {
                    if (listOfObjects.get(x).name.equals("Древесина")) {
                        g.setColor(listOfObjects.get(x).color);
                        g.fillOval(listOfObjects.get(x).x, listOfObjects.get(x).y, listOfObjects.get(x).width, listOfObjects.get(x).height);
                    }
                    x--;
                }
                g.setColor(colorGameHandBackground1);
                g.fillRect(10, heightOfFrame - (widthOfFrame / 10 * 15 / 10 + 10), widthOfFrame / 10, widthOfFrame / 10 * 15 / 10);
                g.setColor(colorGameHandBackground2);
                g.fillRect(20, heightOfFrame - (widthOfFrame / 10 * 15 / 10), widthOfFrame / 10 - 20, widthOfFrame / 10 * 15 / 10 - 20);

                g.setColor(colorGameHandBackground1);
                g.fillRect(widthOfFrame - (widthOfFrame / 10 + 10), heightOfFrame - (widthOfFrame / 10 * 15 / 10 + 10), widthOfFrame / 10, widthOfFrame / 10 * 15 / 10);
                g.setColor(colorGameHandBackground2);
                g.fillRect(widthOfFrame - (widthOfFrame / 10 + 10) + 10, heightOfFrame - (widthOfFrame / 10 * 15 / 10), widthOfFrame / 10 - 20, widthOfFrame / 10 * 15 / 10 - 20);

                for (int u = health; u > 0; u--) {
                    g.setColor(colorHealth);
//                    g.fillRect();
                }

                gameFrame.setLayout(null);
                labelNick.setText(nick);
                labelNick.setBounds(xOfPlayer - 30, yOfPlayer - 35, 80, 20);
                gameFrame.setLayout(new BorderLayout());
                break;
            case 2:
                super.paintComponent(g);
                g.setColor(colorGameInventorySlotsBackground);
                g.fillRect(0, 0, widthOfFrame, heightOfFrame);
                g.setColor(colorGameHandBackground1);
                g.fillRect(10, heightOfFrame - (widthOfFrame / 10 * 15 / 10 + 10), widthOfFrame / 10, widthOfFrame / 10 * 15 / 10);
                g.setColor(colorGameHandBackground2);
                g.fillRect(20, heightOfFrame - (widthOfFrame / 10 * 15 / 10), widthOfFrame / 10 - 20, widthOfFrame / 10 * 15 / 10 - 20);

                g.setColor(colorGameHandBackground1);
                g.fillRect(widthOfFrame - (widthOfFrame / 10 + 10), heightOfFrame - (widthOfFrame / 10 * 15 / 10 + 10), widthOfFrame / 10, widthOfFrame / 10 * 15 / 10);
                g.setColor(colorGameHandBackground2);
                g.fillRect(widthOfFrame - (widthOfFrame / 10 + 10) + 10, heightOfFrame - (widthOfFrame / 10 * 15 / 10), widthOfFrame / 10 - 20, widthOfFrame / 10 * 15 / 10 - 20);
                break;
        }
    }
}
