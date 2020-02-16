package Client.Objects.Ground;

import java.awt.*;

public abstract class Ground {
    public Ground(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String name;

    public int x;
    public int y;

    public Image icon;
}
