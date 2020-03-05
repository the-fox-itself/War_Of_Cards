package Client.Objects.GameObjects; //Пакет класса.

import static Client.Mechanic.MainVariables.iconWood; //Импорт нужного спрайта.
import static Client.Mechanic.MainVariables.iconWoodNearby;


public class ObjectWood extends GameObject { //Древесина.
    public ObjectWood() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class ObjectWood...");
        iconOfFar = iconWood;
        iconOfNearby = iconWoodNearby;
        name = "Wood"; //Её название.
        System.out.println("Finished creating object of class ObjectWood.");
        System.out.println("Created object " + name + ": xOnFrame: " + xOnFrame + ", yOnFrame: " + yOnFrame + ", width: " + width + ", height: " + height + ", iconOfFar: " + iconOfFar + ", iconOfNearby: " + iconOfNearby);
    }

    @Override
    public void recovery() {
        iconOfFar = iconWood;
        iconOfNearby = iconWoodNearby;
    }
}
