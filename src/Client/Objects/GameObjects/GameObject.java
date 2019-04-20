package Client.Objects.GameObjects; //Пакет класса.

import static Client.Mechanic.MainVariables.listOfObjects; //Импорт массива всех объектов на местности.

import java.awt.*; //Импорт пакета с классом Color.

public abstract class GameObject { //Класс-родитель для всех неживых объектов на местности.
    public int x; //Первая координата объекта на плоскости.
    public int y; //Вторая координата объекта на плоскости.
    public int startX; //Первая неизменяющаяся координата объекта на плоскости.
    public int startY; //Вторая неизменяющаяся координата объекта на плоскости.
    public int width; //Длина объекта по оси x.
    public int height; //Длина объекта по оси y.
    public Color color; //Цвет объекта.
    public String name; //Название объекта.
    private boolean isSingleXY = false; //Переменная, необходимая для выхода из цикла при выбирании возможных (без столкновения с другими) рандомных координат объекта.

    public void setLocations(GameObject object) { //Метод для выбирания возможных (без столкновения с другими) рандомных координат объекта.     // ПОДСТРОЕНО ПОД ОБЪЕКТЫ, РАЗМЕРОМ НЕ БОЛЬШИЕ 40 ПИКСЕЛЕЙ!
        while (!isSingleXY) {
            isSingleXY = true; //Необходимо для выхода из цикла.
            x = (int) (Math.random() * 1000) * 10 - 5000; //Присваивание рандомного значения от -5000 до +4990 переменной x.
            y = (int) (Math.random() * 1000) * 10 - 5000; //Присваивание рандомного значения от -5000 до +4990 переменной y.
            if (!object.name.equals("Вода") && !object.name.equals("Золото")) { //Здесь указаны объекты, которые могут сталкиваться с остальными.
                for (GameObject gameObject : listOfObjects) { //Выполняется цикл, который проверяет наличие столкновений при данных координатах объекта с другими.
                    if (gameObject.y == this.y || gameObject.y == this.y + 10 || gameObject.y == this.y + 20 || gameObject.y == this.y + 30 || gameObject.y == this.y + 40 || gameObject.y == this.y - 10 || gameObject.y == this.y - 20 || gameObject.y == this.y - 30 || gameObject.y == this.y - 40) { //Условия столкновения объекта с другими объектами.
                        if (gameObject.x == this.x || gameObject.x == this.x + 10 || gameObject.x == this.x + 20 || gameObject.x == this.x + 30 || gameObject.x == this.x + 40 || gameObject.x == this.x - 10 || gameObject.x == this.x - 20 || gameObject.x == this.x - 30 || gameObject.x == this.x - 40) {
                            isSingleXY = false; //Если условия столкновения выдадут результат true, цикл начнётся сначала, будут выбраны новые координаты и уже они будут проходить эту проверку.
                        }
                    }
                }
            }
        } //Конец цикла.
        startX = x;
        startY = y;
    }
}
