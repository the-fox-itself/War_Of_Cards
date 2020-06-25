package Client.Objects.GameObjects; //Пакет класса.

import static Client.Mechanic.MainGUIVariables.*;

public class ObjectSmallStone extends GameObject { //Маленький камень.
    public ObjectSmallStone() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class ObjectSmallStone...");
        iconOfFar = ICON_OBJECT_SMALL_STONE;
        iconOfNearby = ICON_OBJECT_SMALL_STONE_NEARBY;
        name = "SmallStone"; //Его название.
        System.out.println("Finished creating object of class ObjectSmallStone.");
        System.out.println("Created object " + name + ": xOnFrame: " + xOnFrame + ", yOnFrame: " + yOnFrame + ", width: " + width + ", height: " + height + ", color: " + color + ", iconOfFar: " + iconOfFar + ", iconOfNearby: " + iconOfNearby);
    }

    @Override
    public void recovery() {
        iconOfFar = ICON_OBJECT_SMALL_STONE;
        iconOfNearby = ICON_OBJECT_SMALL_STONE_NEARBY;
    }
}
