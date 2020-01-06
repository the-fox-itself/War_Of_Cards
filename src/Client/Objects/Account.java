package Client.Objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
    public String nick = "";
    public String password = "";
    public int age = 0;

    public ArrayList<World> listOfWorlds = new ArrayList<>();
}
