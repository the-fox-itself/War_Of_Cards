package Client.Objects.GameObjects; //Пакет класса.

import static Client.Mechanic.MainGUIVariables.ICON_OBJECT_WOOD_1; //Импорт нужного спрайта.
import static Client.Mechanic.MainGUIVariables.ICON_OBJECT_WOOD_2; //Импорт нужного спрайта.
import static Client.Mechanic.MainGUIVariables.ICON_OBJECT_WOOD_NEARBY;


public class ObjectWood extends GameObject { //Древесина.
    public ObjectWood() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class ObjectWood...");
        int rand = (int) (Math.random()*2);
        switch (rand) {
            case 0:
                iconOfFar = ICON_OBJECT_WOOD_1;
                break;
            case 1:
                iconOfFar = ICON_OBJECT_WOOD_2;
                break;
        }
        iconType = rand;
        iconOfNearby = ICON_OBJECT_WOOD_NEARBY;
        name = "Wood"; //Её название.
        System.out.println("Finished creating object of class ObjectWood.");
        System.out.println("Created object " + name + ": xOnFrame: " + xOnFrame + ", yOnFrame: " + yOnFrame + ", width: " + width + ", height: " + height + ", iconOfFar: " + iconOfFar + ", iconOfNearby: " + iconOfNearby);
    }

    @Override
    public void recovery() {
        switch (iconType) {
            case 0:
                iconOfFar = ICON_OBJECT_WOOD_1;
                break;
            case 1:
                iconOfFar = ICON_OBJECT_WOOD_2;
                break;
        }
        iconOfNearby = ICON_OBJECT_WOOD_NEARBY;
    }
}
