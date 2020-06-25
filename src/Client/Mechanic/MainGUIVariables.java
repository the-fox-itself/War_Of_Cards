package Client.Mechanic;

import Client.Objects.TechnicalObjects.Account;
import Client.Objects.TechnicalObjects.Player;
import Client.Objects.TechnicalObjects.World;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static Client.Mechanic.SwingPlus.Methods.*;
import static Client.Mechanic.GUIListeners.*;

public abstract class MainGUIVariables {
    MainGUIVariables() {
        printNote("Creating an object of class MainGUIVariables", NOTE_TYPE_DONE);
    }

    final public static String SEPARATOR = System.getProperty("file.separator");

    public static Account accountCurrent;
    public static World worldCurrent;
    public static Player playerCurrent;

    public static int[] intList; //ObjectSortingByY

    //Объекты GUI и вспомогательные примитивы.
    final public static Color COLOR_OBJECT_WATER = new Color(0x13A2FF); //Не используется.
    final static Color COLOR_OBJECT_WATER_NEARBY = new Color(0x1259A3); //Не используется.
    final public static Color COLOR_OBJECT_BARRIER = new Color(0xFF0428);
    final static Color COLOR_GAME_PLAYER_SHADOW = new Color(0x25D196);
    final static Color COLOR_GAME_PLAYER_HEALTH = new Color(0xD80011);
    final static Color COLOR_GAME_PLAYER_HEALTH_BACKGROUND = new Color(0x6E343634, true);
    final static Color COLOR_GAME_INTERFACE_BACK = new Color(0x5F2F16);
    final static Color COLOR_GAME_INTERFACE_FRONT = new Color(0xA06328);
    final static Color COLOR_GAME_INVENTORY_BACKGROUND = new Color(0xB5E68F41, true);

    final static Color COLOR_INTERFACE_YELLOW = new Color(0xF9FF7C);
    final static Color COLOR_INTERFACE_GREEN = new Color(0xFFBBFF7F, true);
    private final static Color COLOR_INTERFACE_TURQUOISE = new Color(0x8F38FF8D, true);
    final static Color COLOR_INTERFACE_ACTIVATE_GREEN = new Color(0xC85EE14B, true);
    final static Color COLOR_INTERFACE_ORANGE = new Color(0xFFC500);


    final static Image ANIMATION_PLAYER_FRONT = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ANIMATION_PLAYER_FRONT.gif").getImage();
    final static Image ANIMATION_PLAYER_BACK = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ANIMATION_PLAYER_BACK.gif").getImage();
    final static Image ANIMATION_PLAYER_LEFT = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ANIMATION_PLAYER_LEFT.gif").getImage();
    final static Image ANIMATION_PLAYER_RIGHT = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ANIMATION_PLAYER_RIGHT.gif").getImage();
    final static Image ICON_PLAYER_FRONT = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_PLAYER_FRONT.png").getImage();
    final static Image ICON_PLAYER_BACK = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_PLAYER_BACK.png").getImage();
    final static Image ICON_PLAYER_LEFT = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_PLAYER_LEFT.png").getImage();
    final static Image ICON_PLAYER_RIGHT = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_PLAYER_RIGHT.png").getImage();
    static Image iconPlayerCurrent = ICON_PLAYER_FRONT;

    final public static Image ICON_WOLF_RIGHT = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_WOLF_RIGHT.png").getImage();
    final static Image ICON_WOLF_LEFT = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_WOLF_LEFT.png").getImage();
    final public static Image ICON_OBJECT_WOOD_1 = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_OBJECT_WOOD_1.png").getImage();
    final public static Image ICON_OBJECT_WOOD_2 = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_OBJECT_WOOD_2.png").getImage();
    final public static Image ICON_OBJECT_WOOD_NEARBY = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_OBJECT_WOOD_NEARBY.png").getImage();
    final public static Image ICON_OBJECT_STONE = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_OBJECT_STONE.png").getImage();
    final public static Image ICON_OBJECT_STONE_NEARBY = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_OBJECT_STONE_NEARBY.png").getImage();
    final public static Image ICON_OBJECT_SMALL_STONE = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_OBJECT_SMALL_STONE.png").getImage();
    final public static Image ICON_OBJECT_SMALL_STONE_NEARBY = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_OBJECT_SMALL_STONE_NEARBY.png").getImage();
    final public static Image ICON_OBJECT_UNDERGROUND = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_OBJECT_UNDERGROUND.png").getImage();
    final public static Image ICON_OBJECT_GOLD_NEARBY = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_OBJECT_GOLD_NEARBY.png").getImage();
    final public static Image ICON_OBJECT_DIAMOND_NEARBY = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_OBJECT_DIAMOND_NEARBY.png").getImage();
    final public static Image ICON_GROUND_GRASS = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_GROUND_GRASS.png").getImage();
    final public static Image ICON_GROUND_WATER = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_GROUND_WATER.png").getImage();

