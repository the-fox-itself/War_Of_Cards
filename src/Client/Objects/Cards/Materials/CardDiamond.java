package Client.Objects.Cards.Materials; //Пакет класса.

import Client.Objects.Cards.Card; //Импорт класса-родителя.

public class CardDiamond extends Card { //Карта Алмаз.
    public CardDiamond() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class CardDiamond...");
        level = 0;
        sort = "Civil card";
        type = "Natural card";
        name = "Diamond";
        description = "АЛМАЗ!!!";

        int strength = (int) (Math.random() * 100); //Создание дополнительной характеристики - прочности и присваивание её specifications.
        if (strength > 50) {
            strength -= 30;
        }
        specifications.add(strength);
        System.out.println("Finished creating object of class CardDiamond.");
        System.out.println("Created card " + name + ": level: " + level + ", sort: " + sort + ", type: " + type + ", isWear: " + isWear + ", specifications: " + specifications + ", description: " + description);
    }
}
