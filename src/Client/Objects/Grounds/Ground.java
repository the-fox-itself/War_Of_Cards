package Client.Objects.Grounds;

import java.awt.*;
import java.io.Serializable;

public abstract class Ground implements Serializable {
    public Ground(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public abstract void recovery();

    public String name;

    public int x;
    public int y;

    public transient Image icon;
}