    final public static Image ICON_MENU_BACKGROUND = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_MENU_BACKGROUND.png").getImage();
    final public static Image ICON_MENU_TITLE = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_MENU_TITLE.png").getImage();
    final public static Image ICON_CARD = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"ICON_CARD.png").getImage();


    static Runnable runnableRepaint;
    static Thread threadRepaint = new Thread(runnableRepaint);
    //Нужно сделать продолжение улучшения потоков............................................................

    final static int FRAME_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    final static int FRAME_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public static int playerXFrame = FRAME_WIDTH / 2;
    public static int playerYFrame = FRAME_HEIGHT / 2;

    static boolean accountRegistration;

    public static boolean registered;
    static boolean gameStart;
    static boolean repaintOn = true;
    static boolean regenerationOn;
    static boolean runnableOn;
    static boolean runnablePrepared;
    static boolean resizableOn;

    static boolean inventoryOpen;
    final static int INVENTORY_CLOTHES = 1;
    final static int INVENTORY_SLOTS = 2;
    final static int INVENTORY_CHARACTER = 3;
    static int InventoryOpenPart;
    static boolean hitBoxModeOn;

    static boolean w;
    static boolean a;
    static boolean s;
    static boolean d;
    static boolean W;
    static boolean A;
    static boolean S;
    static boolean D;
    static boolean _1;
    static boolean _2;
    static boolean _3;
    static boolean _4;

    final static int REPAINT_MENU = 1;
    final static int REPAINT_GAME = 2;
    static int repaintPhase = REPAINT_MENU;

    final static int TIME_PLAYER_TAKE_DAMAGE = 8;
    static int timerPlayerTakeDamage;
    final static int TIME_PLAYER_REGENERATION_AFTER_TAKE_DAMAGE = 20;
    final static int TIME_PLAYER_REGENERATION_AFTER_REGENERATION = 10;
    final static int TIME_PLAYER_REGENERATION_GO = 1;
    static int timerPlayerRegeneration;
    final static int TIME_DRAW_PANEL_REPAINT_GAME_GO = 5;
    static int timerDrawPanelRepaintGame;
    final static int TIME_RUNNABLE_DIVIDER_WOLF_PROCESSING = 3;
    final static int TIME_RUNNABLE_DIVIDER_RESOURCE_MINING = 3;
    final static int TIME_RUNNABLE_DIVIDER_SEARCH_NEARBY_OBJECTS = 5;
    final static int TIME_RUNNABLE_END = LCM(TIME_RUNNABLE_DIVIDER_WOLF_PROCESSING, TIME_RUNNABLE_DIVIDER_RESOURCE_MINING, TIME_RUNNABLE_DIVIDER_SEARCH_NEARBY_OBJECTS);
    static int timerMainRunnableActions;

    final static JFrame frame = getFrame("War Of Cards Pre-dev 0.3", FRAME_WIDTH, FRAME_HEIGHT, null, null, resizableOn);

    final static JButton buttonSinglePlayer = getButtonNullLayout("Одиночная игра", f40, frame,
            frame.getWidth()/2 - (frame.getWidth()/4+40)/2, frame.getHeight()/8*4-60,
            frame.getWidth()/4+40, 70, new SinglePlayer(), COLOR_INTERFACE_GREEN, null);
    final static JButton buttonMultiPlayer = getButtonNullLayout("Серверная игра", f40, frame,
            frame.getWidth()/2 - frame.getWidth()/4/2, frame.getHeight()/8*4+80,
            frame.getWidth()/4, 70, new MultiPlayer(), COLOR_INTERFACE_GREEN, null);
    final static JButton buttonRegistration = getButtonNullLayout("Регистрация", f20, frame,
            30, frame.getHeight()-100, 180, 40, new NewAccount(), COLOR_INTERFACE_GREEN, null);
    final static JButton buttonEntry = getButtonNullLayout("Вход", f20, frame,
            230, frame.getHeight()-100, 180, 40, new LoadAccount(), COLOR_INTERFACE_GREEN, null);
    final static JButton buttonLoadAccountFromNewAccount = getButtonNullLayout("Уже есть аккаунт?", f20, frame,
            90, 625, 240, 35, new LoadAccount(), COLOR_INTERFACE_GREEN, null);
    final static JButton buttonNewAccountFromLoadAccount = getButtonNullLayout("Ещё нет аккаунта?", f20, frame,
            90, 625, 240, 35, new NewAccount(), COLOR_INTERFACE_GREEN, null);
    final static JButton buttonNewWorld = getButtonNullLayout("Создать новый мир", f40, frame,
            frame.getWidth()/2-500/2, frame.getHeight()/7*4, 500, 60,
            new NewWorld(), COLOR_INTERFACE_GREEN, null);
    final static JButton buttonLoadWorld = getButtonNullLayout("Загрузить", f50, frame,
            frame.getWidth()/2-400/2, 400, 400, 70, new LoadWorld(), COLOR_INTERFACE_GREEN, null);
    final static JButton buttonExit = getButtonNullLayout("Выйти из игры", f30, frame,
            frame.getWidth()/2+40+ frame.getWidth()/4, frame.getHeight()-100, frame.getWidth()/5, 50,
            new Exit(), COLOR_INTERFACE_GREEN, null);
    final static JButton buttonExitAccount = getButtonNullLayout("Выйти", f20, frame,
            30, frame.getHeight()-100, 150, 40, new ExitAccount(), COLOR_INTERFACE_GREEN, null);
    final static JButton buttonSaveAccount = getButtonNullLayout("Сохранить", f20, frame,
            200, frame.getHeight()-100, 150, 40, new SaveAccount(), COLOR_INTERFACE_GREEN, null);
    final static JButton buttonSettings = getButtonNullLayout("Настройки", f30, frame,
            frame.getWidth()/2+40, frame.getHeight()-100, frame.getWidth()/5, 50,
            new Settings(), COLOR_INTERFACE_GREEN, null);
    final static JButton buttonEndRegistration = getButtonNullLayout("Зарегестрироваться", f20, frame,
            75, 680, 270, 45, new EndOfRegistrationAccount(), COLOR_INTERFACE_GREEN, null);

    final static JButton buttonRight = getButtonNullLayout(">", f50, frame,
            frame.getWidth()-270-90, frame.getHeight()/2 - 50, 90, 80,
            new InventoryRight(), COLOR_INTERFACE_GREEN, null);
    final static JButton buttonLeft = getButtonNullLayout("<", f50, frame,
            270, frame.getHeight()/2 - 50, 90, 80,
            new InventoryLeft(), COLOR_INTERFACE_GREEN, null);

    final static JButton buttonPantsClothes = getButtonNullLayout(null, null, frame,
            0, 0, 0, 0, null, COLOR_INTERFACE_GREEN, null);
    final static JButton buttonShirtClothes = getButtonNullLayout(null, null, frame,
            0, 0, 0, 0, null, COLOR_INTERFACE_GREEN, null);

    final static JButton buttonPantsSlots = getButtonNullLayout(null, f25, frame,
            frame.getWidth() /2 - 200, 500, 400, 50,
            new InventorySlotsPants(), COLOR_INTERFACE_GREEN, null);
    final static JButton buttonShirtSlots = getButtonNullLayout(null, f25, frame,
            frame.getWidth() /2 - 200, 300, 400, 50,
            new InventorySlotsShirt(), COLOR_INTERFACE_GREEN, null);
    final static JButton buttonHandsSlots = getButtonNullLayout("Ручной инвентарь", f25, frame,
            frame.getWidth() /2 - 200, 400, 400, 50,
            new InventorySlotsHands(), COLOR_INTERFACE_GREEN, null);

    final static JLabel labelNewAccount = getLabelNullLayout("Новый аккаунт", null, frame,
            0, 0, 0, 0, null);
    final static JLabel labelRegisterNick = getLabelNullLayout("Логин", f25, frame,
            165, 420, 300, 30, COLOR_INTERFACE_GREEN);
    final static JLabel labelRegisterPassword = getLabelNullLayout("Пароль", f25, frame,
            165, 520, 200, 30, COLOR_INTERFACE_GREEN);
    final static JLabel labelAccount = getLabelNullLayout("Вы не авторизованы", f30, frame,
            60, frame.getHeight()-190, 400, 60, COLOR_INTERFACE_GREEN);
    final static JLabel labelWarning = getLabelNullLayout(null, f20, frame,
            100, 740, 400, 30, COLOR_INTERFACE_GREEN);
    final static JLabel labelSlots = getLabelNullLayout("Слоты", f50, frame,
            frame.getWidth()/2-85, 120, 180, 50, COLOR_INTERFACE_ORANGE);
    final static JLabel labelNick = getLabelNullLayout(null, f15, frame,
            playerXFrame - 40, playerYFrame - 60, 1000, 20, COLOR_INTERFACE_ORANGE);
    final static JLabel labelSaveAccount = getLabelNullLayout(null, f20, frame,
            370, frame.getHeight()-100, 400, 40, COLOR_INTERFACE_GREEN);
    final static JLabel labelNeedRegistration = getLabelNullLayout("Необходимо зарегестрироваться!", f30, frame,
            frame.getWidth()/3+45, frame.getHeight()/7*5, 500, 40, COLOR_INTERFACE_GREEN);

    final static JTextField textNick = getTextFieldNullLayout(null, f30, frame,
            80, 465, 250, 40, COLOR_INTERFACE_TURQUOISE, null);
    final static JTextField textPassword = getTextFieldNullLayout(null, f30, frame,
            80, 565, 250, 40, COLOR_INTERFACE_TURQUOISE, null);

    final static JTextField textNameForNewWorld = getTextFieldNullLayout(null, f50, frame,
            frame.getWidth()/2-100/2, 235, 400, 70, COLOR_INTERFACE_TURQUOISE, null);

    final static JTextArea textQuests = getTextAreaNullLayout(null, f20, frame,
            frame.getWidth() - 240, 35, 200, 180, COLOR_GAME_INTERFACE_FRONT, COLOR_INTERFACE_ORANGE);

    final static JTextArea textWorlds = new JTextArea("Тест\nТест2\nТест3\nТест4\nТест5",10, 20);
    final static JScrollPane scrollPaneWorlds = new JScrollPane(textWorlds);
    final static JPanel scrollPanel = new JPanel();
}
