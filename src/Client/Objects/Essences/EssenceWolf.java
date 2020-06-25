package Client.Objects.Essences; //Пакет класса.

import Client.Mechanic.MainGUIVariables;

import static Client.Mechanic.MainGUIVariables.ICON_WOLF_RIGHT;

public class EssenceWolf extends Essence { //Волк.
    public EssenceWolf() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class EssenceWolf...");
        name = "Wolf";
        do {
            xOnFrame = (int) (Math.random() * 1000) * 10 - 5000 - MainGUIVariables.playerXFrame;
            yOnFrame = (int) (Math.random() * 1000) * 10 - 5000 - MainGUIVariables.playerYFrame;
        } while (!(xOnFrame < 5000 && xOnFrame > -5000 && yOnFrame < 5000 && yOnFrame > -5000));
        icon = ICON_WOLF_RIGHT;
        width = 15;
        height = 15;
        essenceHealth = 5;
        essenceSpeed = (int) (Math.random() * 2) + 1;
        if (essenceSpeed == 2) {
            essenceSpeed = 1.5;
        }
        timeOfNextWalk = 5;
        System.out.println("Finished creating object of class EssenceWolf.");
        System.out.println("Created essence " + name + ":  x: " + xOnFrame + ", y: " + yOnFrame + ", w: " + width + ", h: " + height + ", health: " + essenceHealth + ", speed: " + essenceSpeed + ", color: " + color + ", icon: " + icon + ", timeToWalk: " + timeOfNextWalk + ", timePassed: " + timePassed);
    }

    @Override
    public void recovery() {
        icon = ICON_WOLF_RIGHT;
    }
}
