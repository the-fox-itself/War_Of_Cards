package Client.WorldGeneration.Biomes;

import Client.Objects.Grounds.Ground;

import java.util.ArrayList;

public class Biome {
    public Biome(ArrayList<Ground> listOfGrounds) {
        this.listOfGrounds = listOfGrounds;
    }

    public String typicalGround;
    public ArrayList<Ground> listOfGrounds;
}
