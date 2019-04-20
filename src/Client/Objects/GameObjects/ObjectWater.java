package Client.Objects.GameObjects; //Пакет класса.

import static Client.Mechanic.MainVariables.colorWater; //Импорт нужного цвета.

public class ObjectWater extends GameObject { //Вода.
    public ObjectWater() { //Конструктор для установления начальных характеристик..
        width = (int) (Math.random() * 171) + 30; //Определяется размер.
        height = width; //Она круглая, поэтому её длины должны быть одинаковыми.
        color = colorWater; //Её цвет.
        name = "Вода"; //Её название.
    }
}
