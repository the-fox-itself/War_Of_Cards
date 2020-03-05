package Client.Objects;

import Client.Objects.Essences.Essence;
import Client.Objects.GameObjects.GameObject;
import Client.Objects.Ground.Ground;

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
            for (GameObject gameObject : world.listOfNearbyGameObjects) {
                gameObject.recovery();
            }
        }
    }

    public String nick = "";
    public String password = "";

    public ArrayList<World> listOfWorlds = new ArrayList<>();
}
