package Client.WorldGeneration.Biomes;

import Client.Objects.Grounds.Ground;

import java.util.ArrayList;

public class BiomeForest extends Biome {
    public BiomeForest(ArrayList<Ground> listOfGrounds) {
        super(listOfGrounds);
        typicalGround = "GrassGround";
    }
}
