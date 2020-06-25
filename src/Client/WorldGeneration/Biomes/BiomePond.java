package Client.WorldGeneration.Biomes;

import Client.Objects.Grounds.Ground;

import java.util.ArrayList;

public class BiomePond extends Biome {
    public BiomePond(ArrayList<Ground> listOfGrounds) {
        super(listOfGrounds);
        typicalGround = "WaterGround";
    }
}
