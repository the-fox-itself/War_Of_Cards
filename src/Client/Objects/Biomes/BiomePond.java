package Client.Objects.Biomes;

import Client.Objects.Ground.Ground;

import java.util.ArrayList;

public class BiomePond extends Biome {
    public BiomePond(ArrayList<Ground> listOfGrounds) {
        super(listOfGrounds);
        typicalGround = "WaterGround";
    }
}
