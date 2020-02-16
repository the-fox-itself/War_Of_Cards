package Client.Objects.Biomes;

import Client.Objects.Ground.Ground;
import Client.Objects.Ground.GroundWater;

import java.util.ArrayList;

public class BiomeForest extends Biome {
    public BiomeForest(ArrayList<Ground> listOfGrounds) {
        super(listOfGrounds);
        typicalGround = "GrassGround";
    }
}
