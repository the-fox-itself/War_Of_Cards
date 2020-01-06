package Client.Objects.GameObjects; //Пакет класса.

import static Client.Mechanic.MainVariables.*;

public class ObjectSmallStone extends GameObject { //Маленький камень.
    public ObjectSmallStone() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class ObjectSmallStone...");
        iconOfFar = iconOfSmallStone;
        iconOfNearby = iconOfSmallStoneNearby;
        name = "SmallStone"; //Его название.
        System.out.println("Finished creating object of class ObjectSmallStone.");
        System.out.println("Created object " + name + ": xOnFrame: " + xOnFrame + ", yOnFrame: " + yOnFrame + ", width: " + width + ", height: " + height + ", color: " + color + ", iconOfFar: " + iconOfFar + ", iconOfNearby: " + iconOfNearby);
    }
}
