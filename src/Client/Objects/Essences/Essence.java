package Client.Objects.Essences; //Пакет класса

import java.awt.*; //Импорт пакета с классом Color.

public abstract class Essence { //Класс-родитель для всех живых объектов на местности.
    public int x; //Первая координата этого существа на плоскости.
    public int y; //Вторая координата этого существа на плоскости.
    public int startX; //Первая неизменяющаяся координата этого существа на плоскости.
    public int startY; //Вторая неизменяющаяся координата этого существа на плоскости.
    public Color color; //Цвет существа.
    public int width; //Ширина существа.
    public int height; //Длина существа.
    public String name; //Название существа.
    int essenceHealth; //Количество жизней существа.
    public int essenceSpeed; //Скорость передвижения существа.

}
