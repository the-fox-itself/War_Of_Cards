package Client.Objects.Grounds;

import static Client.Mechanic.MainGUIVariables.*;

public class GroundGrass extends Ground {
    public GroundGrass(int x, int y) {
        super(x, y);
        icon = ICON_GROUND_GRASS;
        name = "GrassGround";
        System.out.println("New ground has created: " + name + ".");
    }

    @Override
    public void recovery() {
        icon = ICON_GROUND_GRASS;
    }
}
