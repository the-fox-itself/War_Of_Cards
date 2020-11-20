package ClientMechanic; //Пакет класса.

import javax.swing.*;

import static GameMechanic.GameGUIListeners.*;
import static GameMechanic.GameMainVariables.*;
import static GameMechanic.GameMechanic.menuStartNotRegistered;
import static Libraries.Methods.*;

//Импорт библиотек API.
import java.awt.*;
import java.io.*;

class ClientGameMechanic {
    ClientGameMechanic() {
        printNote("Creating an object of class ClientGameMechanic", NOTE_TYPE_DONE);
    }

    final public static ClientDrawPanel clientDrawPanel = new ClientDrawPanel();

    void preparationGUI() {
        printNote("Completing method preparationGUI()", NOTE_TYPE_PROCESS);
        try {
            printNote("Loading fonts", NOTE_TYPE_PROCESS);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("resources"+SEPARATOR+"fonts"+SEPARATOR+"AlundraText.ttf")));
            printNote("Loading fonts", NOTE_TYPE_DONE);
        } catch (IOException | FontFormatException e) {
            printNote("Loading fonts", NOTE_TYPE_ERROR);
            e.printStackTrace();
        }
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setUndecorated(false);
        printNote("Screen size: "+(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()+"x"+(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight(), NOTE_TYPE_INFO);
        printNote("Frame size: "+FRAME_WIDTH+"x"+FRAME_HEIGHT, NOTE_TYPE_INFO);

        frame.add(clientDrawPanel);
        clientDrawPanel.setBounds(0, 0, 2000, 2000);
        printNote("Adding object drawPanel on container \"frame\"", NOTE_TYPE_DONE);

        textQuests.setLineWrap(true);
        textQuests.setWrapStyleWord(true);
        textQuests.setEditable(false);

        textQuests.addKeyListener(new MainFrameKeyListener()); //Обработчик событий, выслеживающий нажатия по клавиатуре при открытии окна frame.
        printNote("Adding KeyListener on object textQuests", NOTE_TYPE_DONE);
        textQuests.addMouseListener(new MainFrameMouseListener());
        printNote("Adding MouseListener on object textQuests", NOTE_TYPE_DONE);
        textQuests.addMouseMotionListener(new MainFrameMouseMotionListener());
        printNote("Adding MouseMotionListener on object textQuests", NOTE_TYPE_DONE);

        runnableOn = true;
        gameLoop.start();
        menuStartNotRegistered();
        printNote("Completing method preparationGUI()", NOTE_TYPE_DONE);

        JPanel panel = new JPanel(new FlowLayout());
        frame.add(panel);
        panel.setBounds(frame.getWidth()/3, playerYFrame-100, frame.getWidth()/3, playerYFrame+100);
        labelNick.setFont(f15);
        labelNick.setForeground(COLOR_INTERFACE_ORANGE);
        panel.add(labelNick);
        labelNick.setHorizontalAlignment(JLabel.CENTER);
        labelNick.setVerticalTextPosition(SwingConstants.CENTER);
        System.out.println(labelNick.getX());
    }
}