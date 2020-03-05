package Client.Objects.GameObjects; //Пакет класса.

import static Client.Mechanic.MainVariables.*;

public class ObjectDiamond extends GameObject { //Алмаз.
    public ObjectDiamond() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class ObjectDiamond...");
        iconOfFar = iconUndergroundObject;
        iconOfNearby = iconDiamondNearby;
        name = "Diamond"; //Его название.
        System.out.println("Finished creating object of class ObjectDiamond.");
        System.out.println("Created object " + name + ": xOnFrame: " + xOnFrame + ", yOnFrame: " + yOnFrame + ", width: " + width + ", height: " + height + ", color: " + color + ", iconOfFar: " + iconOfFar + ", iconOfNearby: " + iconOfNearby);
    }

    @Override
    public void recovery() {
        iconOfFar = iconUndergroundObject;
        iconOfNearby = iconDiamondNearby;
    }
}
