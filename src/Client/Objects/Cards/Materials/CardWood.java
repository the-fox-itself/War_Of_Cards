package Client.Objects.Cards.Materials; //Пакет класса.

import Client.Objects.Cards.Card; //Импорт класса-родителя.

public class CardWood extends Card { //Карта Древесина.
    public CardWood() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class CardWood...");
        level = 0;
        sort = "Poverty card";
        type = "Natural card";
        name = "Wood";
        description = "Самая обычная природная древесина.";
        int strength = (int) (Math.random() * 100); //Создание дополнительной характеристики - прочности и присваивание её specifications.
        if (strength > 50) {
            strength -= 30;
        }
        specifications.add(strength);
        System.out.println("Finished creating object of class CardWood.");
        System.out.println("Created card " + name + ": level: " + level + ", sort: " + sort + ", type: " + type + ", isWear: " + isWear + ", specifications: " + specifications + ", description: " + description);
    }
}
