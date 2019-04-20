package Client.Objects.GameObjects; //Пакет класса.

import static Client.Mechanic.MainVariables.colorGameBackground; //Импорт нужного цвета.

public class ObjectGold extends GameObject { //Золото.
    public ObjectGold() { //Конструктор для установления начальных характеристик.
        width = (int) (Math.random() * 31) + 50; //Определяется размер.
        height = width; //Оно круглое, поэтому его длины должны быть одинаковыми.
        color = colorGameBackground; //Его цвет.
        name = "Золото"; //Его название.
    }
}
