package Client.Objects.TechnicalObjects;

import Client.Objects.Essences.Essence;
import Client.Objects.GameObjects.GameObject;
import Client.Objects.Grounds.Ground;

import java.io.Serializable;
import java.util.ArrayList;

import static Client.Mechanic.SwingPlus.Methods.*;

public class World implements Serializable {
    public World() {
        printNote("Creating an object of class World", NOTE_TYPE_DONE);
    }

    public String name;
    public double percentComplete;

    public int startAmountOfWoods = 3000;
    public int startAmountOfStones = 2000;
    public int startAmountOfSmallStones = 100;
    public int startAmountOfWaters = 2000;
    public int startAmountOfGolds = 500;
    public int startAmountOfDiamonds = 100;
    public int startAmountOfWolfs = 50;

    public ArrayList<Player> listOfPlayers = new ArrayList<>();
    public ArrayList<GameObject> listOfObjects = new ArrayList<>();
    public ArrayList<Ground> listOfGrounds = new ArrayList<>();
    public ArrayList<Essence> listOfEssences = new ArrayList<>();
    public ArrayList<Quest> listOfQuests = new ArrayList<>();
}
