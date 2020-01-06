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
    final static Color colorStartLabelAccountBackground = new Color(0xFABF58);
    final static Color colorGameBackground = new Color(0x30FFB3);
//    final public static Color colorGameBackgroundForMaterials = new Color(0x1EFFA1);
    final static Color colorGamePlayerBackground = new Color(0x25D196);
    final public static Color colorGameWolf = new Color(0x302C32);
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

//    final static Image iconOfPlayer = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"Player.png").getImage();
//    final public static Image iconOfWolfRight = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"Wolf.png").getImage();
//    final public static Image iconOfWood = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"Wood.png").getImage();
//    final public static Image iconOfWoodNearby = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"WoodNearby.png").getImage();
//    final public static Image iconOfStone = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"Stone.png").getImage();
//    final public static Image iconOfStoneNearby = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"StoneNearby.png").getImage();
//    final public static Image iconOfSmallStone = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"SmallStone.png").getImage();
//    final public static Image iconOfSmallStoneNearby = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"SmallStoneNearby.png").getImage();
//    final public static Image iconOfUndergroundObject = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"UndergroundObject.png").getImage();
//    final public static Image iconOfGoldNearby = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"GoldNearby.png").getImage();
//    final public static Image iconOfDiamondNearby = new ImageIcon("resources"+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+"DiamondNearby.png").getImage();

    final static Image iconOfPlayer = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\0.0.0.2.1\\resources\\images\\Player.png").getImage();
    final public static Image iconOfWolfRight = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\0.0.0.2.1\\resources\\images\\Wolf Right.png").getImage();
    final static Image iconOfWolfLeft = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\0.0.0.2.1\\resources\\images\\Wolf Left.png").getImage();
    final public static Image iconOfWood = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\0.0.0.2.1\\resources\\images\\Wood.png").getImage();
    final public static Image iconOfWoodNearby = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\0.0.0.2.1\\resources\\images\\WoodNearby.png").getImage();
    final public static Image iconOfStone = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\0.0.0.2.1\\resources\\images\\Stone.png").getImage();
    final public static Image iconOfStoneNearby = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\0.0.0.2.1\\resources\\images\\StoneNearby.png").getImage();
    final public static Image iconOfSmallStone = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\0.0.0.2.1\\resources\\images\\SmallStone.png").getImage();
    final public static Image iconOfSmallStoneNearby = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\0.0.0.2.1\\resources\\images\\SmallStoneNearby.png").getImage();
    final public static Image iconOfUndergroundObject = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\0.0.0.2.1\\resources\\images\\UndergroundObject.png").getImage();
    final public static Image iconOfGoldNearby = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\0.0.0.2.1\\resources\\images\\GoldNearby.png").getImage();
    final public static Image iconOfDiamondNearby = new ImageIcon("C:\\Users\\Cripton\\Documents\\Projects Intellij Idea\\War Of Cards\\versions\\0.0.0.2.1\\resources\\images\\DiamondNearby.png").getImage();


    final static int widthOfFrame = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    final static int heightOfFrame = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public static int xOfPlayerOnFrame = widthOfFrame / 2;
    public static int yOfPlayerOnFrame = heightOfFrame / 2;

    static boolean isNewAccount;

    static boolean gameIsStartedOrNot = false;
    static boolean isRepaint = true;
    static boolean isRunnablePrepared = false;
    static boolean isQuestsPrepared = false;
    static boolean isAddLabelNick = false;
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
    final static int timeForTakingAHealth = 8;
    static int timeForRunnable = 0;

    final static JFrame startFrame = new JFrame("War Of Cards Pre-dev 0.2");
    final static JFrame registrationFrame = new JFrame("War Of Cards Pre-dev 0.2");
    final static JFrame settingsFrame = new JFrame("War Of Cards Pre-dev 0.2");
    final static JFrame mainFrame = new JFrame("War Of Cards Pre-dev 0.2");

    final static JButton buttonNewAccount = new JButton("Создать аккаунт");
    final static JButton buttonLoadAccount = new JButton("Войти в аккаунт");
    final static JButton buttonLoadAccountFromNewAccount = new JButton("Уже есть аккаунт?");
    final static JButton buttonNewAccountFromLoadAccount = new JButton("Ещё нет аккаунта?");
    final static JButton buttonNewWorld = new JButton("Создать новый мир");
    final static JButton buttonSaveAccount = new JButton("Сохранить аккаунт");
    final static JButton buttonLoadWorld = new JButton("Загрузить мир");
    final static JButton buttonExit = new JButton("Выйти");
    final static JButton buttonSettings = new JButton("Настройки");
    final static JButton buttonRegisterBack = new JButton("Назад");
    final static JButton buttonEndRegister = new JButton("Создать");
    final static JButton buttonRight = new JButton(">");
    final static JButton buttonLeft = new JButton("<");

    final static JButton buttonPantsClothes = new JButton();
    final static JButton buttonShirtClothes = new JButton();

    final static JButton buttonPantsSlots = new JButton();
    final static JButton buttonShirtSlots = new JButton();
    final static JButton buttonHandsSlots = new JButton("Ручной инвентарь");

    final static JLabel labelNewAccount = new JLabel("Новый аккаунт");
    final static JLabel labelRegisterNick = new JLabel("Логин");
    final static JLabel labelRegisterAge = new JLabel("Возраст");
    final static JLabel labelRegisterPassword = new JLabel("Пароль");
    final static JLabel labelAccount = new JLabel();
    final static JLabel labelWarning = new JLabel("Введите целое число");
    final static JLabel labelSlots = new JLabel("Слоты");
    final static JLabel labelNick = new JLabel();

    final static JTextField textNick = new JTextField();
    final static JTextField textAge = new JTextField();
    final static JTextField textPassword = new JPasswordField();

    final static JTextField textNameForNewWorld = new JTextField();

    final static JTextArea textOfQuests = new JTextArea();

    final static JComboBox comboBoxForLoadWorld = new JComboBox();

    final static Font f50 = new Font("", Font.BOLD, 50);
    final static Font f45 = new Font("", Font.BOLD, 45);
    final static Font f40 = new Font("", Font.BOLD, 40);
    final static Font f35 = new Font("", Font.BOLD, 35);
    final static Font f32 = new Font("", Font.BOLD, 32);
    final static Font f30 = new Font("", Font.BOLD, 30);
    final static Font f25 = new Font("", Font.BOLD, 25);
    final static Font f20 = new Font("", Font.BOLD, 20);
    final static Font f15 = new Font("", Font.BOLD, 15);

    MainVariables() {
        System.out.println("Creating object of class MainVariables...");
        System.out.println("Finished creating object of class MainVariables.");
    }
}
