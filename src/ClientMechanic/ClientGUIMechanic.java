package ClientMechanic;

import javax.swing.*;

import static GameMechanic.GameGUIListeners.*;
import static GameMechanic.GameMainVariables.*;
import static GameMechanic.GameMechanic.menuStartNotRegistered;

import java.awt.*;
import java.io.*;

class ClientGUIMechanic {
    final public static ClientDrawPanel clientDrawPanel = new ClientDrawPanel();

    void preparationGUI() {
        // Loading fonts
        try {
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(Font.createFont(Font.TRUETYPE_FONT, FONT_ALUNDRA_TEXT));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

//        labelWarningNeedRegistration.setBounds();

        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setUndecorated(fullscreenOn);

        frame.add(clientDrawPanel);
        clientDrawPanel.setBounds(0, 0, FRAME_SIZE.width, FRAME_SIZE.height);

        textQuests.setLineWrap(true);
        textQuests.setWrapStyleWord(true);
        textQuests.setEditable(false);

        textQuests.addKeyListener(new MainFrameKeyListener());
        textQuests.addMouseListener(new MainFrameMouseListener());
        textQuests.addMouseMotionListener(new MainFrameMouseMotionListener());

        gameLoopOn = true;
        gameLoop.start();
        menuStartNotRegistered();

//        JPanel panel = new JPanel(new FlowLayout());
//        frame.add(panel);
//        panel.setBounds(frame.getWidth()/3, playerYFrame-100, frame.getWidth()/3, playerYFrame+100);
//        labelNick.setFont(f15);
//        labelNick.setForeground(COLOR_INTERFACE_ORANGE);
//        panel.add(labelNick);
        labelNick.setHorizontalAlignment(JLabel.CENTER);
        labelNick.setVerticalTextPosition(SwingConstants.CENTER);
        System.out.println(labelNick.getX());
    }
}