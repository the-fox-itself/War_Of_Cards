package Client.Objects.GameObjects; //Пакет класса.

import static Client.Mechanic.MainVariables.iconOfWood; //Импорт нужного спрайта.
import static Client.Mechanic.MainVariables.iconOfWoodNearby;

public class ObjectWood extends GameObject { //Древесина.
    public ObjectWood() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class ObjectWood...");
        iconOfFar = iconOfWood;
        iconOfNearby = iconOfWoodNearby;
        name = "Wood"; //Её название.
        System.out.println("Finished creating object of class ObjectWood.");
        System.out.println("Created object " + name + ": xOnFrame: " + xOnFrame + ", yOnFrame: " + yOnFrame + ", width: " + width + ", height: " + height + ", iconOfFar: " + iconOfFar + ", iconOfNearby: " + iconOfNearby);
    }
}
