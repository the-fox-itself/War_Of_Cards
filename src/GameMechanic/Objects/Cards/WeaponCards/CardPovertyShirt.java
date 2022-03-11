package GameMechanic.Objects.Cards.WeaponCards; //Пакет класса.

import GameMechanic.Objects.Cards.Card; //Импорт класса-родителя.

public class CardPovertyShirt extends Card { //Карта Рубаха бродяги.
    public CardPovertyShirt() { //Конструктор для установления начальных характеристик.
        this.level = LEVEL_0;
        this.rarity = RARITY_STARTING;
        this.type = TYPE_WEAPON;
        this.name = NAME_POVERTY_SHIRT;
        this.description = "Старая, когда-то купленная на базаре, рубаха.";
        System.out.println("Created card " + name + ": level: " + level + ", sort: " + rarity + ", type: " + type + ", isWear: " + isWear + ", specifications: " + specifications + ", description: " + description);
    }
}
