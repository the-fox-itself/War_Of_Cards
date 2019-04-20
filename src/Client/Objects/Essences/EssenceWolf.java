package Client.Objects.Essences; //Пакет класса.

import static Client.Mechanic.MainVariables.colorGameWolf; //Импорт нужного цвета.

public class EssenceWolf extends Essence { //Волк.
    public EssenceWolf() { //Конструктор для установления начальных характеристик.
        name = "Волк";
        x = (int) (Math.random() * 1000) * 10 - 5000;
        y = (int) (Math.random() * 1000) * 10 - 5000;
        startX = x;
        startY = y;
        color = colorGameWolf;
        width = 15;
        height = 15;
        essenceHealth = 5;
        essenceSpeed = (int) (Math.random() * 5);
        if (essenceSpeed > 2) {
            essenceSpeed -= 2;
        }
    }
}
