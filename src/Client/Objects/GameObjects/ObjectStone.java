package Client.Objects.GameObjects; //Пакет класса.

import static Client.Mechanic.MainVariables.iconStone; //Импорт нужного цвета.
import static Client.Mechanic.MainVariables.iconStoneNearby;

public class ObjectStone extends GameObject { //Камень.
    public ObjectStone() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class ObjectStone...");
        iconOfFar = iconStone;
        iconOfNearby = iconStoneNearby;
        name = "Stone"; //Его название.
        System.out.println("Finished creating object of class ObjectStone.");
        System.out.println("Created object " + name + ": xOnFrame: " + xOnFrame + ", yOnFrame: " + yOnFrame + ", width: " + width + ", height: " + height + ", iconOfFar: " + iconOfFar + ", iconOfNearby: " + iconOfNearby);
    }

    @Override
    public void recovery() {
        iconOfFar = iconStone;
        iconOfNearby = iconStoneNearby;
    }
}
