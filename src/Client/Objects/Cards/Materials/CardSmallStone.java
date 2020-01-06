package Client.Objects.Cards.Materials; //Пакет класса.

import Client.Objects.Cards.Card; //Импорт класса-родителя.

public class CardSmallStone extends Card { //Карта Маленький камень.
    public CardSmallStone() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class CardSmallStone...");
        level = 0;
        sort = "Poverty card";
        type = "Natural card";
        name = "SmallStone";
        description = "Маленький камушек,  который можно поднять с земли руками.";
        int strength = (int) (Math.random() * 100); //Создание дополнительной характеристики - прочности и присваивание её specifications.
        if (strength > 50) {
            strength -= 30;
        }
        specifications.add(strength);
        System.out.println("Finished creating object of class CardSmallStone.");
        System.out.println("Created card " + name + ": level: " + level + ", sort: " + sort + ", type: " + type + ", isWear: " + isWear + ", specifications: " + specifications + ", description: " + description);
    }
}
