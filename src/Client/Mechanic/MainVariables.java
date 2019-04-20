package Client.Mechanic;

import Client.Objects.Cards.Card;
import Client.Objects.Essences.Essence;
import Client.Objects.GameObjects.GameObject;

import java.awt.*;
import java.util.ArrayList;

public class MainVariables extends GameProgress {
    static Color colorStartBackground = new Color(0x20EBFF);
    static Color colorStartPictureBackground = new Color(0x38FF89);
    static Color colorStartPictureBlue = new Color(0x0214FF);
    static Color colorStartPictureRed = new Color(0xFF0428);
    static Color colorStartPartitions = new Color(0x919191);
    static Color colorStartLabelAccountBackground = new Color(0xFABF58);
    public static Color colorGameBackground = new Color(0x30FFB3);
    static Color colorGamePlayerBackground = new Color(0x25D196);
    static Color colorGamePlayer = new Color(0xFF0428);
    public static Color colorGameWolf = new Color(0x302C32);
    static Color colorGameHandBackground1 = new Color(0x5F2F16);
    static Color colorGameHandBackground2 = new Color(0xA06328);
    static Color colorGameInventorySlotsBackground = new Color(0xF99124);
    public static Color colorStone = new Color(0x778388);
    public static Color colorWater = new Color(0x13A2FF);
    public static Color colorWood = new Color(0x3DDD2D);
    public static Color colorSmallStone = new Color(0x323941);
    static Color colorStoneNearby = new Color(0x3A4B50);
    static Color colorWoodNearby = new Color(0x227E22);
    static Color colorSmallStoneNearby = new Color(0x000000);
    static Color colorGoldNearby = new Color(0xEEF000);
    static Color colorWaterNearby = new Color(0x1259A3);
    static Color colorHealth = new Color(0xD80011);

    static int amountOfWoods = 3000;
    static int amountOfStones = 2000;
    static int amountOfSmallStones = 100;
    static int amountOfWaters = 100;
    static int amountOfGold = 500;
    static int amountOfWolfs = 50;

    static int widthOfFrame = 1920;
    static int heightOfFrame = 1150;

    static int xOfPlayer = 960;
    static int yOfPlayer = 570;

    static String nick = "";
    static String password = "";
    static int age = 0;

    static boolean isStartGame = false;

    static int helpGroundXMinus = 20;
    static int helpGroundYMinus = 20;

    static int phase = 0;
    static boolean ifStartRegister = false;
    static boolean isRunnable = false;

    static ArrayList<Card> slots = new ArrayList<>();
    static ArrayList<Card> slotsPants = new ArrayList<>();
    static ArrayList<Card> slotsShirt = new ArrayList<>();
    static ArrayList<Card> slotsHands = new ArrayList<>();

    public static ArrayList<GameObject> listOfObjects = new ArrayList<>();
    static ArrayList<Essence> listOfEssences = new ArrayList<>();

    static ArrayList<GameObject> NearbyGameObjects = new ArrayList<>();

    static int inventorySlots = 20; //Количество слотов в ручном инвенторе.
    static int levelInventory = 1; //Уровень прокачки ручного инвентаря.
    static int speed = 1; //Скорость передвижения игрока.
    static int levelSpeed = 1; //Уровень прокачки скорости передвижения.
    static int health = 10; //Количество здоровья игрока.
    static int levelHealth = 1; //Уровень прокачки количества здоровья.
    static int damage = 1; //Количество среднего наносимового урона игрока.
    static int levelDamage = 1; //Уровень прокачки количества среднего наносимового урона.
    static int protection = 1; //Количество среднего отражаемого урона, а также сила блока ударов игрока.
    static int levelProtection = 1; //Уровень прокачки среднего отражаемого урона, а также силы блока ударов.
    static int criticalDamage = 1; //Количество среднего критического урона игрока.
    static int levelCriticalDamage = 1; //Уровень прокачки среднего критического урона.
}
