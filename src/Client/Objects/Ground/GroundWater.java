package Client.Objects.Ground;

import static Client.Mechanic.MainVariables.*;

public class GroundWater extends Ground {
    public GroundWater(int x, int y) {
        super(x, y);
        icon = iconGroundWater;
        name = "WaterGround";
    }

    @Override
    public void recovery() {
        icon = iconGroundWater;
    }
}
