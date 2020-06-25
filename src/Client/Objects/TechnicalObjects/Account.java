package Client.Objects.TechnicalObjects;

import Client.Objects.Essences.Essence;
import Client.Objects.GameObjects.GameObject;
import Client.Objects.Grounds.Ground;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
    public void recovery() {
        for (World world : listOfWorlds) {
            for (GameObject gameObject : world.listOfObjects) {
                gameObject.recovery();
            }
            for (Ground ground : world.listOfGrounds) {
                ground.recovery();
            }
            for (Essence essence : world.listOfEssences) {
                essence.recovery();
            }
            for (GameObject gameObject : world.listOfPlayers.get(0).listOfNearbyGameObjects) {
                gameObject.recovery();
            }
        }
        System.out.println("<War_Of_Cards> Восстановка данных совершена успешно");
    }

    public String nick = "";
    public String password = "";

    public ArrayList<World> listOfWorlds = new ArrayList<>();
}
