package Client.Objects.Biomes;

import Client.Objects.Ground.Ground;

import java.util.ArrayList;

public class Biome {
    public Biome(ArrayList<Ground> listOfGrounds) {
        this.listOfGrounds = listOfGrounds;
    }

    public String typicalGround;
    public ArrayList<Ground> listOfGrounds;
}