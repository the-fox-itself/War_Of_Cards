package Client.Objects.GameObjects; //Пакет класса.

import static Client.Mechanic.MainGUIVariables.*;

public class ObjectDiamond extends GameObject { //Алмаз.
    public ObjectDiamond() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class ObjectDiamond...");
        iconOfFar = ICON_OBJECT_UNDERGROUND;
        iconOfNearby = ICON_OBJECT_DIAMOND_NEARBY;
        name = "Diamond"; //Его название.
        System.out.println("Finished creating object of class ObjectDiamond.");
        System.out.println("Created object " + name + ": xOnFrame: " + xOnFrame + ", yOnFrame: " + yOnFrame + ", width: " + width + ", height: " + height + ", color: " + color + ", iconOfFar: " + iconOfFar + ", iconOfNearby: " + iconOfNearby);
    }

    @Override
    public void recovery() {
        iconOfFar = ICON_OBJECT_UNDERGROUND;
        iconOfNearby = ICON_OBJECT_DIAMOND_NEARBY;
    }
}
