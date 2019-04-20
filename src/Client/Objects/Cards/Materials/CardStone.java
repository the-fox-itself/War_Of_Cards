package Client.Objects.Cards.Materials; //Пакет класса.

import Client.Objects.Cards.Card; //Импорт класса-родителя.

public class CardStone extends Card { //Карта Камень.
    public CardStone() { //Конструктор для установления начальных характеристик.
        level = 0;
        sort = "Нищенская карта";
        type = "Природная карта";
        name = "Камень";
        description = "Самый обычный природный камень.";
        int strength = (int) (Math.random() * 100); //Создание дополнительной характеристики - прочности и присваивание её specifications.
        if (strength > 50) {
            strength -= 30;
        }
        specifications.add(strength);
    }
}
