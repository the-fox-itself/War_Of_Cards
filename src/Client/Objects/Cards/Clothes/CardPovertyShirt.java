package Client.Objects.Cards.Clothes; //Пакет класса.

import Client.Objects.Cards.Card; //Импорт класса-родителя.

public class CardPovertyShirt extends Card { //Карта Рубаха бродяги.
    public CardPovertyShirt() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class CardPovertyShirt...");
        level = 0;
        sort = "Starting card";
        type = "Weapon card";
        name = "PovertyShirt";
        description = "Старая, когда-то купленная на базаре, рубаха.";
        System.out.println("Finished creating object of class CardPovertyShirt.");
        System.out.println("Created card " + name + ": level: " + level + ", sort: " + sort + ", type: " + type + ", isWear: " + isWear + ", specifications: " + specifications + ", description: " + description);
    }
}
