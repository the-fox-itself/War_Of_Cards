package Client.Objects.GameObjects; //Пакет класса.

import static Client.Mechanic.MainGUIVariables.ICON_OBJECT_GOLD_NEARBY;
import static Client.Mechanic.MainGUIVariables.ICON_OBJECT_UNDERGROUND;

public class ObjectGold extends GameObject { //Золото.
    public ObjectGold() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class ObjectGold...");
        iconOfFar = ICON_OBJECT_UNDERGROUND;
        iconOfNearby = ICON_OBJECT_GOLD_NEARBY;
        name = "Gold"; //Его название.
        System.out.println("Finished creating object of class ObjectGold.");
        System.out.println("Created object " + name + ": xOnFrame: " + xOnFrame + ", yOnFrame: " + yOnFrame + ", width: " + width + ", height: " + height + ", iconOfFar: " + iconOfFar + ", iconOfNearby: " + iconOfNearby);
    }

    @Override
    public void recovery() {
        iconOfFar = ICON_OBJECT_UNDERGROUND;
        iconOfNearby = ICON_OBJECT_GOLD_NEARBY;
    }
}
