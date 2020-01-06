package Client.Objects.Cards.Materials; //Пакет класса.

import Client.Objects.Cards.Card; //Импорт класса-родителя.

public class CardWater extends Card { // Карта Вода.
    public CardWater() { //Конструктор для установления начальных характеристик.
        System.out.println("Creating object of class CardWater...");
        level = 0;
        sort = "Peasant Card";
        type = "Natural card";
        name = "Water";
        description = "Обычная вода из озера.";
        int strength = (int) (Math.random() * 100); //Создание дополнительной характеристики - прочности и присваивание её specifications.
        if (strength > 50) {
            strength -= 30;
        }
        specifications.add(strength);
        System.out.println("Finished creating object of class CardWater.");
        System.out.println("Created card " + name + ": level: " + level + ", sort: " + sort + ", type: " + type + ", isWear: " + isWear + ", specifications: " + specifications + ", description: " + description);
    }
}
