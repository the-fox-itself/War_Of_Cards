package Client.Objects.Cards; //Пакет класса.

import java.util.ArrayList; //Импорт класса ArrayList.

public abstract class Card { //Класс-родитель для всех карт игры.
    public boolean isWear; //Переменная, по которой можно определить, надета ли вещь на игрока или снята (характерна для классов пакета Clothes).
    public int level; //Уровень прокачки карты.
    public String sort; //Вид, к которому принадлежит данная карта.
    public String type; //Тип, к которому принадлежит данная карта.
    public String name; //Название карты.
    public String description; //Описание карты.
    public ArrayList specifications = new ArrayList(); //ArrayList, состоящий из вспомогательных характеристик карты.
}