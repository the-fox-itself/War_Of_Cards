package Client.Objects.Cards.Clothes; //Пакет класса.

import Client.Objects.Cards.Card; //Импорт класса-родителя.

public class CardBeggarShirt extends Card { //Карта Рубаха бродяги.
    public CardBeggarShirt() { //Конструктор для установления начальных характеристик.
        level = 0;
        sort = "Стартовая карта";
        type = "Оружейная карта";
        name = "Рубаха бродяги";
        description = "Старая, когда-то купленная на базаре рубаха.";
    }
}
