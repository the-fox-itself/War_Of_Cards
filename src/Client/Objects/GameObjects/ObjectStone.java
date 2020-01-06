package Client.Objects.GameObjects; //Пакет класса.

import static Client.Mechanic.MainVariables.iconOfStone; //Импорт нужного цвета.
import static Client.Mechanic.MainVariables.iconOfStoneNearby;

public class ObjectStone extends GameObject { //Камень.
    public ObjectStone() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class ObjectStone...");
        iconOfFar = iconOfStone;
        iconOfNearby = iconOfStoneNearby;
        name = "Stone"; //Его название.
        System.out.println("Finished creating object of class ObjectStone.");
        System.out.println("Created object " + name + ": xOnFrame: " + xOnFrame + ", yOnFrame: " + yOnFrame + ", width: " + width + ", height: " + height + ", iconOfFar: " + iconOfFar + ", iconOfNearby: " + iconOfNearby);
    }
}
