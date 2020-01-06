package Client.Mechanic;

import Client.Objects.Cards.Clothes.CardPovertyPants;
import Client.Objects.Cards.Clothes.CardPovertyShirt;

import static Client.Mechanic.MainVariables.*;

abstract class GameProgress {
    GameProgress() {
        System.out.println("Creating object of class GameProgress...");
        System.out.println("Finished creating object of class GameProgress.");
    }
//        private boolean collision(char l) {
//        boolean ret = true;
//        int xPlayer = xOfPlayerOnFrame;
//        int yPlayer = yOfPlayerOnFrame;
//        int xObject;
//        int yObject;
//        switch (l) {
//            case 'w':
//                for (int n = NearbyGameObjects.size() - 1; n >= 0; n--) {
//                    if (NearbyGameObjects.get(n).name.equals("Stone")) {
//                        xObject = NearbyGameObjects.get(n).xOnFrame;
//                        yObject = NearbyGameObjects.get(n).yOnFrame;
//                        for (int x2 = 10; x2 > 0; x2--) {
//                            for (int x1 = NearbyGameObjects.get(n).height; x1 > 0; x1--) {
//                                if (xPlayer == xObject) {
//                                    for (int x3 = 10; x3 > 0; x3--) {
//                                        for (int x4 = NearbyGameObjects.get(n).height; x4 > 0; x4--) {
//                                            if (yPlayer == yObject) {
//                                                ret = false;
//                                            }
//                                            yObject += 1;
//                                        }
//                                        yPlayer += 1;
//                                        yObject = NearbyGameObjects.get(n).yOnFrame;
//                                    }
//                                }
//                                xObject += 1;
//                            }
//                            xPlayer += 1;
//                            xObject = NearbyGameObjects.get(n).xOnFrame;
//                        }
//                    }
//                }
//                break;
//            case 's':
//                for (int n = NearbyGameObjects.size() - 1; n >= 0; n--) {
//                    if (NearbyGameObjects.get(n).name.equals("Stone")) {
//                        xObject = NearbyGameObjects.get(n).xOnFrame + NearbyGameObjects.get(n).width;
//                        yObject = NearbyGameObjects.get(n).yOnFrame + NearbyGameObjects.get(n).height;
//                        for (int x2 = 10; x2 > 0; x2--) {
//                            for (int x1 = NearbyGameObjects.get(n).height; x1 > 0; x1--) {
//                                if (xPlayer == xObject) {
//                                    for (int x3 = 10; x3 > 0; x3--) {
//                                        for (int x4 = NearbyGameObjects.get(n).height; x4 > 0; x4--) {
//                                            if (yPlayer == yObject) {
//                                                ret = false;
//                                            }
//                                            yObject -= 1;
//                                        }
//                                        yPlayer += 1;
//                                        yObject = NearbyGameObjects.get(n).yOnFrame;
//                                    }
//                                }
//                                xObject -= 1;
//                            }
//                            xPlayer += 1;
//                            xObject = NearbyGameObjects.get(n).xOnFrame;
//                        }
//                    }
//                }
//                break;
//            case 'a':
//
//                break;
//            case 'd':
//
//                break;
//        }
//        return ret;
//    }

    static void searchForNearbyGameObjects() {
        worldNow.NearbyGameObjects.subList(0, worldNow.NearbyGameObjects.size()).clear();
        int x = xOfPlayerOnFrame - 40;
        int y = yOfPlayerOnFrame - 40;
        int z = 0;
        while (z < worldNow.listOfObjects.size()) {
            while (x <= xOfPlayerOnFrame + 50) {
                if (worldNow.listOfObjects.get(z).name.equals("Water") || worldNow.listOfObjects.get(z).name.equals("Barrier") ? x == worldNow.listOfObjects.get(z).xOnFrame + (worldNow.listOfObjects.get(z).width / 2) : x == worldNow.listOfObjects.get(z).xOnFrame + (worldNow.listOfObjects.get(z).isNearby ? worldNow.listOfObjects.get(z).iconOfNearby.getWidth(null) / 2 : worldNow.listOfObjects.get(z).iconOfNearby.getWidth(null) / 2)) {
                    while (y <= yOfPlayerOnFrame + 50) {
                        if (worldNow.listOfObjects.get(z).name.equals("Water") || worldNow.listOfObjects.get(z).name.equals("Barrier") ? y == worldNow.listOfObjects.get(z).yOnFrame + (worldNow.listOfObjects.get(z).height / 2) : y == worldNow.listOfObjects.get(z).yOnFrame + (worldNow.listOfObjects.get(z).isNearby ? worldNow.listOfObjects.get(z).iconOfNearby.getHeight(null) / 2 : worldNow.listOfObjects.get(z).iconOfNearby.getHeight(null) / 2)) {
                            worldNow.NearbyGameObjects.add(worldNow.listOfObjects.get(z));
                            switch (worldNow.listOfObjects.get(z).name) {
                                case "Wood":
                                case "Stone":
                                case "Gold":
                                case "Diamond":
                                case "SmallStone":
                                    worldNow.listOfObjects.get(z).isNearby = true;
                                    break;
                                case "Water":
                                    worldNow.listOfObjects.get(z).color = colorWaterNearby;
                                    break;
                            }
                        }
                        y++;
                    }
                    y = yOfPlayerOnFrame - 40;
                }
                x++;
            }
            x = xOfPlayerOnFrame - 40;
            z++;
        }
        int z1 = 0;
        while (z1 < worldNow.listOfObjects.size()) {
            if (worldNow.NearbyGameObjects.indexOf(worldNow.listOfObjects.get(z1)) == -1) {
                switch (worldNow.listOfObjects.get(z1).name) {
                    case "Wood":
                    case "Stone":
                    case "Gold":
                    case "Diamond":
                    case "SmallStone":
                        worldNow.listOfObjects.get(z1).isNearby = false;
                        break;
                    case "Water":
                        worldNow.listOfObjects.get(z1).color = colorWater;
                        break;
                }
            }
            z1++;
        }
    }

    //Метод
    static void firstRespawn() {
        searchForNearbyGameObjects(); //Поиск, выделение и сохранение близких к игроку объектов.
        if (worldNow.slots.isEmpty()) {
            CardPovertyPants cardPovertyPants = new CardPovertyPants();
            CardPovertyShirt cardPovertyShirt = new CardPovertyShirt();
            cardPovertyPants.isWear = true;
            cardPovertyShirt.isWear = true;
            worldNow.slots.add(cardPovertyPants);
            worldNow.slots.add(cardPovertyShirt);
        }
    }
}
