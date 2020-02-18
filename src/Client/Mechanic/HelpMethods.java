package Client.Mechanic;

import Client.Objects.Cards.Card;
import Client.Objects.Cards.Materials.*;

public abstract class HelpMethods extends MainVariables {
    HelpMethods() {
        System.out.println("Creating object of class HelpMethods...");
        System.out.println("Finished creating object of class HelpMethods.");
    }
    public static Card returnTypeOfNearbyCardByName(Card card) {
        Card returnCard = null;
        switch (card.name) {
            case "Wood":
                returnCard = new CardWood();
                break;
            case "Stone":
                returnCard = new CardStone();
                break;
            case "SmallStone":
                returnCard = new CardSmallStone();
                break;
            case "Water":
                returnCard = new CardWater();
                break;
            case "Gold":
                returnCard = new CardGold();
                break;
            case "Diamond":
                returnCard = new CardDiamond();
                break;
        }
        return returnCard;
    }
}
