package Client.Objects.Cards.NaturalCards; //Пакет класса.

import Client.Objects.Cards.Card; //Импорт класса-родителя.

public class CardGold extends Card { //Карта Золото.
    public CardGold() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class CardGold...");
        level = 0;
        sort = "Peasant Card";
        type = "Natural card";
        name = "Gold";
        description = "ЗОЛОТО!!!";

        int strength = (int) (Math.random() * 100); //Создание дополнительной характеристики - прочности и присваивание её specifications.
        if (strength > 50) {
            strength -= 30;
        }
        specifications.add(strength);
        System.out.println("Finished creating object of class CardGold.");
        System.out.println("Created card " + name + ": level: " + level + ", sort: " + sort + ", type: " + type + ", isWear: " + isWear + ", specifications: " + specifications + ", description: " + description);
    }
}
