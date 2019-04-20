package Client.Objects.GameObjects; //Пакет класса.

import static Client.Mechanic.MainVariables.colorStone; //Импорт нужного цвета.

public class ObjectStone extends GameObject { //Камень.
    public ObjectStone() { //Конструктор для установления начальных характеристик..
        width = (int) (Math.random() * 21) + 20; //Определяется размер.
        if (width > 25)
            width -= 10;
        height = width; //Он квадратный, поэтому его длины должны быть одинаковыми.
        color = colorStone; //Его цвет.
        name = "Камень"; //Его название.
    }
}
