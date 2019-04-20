package Client.Mechanic;

import Client.Objects.Cards.Clothes.CardBeggarPants;
import Client.Objects.Cards.Clothes.CardBeggarShirt;
import Client.Objects.Essences.Essence;
import Client.Objects.GameObjects.GameObject;

import static Client.Mechanic.GameGUI.*;

class GameProgress implements Runnable {
//        private boolean collision(char l) {
//        boolean ret = true;
//        int xPlayer = DrawPanel.xOfPlayer;
//        int yPlayer = DrawPanel.yOfPlayer;
//        int xObject;
//        int yObject;
//        switch (l) {
//            case 'w':
//                for (int n = NearbyGameObjects.size() - 1; n >= 0; n--) {
//                    if (NearbyGameObjects.get(n).name.equals("Камень")) {
//                        xObject = NearbyGameObjects.get(n).x;
//                        yObject = NearbyGameObjects.get(n).y;
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
//                                        yObject = NearbyGameObjects.get(n).y;
//                                    }
//                                }
//                                xObject += 1;
//                            }
//                            xPlayer += 1;
//                            xObject = NearbyGameObjects.get(n).x;
//                        }
//                    }
//                }
//                break;
//            case 's':
//                for (int n = NearbyGameObjects.size() - 1; n >= 0; n--) {
//                    if (NearbyGameObjects.get(n).name.equals("Камень")) {
//                        xObject = NearbyGameObjects.get(n).x + NearbyGameObjects.get(n).width;
//                        yObject = NearbyGameObjects.get(n).y + NearbyGameObjects.get(n).height;
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
//                                        yObject = NearbyGameObjects.get(n).y;
//                                    }
//                                }
//                                xObject -= 1;
//                            }
//                            xPlayer += 1;
//                            xObject = NearbyGameObjects.get(n).x;
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

    void searchForNearbyGameObjects() {
        for (int n = NearbyGameObjects.size() - 1; n >= 0; n--) {
            NearbyGameObjects.remove(n);
        }
        for (GameObject gameObject : listOfObjects) {
            switch (gameObject.name) {
                case "Древесина":
                    gameObject.color = colorWood;
                    break;
                case "Камень":
                    gameObject.color = colorStone;
                    break;
                case "Маленький камень":
                    gameObject.color = colorSmallStone;
                    break;
                case "Вода":
                    gameObject.color = colorWater;
                    break;
            }
        }
        int x = xOfPlayer - 40;
        int y = yOfPlayer - 40;
        for (GameObject gameObject : listOfObjects) {
            while (x <= xOfPlayer + 50) {
                if (x == gameObject.x  + (gameObject.height / 2)) {
                    while (y <= yOfPlayer + 50) {
                        if (y == gameObject.y + (gameObject.height / 2)) {
                            NearbyGameObjects.add(gameObject);
                            switch (gameObject.name) {
                                case "Древесина":
                                    gameObject.color = colorWoodNearby;
                                    break;
                                case "Камень":
                                    gameObject.color = colorStoneNearby;
                                    break;
                                case "Маленький камень":
                                    gameObject.color = colorSmallStoneNearby;
                                    break;
                                case "Золото":
                                    gameObject.color = colorGoldNearby;
                                    break;
                                case "Вода":
                                    gameObject.color = colorWaterNearby;
                                    break;
                            }
                        }
                        y++;
                    }
                    y = yOfPlayer - 40;
                }
                x++;
            }
            x = xOfPlayer - 40;
        }
    }

    //Метод для нажатия кнопки Войти в игру
    void spawn() {
        if (slots.isEmpty()) {
            CardBeggarPants cardBeggarPants = new CardBeggarPants();
            CardBeggarShirt cardBeggarShirt = new CardBeggarShirt();
            cardBeggarPants.isWear = true;
            cardBeggarShirt.isWear = true;
            slots.add(cardBeggarPants);
            slots.add(cardBeggarShirt);
        }
    }

