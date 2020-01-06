package Client.Objects.Cards.Clothes; //Пакет класса.

import Client.Objects.Cards.Card; //Импорт класса-родителя.

public class CardPovertyPants extends Card { //Карта Брюки бродяги.
    public CardPovertyPants() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class CardPovertyPants...");
        level = 0;
        sort = "Starting card";
        type = "Weapon card";
        name = "PovertyPants";
        description = "Старые, когда-то купленные на базаре, брюки.";
        System.out.println("Finished creating object of class CardPovertyPants.");
        System.out.println("Created card " + name + ": level: " + level + ", sort: " + sort + ", type: " + type + ", isWear: " + isWear + ", specifications: " + specifications + ", description: " + description);
    }
}
