package Client.Objects.Ground;

import java.awt.*;
import java.io.Serializable;

public abstract class Ground implements Serializable {
    public Ground(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String name;

    public int x;
    public int y;

    public transient Image icon;
}
