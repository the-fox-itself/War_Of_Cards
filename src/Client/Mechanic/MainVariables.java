package Client.Mechanic;

import Client.Objects.Account;
import Client.Objects.World;

import javax.swing.*;
import java.awt.*;

public abstract class MainVariables {
    static Account accountNow;
    public static World worldNow;

    //Объекты GUI и вспомогательные примитивы.
    final static Color colorStartBackground = new Color(0x20EBFF);
    final static Color colorStartPictureBackground = new Color(0x38FF89);
    final static Color colorStartPictureBlue = new Color(0x0214FF);
    final public static Color colorStartPictureRed = new Color(0xFF0428);
    final static Color colorStartPartitions = new Color(0x919191);
//    final static Color colorStartLabelAccountBackground = new Color(0xFABF58);
//    final static Color colorGameBackground = new Color(0x30FFB3);
//    final public static Color colorGameBackgroundForMaterials = new Color(0x1EFFA1);
    final static Color colorGamePlayerBackground = new Color(0x25D196);
//    final public static Color colorGameWolf = new Color(0x302C32);
    final static Color colorGameHandBackground1 = new Color(0x5F2F16);
    final static Color colorGameHandBackground2 = new Color(0xA06328);
    final static Color colorGameInventorySlotsBackground = new Color(0xF99124);
//    static Color colorStone = new Color(0x778388);
    final public static Color colorWater = new Color(0x13A2FF);
//    final static Color colorWood = new Color(0x3DDD2D);
//    final public static Color colorSmallStone = new Color(0x323941);
//    final static Color colorStoneNearby = new Color(0x3A4B50);
//    final static Color colorWoodNearby = new Color(0x227E22);
//    final static Color colorSmallStoneNearby = new Color(0x000000);
//    final static Color colorDiamondNearby = new Color(0x77F0DD);
//    final static Color colorGoldNearby = new Color(0xEEF000);
    final static Color colorWaterNearby = new Color(0x1259A3);
    final static Color colorHealth = new Color(0xD80011);
    final static Color colorMaxHealth = new Color(0x6E343634, true);


//    final static Image iconPlayerFront = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"PlayerFront.gif").getImage();
//    final static Image iconPlayerBack = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"PlayerBack.gif").getImage();
//    final static Image iconPlayerLeft = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"PlayerLeft.gif").getImage();
//    final static Image iconPlayerRight = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"PlayerRight.gif").getImage();
//    final static Image iconPlayerFrontStay = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"PlayerFrontStay.png").getImage();
//    final static Image iconPlayerBackStay = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"PlayerBackStay.png").getImage();
//    final static Image iconPlayerLeftStay = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"PlayerLeftStay.png").getImage();
//    final static Image iconPlayerRightStay = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"PlayerRightStay.png").getImage();
//    static Image iconPlayer = iconPlayerFrontStay;
//
//    final public static Image iconWolfRight = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"Wolf Right.png").getImage();
//    final static Image iconWolfLeft = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"Wolf Left.png").getImage();
//    final public static Image iconWood = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"Wood.png").getImage();
//    final public static Image iconWoodNearby = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"WoodNearby.png").getImage();
//    final public static Image iconStone = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"Stone.png").getImage();
//    final public static Image iconStoneNearby = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"StoneNearby.png").getImage();
//    final public static Image iconSmallStone = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"SmallStone.png").getImage();
//    final public static Image iconSmallStoneNearby = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"SmallStoneNearby.png").getImage();
//    final public static Image iconUndergroundObject = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"UndergroundObject.png").getImage();
//    final public static Image iconGoldNearby = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"GoldNearby.png").getImage();
//    final public static Image iconDiamondNearby = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"DiamondNearby.png").getImage();
//    final public static Image iconGroundGrass = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"GroundGrass.png").getImage();
//    final public static Image iconGroundWater = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"GroundWater.png").getImage();


    final static Image iconPlayerFront = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\PlayerFrontStay.png").getImage();
    final static Image iconPlayerBack = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\PlayerBackStay.png").getImage();
    final static Image iconPlayerLeft = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\PlayerLeftStay.png").getImage();
    final static Image iconPlayerRight = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\PlayerRightStay.png").getImage();
    final static Image iconPlayerFrontStay = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\PlayerFrontStay.png").getImage();
    final static Image iconPlayerBackStay = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\PlayerBackStay.png").getImage();
    final static Image iconPlayerLeftStay = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\PlayerLeftStay.png").getImage();
    final static Image iconPlayerRightStay = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\PlayerRightStay.png").getImage();
    static Image iconPlayer = iconPlayerFrontStay;

    final public static Image iconWolfRight = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\Wolf Right.png").getImage();
    final static Image iconWolfLeft = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\Wolf Left.png").getImage();
    final public static Image iconWood = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\Wood.png").getImage();
    final public static Image iconWoodNearby = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\WoodNearby.png").getImage();
    final public static Image iconStone = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\Stone.png").getImage();
    final public static Image iconStoneNearby = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\StoneNearby.png").getImage();
    final public static Image iconSmallStone = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\SmallStone.png").getImage();
    final public static Image iconSmallStoneNearby = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\SmallStoneNearby.png").getImage();
    final public static Image iconUndergroundObject = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\UndergroundObject.png").getImage();
    final public static Image iconGoldNearby = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\GoldNearby.png").getImage();
    final public static Image iconDiamondNearby = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\DiamondNearby.png").getImage();
    final public static Image iconGroundGrass = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\GroundGrass.png").getImage();
    final public static Image iconGroundWater = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\v0.3sn0.5.1\\resources\\images\\GroundWater.png").getImage();


