package Client.Objects.GameObjects; //Пакет класса.

import static Client.Mechanic.MainVariables.colorSmallStone; //Импорт нужного цвета.

public class ObjectSmallStone extends GameObject { //Маленький камень.
    public ObjectSmallStone() { //Конструктор для установления начальных характеристик.
        width = (int) (Math.random() * 6) + 10; //Определяется размер.
        height = width; //Он квадратный, поэтому его длины должны быть одинаковыми.
        color = colorSmallStone; //Его цвет.
        name = "Маленький камень"; //Его название.
    }
}