    @Override
    public void run() {
        while (true) {
            for (int n = listOfEssences.size() - 1; n >= 0; n--) {
                if (listOfEssences.get(n).name.equals("Волк")) {
                    boolean isX = false;
                    boolean isY = false;
                    if (listOfEssences.get(n).x > xOfPlayer && isStartGame) {
                        if (listOfEssences.get(n).x - xOfPlayer < 300) {
                            isX = true;
                        }
                    } else if (listOfEssences.get(n).x < xOfPlayer && isStartGame) {
                        if (xOfPlayer - listOfEssences.get(n).x < 300) {
                            isX = true;
                        }
                    } else if (listOfEssences.get(n).x == xOfPlayer && isStartGame) {
                        isX = true;
                    }
                    if (listOfEssences.get(n).y > yOfPlayer && isStartGame) {
                        if (listOfEssences.get(n).y - yOfPlayer < 300) {
                            isY = true;
                        }
                    } else if (listOfEssences.get(n).y < yOfPlayer && isStartGame) {
                        if (yOfPlayer - listOfEssences.get(n).y < 300) {
                            isY = true;
                        }
                    } else if (listOfEssences.get(n).y == yOfPlayer && isStartGame) {
                        isY = true;
                    }
                    if (isX && isY) {
                        int rand = (int) (Math.random() * 4);
                        switch (rand) {
                            case 0:
                                if (xOfPlayer < listOfEssences.get(n).x) {
                                    listOfEssences.get(n).x -= 2 * listOfEssences.get(n).essenceSpeed;
                                } else if (xOfPlayer > listOfEssences.get(n).x) {
                                    listOfEssences.get(n).x += 2 * listOfEssences.get(n).essenceSpeed;
                                } else {
                                    if (yOfPlayer < listOfEssences.get(n).y) {
                                        listOfEssences.get(n).y -= 2 * listOfEssences.get(n).essenceSpeed;
                                    } else if (yOfPlayer > listOfEssences.get(n).y) {
                                        listOfEssences.get(n).y += 2 * listOfEssences.get(n).essenceSpeed;
                                    }
                                }
                                break;
                            case 1:
                                if (xOfPlayer > listOfEssences.get(n).x) {
                                    listOfEssences.get(n).x += 2 * listOfEssences.get(n).essenceSpeed;
                                } else if (xOfPlayer < listOfEssences.get(n).x) {
                                    listOfEssences.get(n).x -= 2 * listOfEssences.get(n).essenceSpeed;
                                } else {
                                    if (yOfPlayer < listOfEssences.get(n).y) {
                                        listOfEssences.get(n).y -= 2 * listOfEssences.get(n).essenceSpeed;
                                    } else if (yOfPlayer > listOfEssences.get(n).y) {
                                        listOfEssences.get(n).y += 2 * listOfEssences.get(n).essenceSpeed;
                                    }
                                }
                                break;
                            case 2:
                                if (yOfPlayer < listOfEssences.get(n).y) {
                                    listOfEssences.get(n).y -= 2 * listOfEssences.get(n).essenceSpeed;
                                } else if (yOfPlayer > listOfEssences.get(n).y) {
                                    listOfEssences.get(n).y += 2 * listOfEssences.get(n).essenceSpeed;
                                } else {
                                    if (xOfPlayer < listOfEssences.get(n).x) {
                                        listOfEssences.get(n).x -= 2 * listOfEssences.get(n).essenceSpeed;
                                    } else if (xOfPlayer > listOfEssences.get(n).x) {
                                        listOfEssences.get(n).x += 2 * listOfEssences.get(n).essenceSpeed;
                                    }
                                }
                                break;
                            case 3:
                                if (yOfPlayer > listOfEssences.get(n).y) {
                                    listOfEssences.get(n).y += 2 * listOfEssences.get(n).essenceSpeed;
                                } else if (yOfPlayer < listOfEssences.get(n).y) {
                                    listOfEssences.get(n).y -= 2 * listOfEssences.get(n).essenceSpeed;
                                } else {
                                    if (xOfPlayer < listOfEssences.get(n).x) {
                                        listOfEssences.get(n).x -= 2 * listOfEssences.get(n).essenceSpeed;
                                    } else if (xOfPlayer > listOfEssences.get(n).x) {
                                        listOfEssences.get(n).x += 2 * listOfEssences.get(n).essenceSpeed;
                                    }
                                }
                                break;
                        }
                        if ((yOfPlayer == listOfEssences.get(n).y || yOfPlayer == listOfEssences.get(n).y + 2 || yOfPlayer == listOfEssences.get(n).y + 4 || yOfPlayer == listOfEssences.get(n).y - 2 || yOfPlayer == listOfEssences.get(n).y - 4) && (xOfPlayer == listOfEssences.get(n).x || xOfPlayer == listOfEssences.get(n).x + 2 || xOfPlayer == listOfEssences.get(n).x + 4 || xOfPlayer == listOfEssences.get(n).x - 2 || xOfPlayer == listOfEssences.get(n).x - 4)) {
                            System.out.println("Game Over!");
                            System.out.println(slots);
                            for (int x = slots.size() - 1; x >= 0; x--) {
                                slots.remove(x);
                            }
                            for (Essence essence : listOfEssences) {
                                essence.x = essence.startX;
                                essence.y = essence.startY;
                            }
                            for (GameObject gameObject : listOfObjects) {
                                gameObject.x = gameObject.startX;
                                gameObject.y = gameObject.startY;
                            }
                        }
                    } else {
                        int rand = (int) (Math.random() * 4);
                        switch (rand) {
                            case 0:
                                listOfEssences.get(n).x -= 2 * listOfEssences.get(n).essenceSpeed;
                                break;
                            case 1:
                                listOfEssences.get(n).x += 2 * listOfEssences.get(n).essenceSpeed;
                                break;
                            case 2:
                                listOfEssences.get(n).y -= 2 * listOfEssences.get(n).essenceSpeed;
                                break;
                            case 3:
                                listOfEssences.get(n).y += 2 * listOfEssences.get(n).essenceSpeed;
                                break;
                        }
                    }
                }
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
