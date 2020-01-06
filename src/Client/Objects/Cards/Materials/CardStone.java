package Client.Objects.Cards.Materials; //Пакет класса.

import Client.Objects.Cards.Card; //Импорт класса-родителя.

public class CardStone extends Card { //Карта Камень.
    public CardStone() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class CardStone...");
        level = 0;
        sort = "Poverty card";
        type = "Natural card";
        name = "Stone";
        description = "Самый обычный природный камень.";
        int strength = (int) (Math.random() * 100); //Создание дополнительной характеристики - прочности и присваивание её specifications.
        if (strength > 50) {
            strength -= 30;
        }
        specifications.add(strength);
        System.out.println("Finished creating object of class CardStone.");
        System.out.println("Created card " + name + ": level: " + level + ", sort: " + sort + ", type: " + type + ", isWear: " + isWear + ", specifications: " + specifications + ", description: " + description);
    }
}
