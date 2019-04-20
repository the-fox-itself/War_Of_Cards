package Client.Objects.GameObjects; //Пакет класса.

import static Client.Mechanic.MainVariables.colorWood; //Импорт нужного цвета.

public class ObjectWood extends GameObject { //Древесина.
    public ObjectWood() { //Конструктор для установления начальных характеристик..
        width = (int) (Math.random() * 21) + 20; //Определяется размер.
        if (width > 25)
            width -= 10;
        height = width; //Она круглая, поэтому её длины должны быть одинаковыми.
        color = colorWood; //Её цвет.
        name = "Древесина"; //Её название.
    }
}
