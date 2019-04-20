package Client.Objects.Cards.Clothes; //Пакет класса.

import Client.Objects.Cards.Card; //Импорт класса-родителя.

public class CardBeggarPants extends Card { //Карта Брюки бродяги.
    public CardBeggarPants() { //Конструктор для установления начальных характеристик.
        level = 0;
        sort = "Стартовая карта";
        type = "Оружейная карта";
        name = "Брюки бродяги";
        description = "Старые, когда-то купленные на базаре брюки.";
    }
}
