package Client.Objects.Ground;

import Client.Mechanic.MainVariables;

public class GroundGrass extends Ground {
    public GroundGrass(int x, int y) {
        super(x, y);
        icon = MainVariables.iconGroundGrass;
        name = "GrassGround";
        System.out.println("New ground has created: " + name + ".");
    }
}
