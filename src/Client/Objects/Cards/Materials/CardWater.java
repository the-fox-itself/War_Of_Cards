package Client.Objects.Cards.Materials; //Пакет класса.

import Client.Objects.Cards.Card; //Импорт класса-родителя.

public class CardWater extends Card { // Карта Вода.
    public CardWater() { //Конструктор для установления начальных характеристик.
        level = 0;
        sort = "Крестьянскаяй карта";
        type = "Природная карта";
        name = "Вода";
        description = "Обычная вода из озера";
        int strength = (int) (Math.random() * 100); //Создание дополнительной характеристики - прочности и присваивание её specifications.
        if (strength > 50) {
            strength -= 30;
        }
        specifications.add(strength);
    }
}
