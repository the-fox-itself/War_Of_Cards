package Client.Objects.Cards.Materials; //Пакет класса.

import Client.Objects.Cards.Card; //Импорт класса-родителя.

public class CardSmallStone extends Card { //Карта Маленький камень.
    public CardSmallStone() { //Конструктор для установления начальных характеристик.
        level = 0;
        sort = "Нищенская карта";
        type = "Природная карта";
        name = "Маленький камень";
        description = "Маленький камушек,  который можно поднять с земли руками.";
        int strength = (int) (Math.random() * 100); //Создание дополнительной характеристики - прочности и присваивание её specifications.
        if (strength > 50) {
            strength -= 30;
        }
        specifications.add(strength);
    }
}
