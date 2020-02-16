package Client.Objects.Ground;

import Client.Mechanic.MainVariables;

public class GroundWater extends Ground {
    public GroundWater(int x, int y) {
        super(x, y);
        icon = MainVariables.iconOfGroundWater;
        name = "WaterGround";
    }
}
