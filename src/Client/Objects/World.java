package Client.Objects;

import Client.Objects.Cards.Card;
import Client.Objects.Essences.Essence;
import Client.Objects.GameObjects.GameObject;
import Client.Objects.Ground.Ground;

import java.io.Serializable;
import java.util.ArrayList;

public class World implements Serializable {
    public String name;

    public int xOfPlayer = 0;
    public int yOfPlayer = 0;

    public int amountOfDeaths = 0;


    public ArrayList<Card> slots = new ArrayList<>();

    public ArrayList<Card> slotsPants = new ArrayList<>();
    public ArrayList<Card> slotsShirt = new ArrayList<>();
    public ArrayList<Card> slotsHands = new ArrayList<>();


    public int inventorySlots = 20; //Количество слотов в ручном инвенторе.
    public int levelInventory = 1; //Уровень прокачки ручного инвентаря.

    public int speed = 1; //Скорость передвижения игрока.
    public int levelSpeed = 1; //Уровень прокачки скорости передвижения.

    public int maxHealth = 10;
    public int health = maxHealth; //Количество текущего здоровья игрока.
    public int levelHealth = 1; //Уровень прокачки количества здоровья.

    public int damage = 1; //Количество среднего наносимового урона игрока.
    public int levelDamage = 1; //Уровень прокачки количества среднего наносимового урона.
    public int criticalDamage = 1; //Количество среднего критического урона игрока.
    public int levelCriticalDamage = 1; //Уровень прокачки среднего критического урона.

    public int protection = 1; //Количество среднего отражаемого урона, а также сила блока ударов игрока.
    public int levelProtection = 1; //Уровень прокачки среднего отражаемого урона, а также силы блока ударов.


    public int amountOfAllGettingCardWoods = 0;
    public int amountOfAllGettingCardStones = 0;
    public int amountOfAllGettingCardSmallStones = 0;
    public int amountOfAllGettingCardWaters = 0;
    public int amountOfAllGettingCardGolds = 0;
    public int amountOfAllGettingCardDiamonds = 0;

    public int amountOfAllGettingCards = 0;

    public int amountOfCompletedQuests = 0;

    public int startAmountOfWoods = 3000;
    public int startAmountOfStones = 2000;
    public int startAmountOfSmallStones = 100;
    public int startAmountOfWaters = 2000;
    public int startAmountOfGolds = 500;
    public int startAmountOfDiamonds = 100;
    public int startAmountOfWolfs = 50;

    public ArrayList<GameObject> listOfObjects = new ArrayList<>();
    public ArrayList<Ground> listOfGrounds = new ArrayList<>();
    public ArrayList<Essence> listOfEssences = new ArrayList<>();
    public ArrayList<GameObject> NearbyGameObjects = new ArrayList<>();

    public ArrayList<Quest> quests = new ArrayList<>();
}
