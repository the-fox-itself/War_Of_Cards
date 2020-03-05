package Client.Objects.Ground;

import static Client.Mechanic.MainVariables.*;

public class GroundGrass extends Ground {
    public GroundGrass(int x, int y) {
        super(x, y);
        icon = iconGroundGrass;
        name = "GrassGround";
        System.out.println("New ground has created: " + name + ".");
    }

    @Override
    public void recovery() {
        icon = iconGroundGrass;
    }
}
