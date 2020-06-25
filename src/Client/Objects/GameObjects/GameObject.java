package Client.Objects.GameObjects; //Пакет класса.

import Client.Mechanic.MainGUIVariables;

import java.awt.*; //Импорт пакета с классом Color.
import java.io.Serializable;

public abstract class GameObject implements Serializable { //Класс-родитель для всех неживых объектов на местности.
    public int xOnFrame; //Первая координата объекта на плоскости.
    public int yOnFrame; //Вторая координата объекта на плоскости.
    public int xOnWorld;
    public int yOnWorld;
    public int width; //Длина объекта по оси xOnFrame.
    public int height; //Длина объекта по оси yOnFrame.
//    public Color colorOfFar; //Цвет объекта при его дальности от игрока.
//    public Color colorOfNearby; //Цвет объекта при его близости к игроку.
    public Color color; //Цвет объекта.

    public transient Image iconOfFar; //Иконка объекта при его дальности от игрока.
    public int iconType;
    public transient Image iconOfNearby; //Иконка объекта при его близости к игроку.

    public boolean isNearby = false;
    public String name; //Название объекта.
    private boolean isSingleXY = false; //Переменная, необходимая для выхода из цикла при выбирании возможных (без столкновения с другими) рандомных координат объекта.

    public void setLocations(GameObject object) { //Метод для выбирания возможных (без столкновения с другими) рандомных координат объекта.     // ПОДСТРОЕНО ПОД ОБЪЕКТЫ, РАЗМЕРОМ НЕ БОЛЬШИЕ 40 ПИКСЕЛЕЙ!
        while (!isSingleXY) {
            isSingleXY = true; //Необходимо для выхода из цикла.
            xOnFrame = (int) (Math.random() * 1000) * 10 - 5000; //Присваивание рандомного значения от -5000 до +4990 переменной xOnFrame.
            yOnFrame = (int) (Math.random() * 1000) * 10 - 5000; //Присваивание рандомного значения от -5000 до +4990 переменной yOnFrame.
            if (!object.name.equals("Water") && !object.name.equals("Gold") && !object.name.equals("Diamond")) { //Здесь указаны объекты, которые могут сталкиваться с остальными.
                for (GameObject gameObject : MainGUIVariables.worldCurrent.listOfObjects) { //Выполняется цикл, который проверяет наличие столкновений при данных координатах объекта с другими.
                    if (gameObject.yOnFrame - this.yOnFrame > -50 && gameObject.yOnFrame - this.yOnFrame < 50) { //Условия столкновения объекта с другими объектами.
                        if (gameObject.xOnFrame - this.xOnFrame > -50 && gameObject.xOnFrame - this.xOnFrame < 50) {
                            isSingleXY = false; //Если условия столкновения выдадут результат true, цикл начнётся сначала, будут выбраны новые координаты и уже они будут проходить эту проверку.
                        }
                    }
                }
            }
            xOnWorld = xOnFrame - MainGUIVariables.playerXFrame;
            yOnWorld = yOnFrame - MainGUIVariables.playerYFrame;
        } //Конец цикла.
        System.out.println("setLocations() has complete for " + object.toString() + " with values:  xOnFrame: " + xOnFrame + ", yOnFrame: " + yOnFrame);
    }
    public abstract void recovery();
}
