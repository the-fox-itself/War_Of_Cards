package GameMechanic.Objects.TechnicalObjects;

import GameMechanic.Objects.Cards.Card;
import GameMechanic.Objects.Essences.Essence;
import GameMechanic.Objects.GameObjects.GameObject;
import GameMechanic.Objects.GameObjects.ObjectBarrier;
import GameMechanic.Objects.GameObjects.ObjectStone;
import GameMechanic.Objects.Grounds.Ground;
import GameMechanic.Objects.Grounds.GroundGrass;
import GameMechanic.Objects.Grounds.GroundWater;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class World implements Serializable {
    public World(Account account, String name) {
        this.account = account;
        this.name = name;

        generation();
    }

    public String name;
    public double percentComplete;

    public Account account;

    public int startAmountOfDiamonds = 100;

    public ArrayList<Player> listOfPlayers = new ArrayList<>();
    public ArrayList<Essence> listOfEssences = new ArrayList<>();
    public ArrayList<Quest> listOfQuests = new ArrayList<>();

    public LinkedHashMap<GameObject, int[]> listOfObjects = new LinkedHashMap<>();
    public LinkedHashMap<Ground, int[]> listOfGrounds = new LinkedHashMap<>();

    void generation() {
        //Создание барьеров с каждой из сторон мира на 501 координате
        //Создание угловых барьеров
        ObjectBarrier barrier = new ObjectBarrier(501, 501);
        listOfObjects.put(barrier, new int[] {barrier.xOnWorld, barrier.yOnWorld});
        barrier = new ObjectBarrier(-501, 501);
        listOfObjects.put(barrier, new int[] {barrier.xOnWorld, barrier.yOnWorld});
        barrier = new ObjectBarrier(501, -501);
        listOfObjects.put(barrier, new int[] {barrier.xOnWorld, barrier.yOnWorld});
        barrier = new ObjectBarrier(-501, -501);
        listOfObjects.put(barrier, new int[] {barrier.xOnWorld, barrier.yOnWorld});
        //Создание линий из барьеров с каждой из сторон мира, не включая углы
        for (int x = -500; x <= 500; x++) {
            barrier = new ObjectBarrier(x, 501);
            listOfObjects.put(barrier, new int[] {barrier.xOnWorld, barrier.yOnWorld});
        }
        for (int x = -500; x <= 500; x++) {
            barrier = new ObjectBarrier(x, -501);
            listOfObjects.put(barrier, new int[] {barrier.xOnWorld, barrier.yOnWorld});
        }
        for (int y = -500; y <= 500; y++) {
            barrier = new ObjectBarrier(501, y);
            listOfObjects.put(barrier, new int[] {barrier.xOnWorld, barrier.yOnWorld});
        }
        for (int y = -500; y <= 500; y++) {
            barrier = new ObjectBarrier(-501, y);
            listOfObjects.put(barrier, new int[] {barrier.xOnWorld, barrier.yOnWorld});
        }
        System.out.println("All ObjectBarriers have created.");


        ObjectStone stone = new ObjectStone(0, 0);
        listOfObjects.put(stone, new int[]{stone.xOnWorld, stone.yOnWorld});
        ObjectStone stone1 = new ObjectStone(1, 0);
        listOfObjects.put(stone1, new int[]{stone1.xOnWorld, stone1.yOnWorld});
        ObjectStone stone2 = new ObjectStone(2, 1);
        listOfObjects.put(stone2, new int[]{stone2.xOnWorld, stone2.yOnWorld});

//        for (int x = startAmountOfWoods; x > 0; x--) {
//            GameObject wood = new ObjectWood();
//            wood.setLocations(wood);
//            listOfObjects.put(wood, new int[]{wood.xOnWorld, wood.yOnWorld});
//        }
//        System.out.println("All ObjectWoods have created.");
//        for (int x = startAmountOfStones; x > 0; x--) {
//            GameObject stone = new ObjectStone();
//            stone.setLocations(stone);
//            listOfObjects.put(stone, new int[] {stone.xOnWorld, stone.yOnWorld});
//        }
//        System.out.println("All ObjectStones have created.");
//        for (int x = startAmountOfSmallStones; x > 0; x--) {
//            GameObject smallStone = new ObjectSmallStone();
//            smallStone.setLocations(smallStone);
//            listOfObjects.put(smallStone, new int[] {smallStone.xOnWorld, smallStone.yOnWorld});
//        }
//        System.out.println("All ObjectsSmallStones have created.");
//        for (int x = startAmountOfGolds; x > 0; x--) {
//            GameObject gold = new ObjectGold();
//            gold.setLocations(gold);
//            listOfObjects.put(gold, new int[] {gold.xOnWorld, gold.yOnWorld});
//        }
//        System.out.println("All ObjectGolds have created.");
//        for (int x = startAmountOfDiamonds; x > 0; x--) {
//            GameObject diamond = new ObjectDiamond();
//            diamond.setLocations(diamond);
//            listOfObjects.put(diamond, new int[] {diamond.xOnWorld, diamond.yOnWorld});
//        }
//        System.out.println("All ObjectDiamonds have created.");
//        for (int x = startAmountOfWolfs; x > 0; x--) {
//            Essence wolf = new EssenceWolf();
//            listOfEssences.add(wolf);
//        }
//        System.out.println("All EssenceWolfs have created.");

        for (int x = -500; x < 500; x+=5) {
            for (int y = -500; y < 500; y+=5) {
                int rand = (int) (Math.random()*100);
                if (rand == 0) {
                    GroundWater groundWater = new GroundWater(x, y);
                    listOfGrounds.put(groundWater, new int[] {groundWater.xOnWorld, groundWater.yOnWorld});
                } else {
                    GroundGrass groundGrass = new GroundGrass(x, y);
                    listOfGrounds.put(groundGrass, new int[] {groundGrass.xOnWorld, groundGrass.yOnWorld});
                }
            }
        }
        System.out.println("All Grounds have created.");

        //Создание квестов
        Quest quest1 = new Quest(1, "Собрать 10 карт\n\n Дерево", 10, Card.NAME_WOOD);
        quest1.runnableOn();
        Quest quest2 = new Quest(2, "Собрать 10 карт\n\n Камень", 10, Card.NAME_STONE);
        Quest quest3 = new Quest(3, "Собрать 5 карт\n\n Маленький камень", 5, Card.NAME_SMALL_STONE);
        Quest quest4 = new Quest(4, "Собрать 10 карт\n\n Золото", 10, Card.NAME_GOLD);
        Quest quest5 = new Quest(5, "Собрать 10 карт\n\n Алмаз", 10, Card.NAME_DIAMOND);
        listOfQuests.add(quest1);
        listOfQuests.add(quest2);
        listOfQuests.add(quest3);
        listOfQuests.add(quest4);
        listOfQuests.add(quest5);
    }
}
