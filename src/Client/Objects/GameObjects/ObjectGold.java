package Client.Objects.GameObjects; //Пакет класса.

import static Client.Mechanic.MainVariables.iconOfGoldNearby;
import static Client.Mechanic.MainVariables.iconOfUndergroundObject;

public class ObjectGold extends GameObject { //Золото.
    public ObjectGold() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class ObjectGold...");
        iconOfFar = iconOfUndergroundObject;
        iconOfNearby = iconOfGoldNearby;
        name = "Gold"; //Его название.
        System.out.println("Finished creating object of class ObjectGold.");
        System.out.println("Created object " + name + ": xOnFrame: " + xOnFrame + ", yOnFrame: " + yOnFrame + ", width: " + width + ", height: " + height + ", iconOfFar: " + iconOfFar + ", iconOfNearby: " + iconOfNearby);
    }
}