    final static int widthOfScreen = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    final static int heightOfScreen = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public static int xOfPlayerOnFrame = widthOfScreen / 2;
    public static int yOfPlayerOnFrame = heightOfScreen / 2;

    static boolean isNewAccount;

    static boolean gameIsStartedOrNot = false;
    static boolean isRepaint = true;
    static boolean isRunnablePrepared = false;
    static boolean isResizable = false;

    static boolean isWPressed = false;
    static boolean isAPressed = false;
    static boolean isSPressed = false;
    static boolean isDPressed = false;

    static boolean iswPressed = false;
    static boolean isaPressed = false;
    static boolean issPressed = false;
    static boolean isdPressed = false;

    static boolean is1Pressed = false;
    static boolean is2Pressed = false;
    static boolean is3Pressed = false;
    static boolean is4Pressed = false;

    static int phaseOfRepaint = 1;

    static int timerStatement = 0;
    static int timerStatementRepaint = 0;
    static int timerStatementHP = 0;
    final static int timeForTakingAHealth = 8;
    static int timeForRunnable = 0;

    final static JFrame mainFrame = new JFrame("War Of Cards Pre-dev 0.2");

    final static JButton buttonNewAccount = new JButton("Регистрация");
    final static JButton buttonLoadAccount = new JButton("Вход");
    final static JButton buttonLoadAccountFromNewAccount = new JButton("Уже есть аккаунт?");
    final static JButton buttonNewAccountFromLoadAccount = new JButton("Ещё нет аккаунта?");
    final static JButton buttonNewWorld = new JButton("Создать");
    final static JButton buttonSaveAccount = new JButton("Сохранить аккаунт");
    final static JButton buttonLoadWorld = new JButton("Загрузить");
    final static JButton buttonExit = new JButton("Выйти");
    final static JButton buttonSettings = new JButton("Настройки");
    final static JButton buttonRegistrationBack = new JButton("Назад");
    final static JButton buttonEndRegistration = new JButton("Зарегестрироваться");
    final static JButton buttonRight = new JButton(">");
    final static JButton buttonLeft = new JButton("<");

    final static JButton buttonPantsClothes = new JButton();
    final static JButton buttonShirtClothes = new JButton();

    final static JButton buttonPantsSlots = new JButton();
    final static JButton buttonShirtSlots = new JButton();
    final static JButton buttonHandsSlots = new JButton("Ручной инвентарь");

    final static JLabel labelNewAccount = new JLabel("Новый аккаунт");
    final static JLabel labelRegisterNick = new JLabel("Логин");
    final static JLabel labelRegisterPassword = new JLabel("Пароль");
    final static JLabel labelAccount = new JLabel("Вы не авторизованы");
    final static JLabel labelWarning = new JLabel();
    final static JLabel labelSlots = new JLabel("Слоты");
    final static JLabel labelNick = new JLabel();
    final static JLabel labelNotification = new JLabel("");
    final static JLabel labelSaveAccount = new JLabel();

    final static JTextField textNick = new JTextField();
    final static JTextField textPassword = new JPasswordField();

    final static JTextField textNameForNewWorld = new JTextField();

    final static JTextArea textOfQuests = new JTextArea();

    final static JComboBox comboBoxForLoadWorld = new JComboBox();

    final static Font f90 = new Font("", Font.BOLD, 90);
    final static Font f80 = new Font("", Font.BOLD, 80);
    final static Font f70 = new Font("", Font.BOLD, 70);
    final static Font f60 = new Font("", Font.BOLD, 60);
    final static Font f50 = new Font("", Font.BOLD, 50);
    final static Font f45 = new Font("", Font.BOLD, 45);
    final static Font f40 = new Font("", Font.BOLD, 40);
    final static Font f35 = new Font("", Font.BOLD, 35);
    final static Font f32 = new Font("", Font.BOLD, 32);
    final static Font f30 = new Font("", Font.BOLD, 30);
    final static Font f25 = new Font("", Font.BOLD, 25);
    final static Font f20 = new Font("", Font.BOLD, 20);
    final static Font f17 = new Font("", Font.BOLD, 17);
    final static Font f15 = new Font("", Font.BOLD, 15);

    static void visTrue(Component component) {
        component.setVisible(true);
    }
    static void visFalse(Component component) {
        component.setVisible(false);
    }
    static void setComponentOnFrame(JFrame frame, Component component, Font font, int x, int y, int width, int height) {
        frame.add(component);
        component.setBounds(x, y, width, height);
        component.setFont(font);
        visFalse(component);
    }

    MainVariables() {
        System.out.println("Creating object of class MainVariables...");
        System.out.println("Finished creating object of class MainVariables.");
    }
}
