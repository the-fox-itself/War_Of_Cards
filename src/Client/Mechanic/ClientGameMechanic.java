package Client.Mechanic; //Пакет класса.

//Импорт классов из пакетов Mechanic и Objects.
import Client.Objects.Cards.Card;
import Client.Objects.Cards.WeaponCards.CardPovertyPants;
import Client.Objects.Cards.WeaponCards.CardPovertyShirt;
import Client.Objects.Cards.NaturalCards.*;
import Client.Objects.Essences.Essence;
import Client.Objects.GameObjects.*;
import Client.Objects.Grounds.Ground;
import Client.Objects.TechnicalObjects.Quest;

import static Client.Mechanic.MainGUIVariables.*;
import static Client.Mechanic.GUIListeners.*;
import static Client.Mechanic.SwingPlus.Methods.*;

//Импорт библиотек API.
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

//Это - ClientGameMechanic - класс для отслеживания пользовательских нажатий по мышке, клавиатуре, фрейму и т. д., также в этом классе хранятся потоки, которые используются в игровой механике.
class ClientGameMechanic { //Этот класс наследует все открытые переменные класса MainGUIVariables, а также всё то, что MainGUIVariables унаследовал от своих классов-родителей.
    ClientGameMechanic() {
        printNote("Creating an object of class ClientGameMechanic", NOTE_TYPE_DONE);
    }

    //Метод preparationGUI(), вызывающийся методом main(String[] args). Он подготавливает GUI и обработчики событий, мир и объекты в нём.
    void preparationGUI() {
        printNote("Completing method preparationGUI()", NOTE_TYPE_PROCESS);
        try {
            printNote("Loading font AlundraText", NOTE_TYPE_PROCESS);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("resources"+SEPARATOR+"fonts"+SEPARATOR+"AlundraText.ttf")));
            printNote("Loading font AlundraText", NOTE_TYPE_DONE);
        } catch (IOException | FontFormatException e) {
            printNote("Loading font AlundraText has failed", NOTE_TYPE_ERROR);
            e.printStackTrace();
        }
        printNote("Screen size: " +(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() + "x" + (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight(), NOTE_TYPE_INFO);
        printNote("Frame size: " + FRAME_WIDTH + "x" + FRAME_HEIGHT, NOTE_TYPE_INFO);

        DrawPanel drawPanel = new DrawPanel();
        frame.add(drawPanel);
        drawPanel.setBounds(0, 0, 2000, 2000);
        printNote("Adding object drawPanel on container frame", NOTE_TYPE_DONE);

//        textWorlds.setEditable(false);
//        scrollPanel.add(scrollPaneWorlds);
//        frame.add(scrollPanel);
//        scrollPanel.setBounds(0, 400, 1000, 1000);
//        scrollPaneWorlds.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        textWorlds.setBackground(COLOR_INTERFACE_ACTIVATE_GREEN);

        frame.setIconImage(ICON_FRAME);

        textQuests.setEditable(false);
        textQuests.addKeyListener(new MainFrameKeyListener()); //Обработчик событий, выслеживающий нажатия по клавиатуре при открытии окна frame.
        printNote("Adding KeyListener on object textQuests", NOTE_TYPE_DONE);
        textQuests.addMouseListener(new MainFrameMouseListener());
        printNote("Adding MouseListener on object textQuests", NOTE_TYPE_DONE);
        textQuests.addMouseMotionListener(new MainFrameMouseMotionListener());
        printNote("Adding MouseMotionListener on object textQuests", NOTE_TYPE_DONE);

        preparationRunnable();
        if (getRecentlySave()) {
            makeRecentlySave();
            menuStartRegistered();
        } else {
            menuStartNotRegistered();
        }
        printNote("Completing method preparationGUI()", NOTE_TYPE_DONE);
    }

    public static void menuStartNotRegistered() {
        visFalseAll();

        visTrue(buttonSinglePlayer);
        visTrue(buttonMultiPlayer);
        visTrue(buttonExit);
        visTrue(buttonSettings);

        visTrue(buttonRegistration);
        visTrue(buttonEntry);
        visTrue(labelAccount);

        visTrue(frame);
    }
    public static void menuStartRegistered() {
        visFalseAll();

//        visTrue(scrollPanel);
//        visTrue(scrollPaneWorlds);
//        visTrue(textWorlds);

        visTrue(buttonSinglePlayer);
        visTrue(buttonMultiPlayer);
        visTrue(buttonExit);
        visTrue(buttonSettings);

        visTrue(buttonExitAccount);
        visTrue(buttonSaveAccount);
        visTrue(labelAccount);
        if (accountCurrent != null) {
            labelAccount.setText("Ваш аккаунт: " + accountCurrent.nick);
        }

        visTrue(frame);
    }
    public static void menuStartEnableRegistration(boolean isActivate) {
        if (isActivate) {
            visTrue(labelRegisterNick);
            visTrue(textNick);
            visTrue(labelRegisterPassword);
            visTrue(textPassword);
            visTrue(buttonEndRegistration);

            labelNick.requestFocus();
        } else {
            visFalse(labelRegisterNick);
            visFalse(textNick);
            visFalse(labelRegisterPassword);
            visFalse(textPassword);
            visFalse(buttonEndRegistration);
        }
    }
    public static void menuStartEnableSettings(boolean isActivate) {
        if (isActivate) {

        } else {

        }
    }
    public static void menuSinglePlayerWorlds() {
        visFalseAll();

        visTrue(labelAccount);
        visTrue(buttonExitAccount);
        visTrue(buttonSaveAccount);

        visTrue(buttonExit);
        visTrue(buttonSettings);
        visTrue(buttonLoadWorld);
        visTrue(buttonNewWorld);

        visTrue(frame);
    }
    public static void menuGame() {
        visFalseAll();

        labelNick.setText(accountCurrent.nick);
        visTrue(labelNick);
        visTrue(textQuests);
        visFalse(frame);
        visTrue(frame);
    }

    //Метод preparationRunnable(), вызывающийся во время начала игры для подготовки и запуску потоков repaintRunnable и wolfRunnable.
    private void preparationRunnable() { //Нужно продолжить улучшение потоков........................................................................
        printNote("Completing method preparationRunnable()", NOTE_TYPE_PROCESS);
        if (!runnablePrepared) { //Эта строчка и переменная runnablePrepared нужны для того, чтобы метод запускался только один раз, а не преумножался при каждом старте игры.
            printNote("Starting thread runnableRepaint", NOTE_TYPE_PROCESS);
            runnableRepaint = () -> {
                while (true) {
                    if (repaintOn) {
                        frame.repaint(); //Выполнение перерисовки окна frame.
                    }
                }
            };
            threadRepaint = new Thread(runnableRepaint);
            threadRepaint.start();
            printNote("Starting thread runnableRepaint", NOTE_TYPE_DONE);

            printNote("Starting thread mainRunnable", NOTE_TYPE_PROCESS);
            Runnable mainRunnable = () -> {
                while (true) {
                    if (runnableOn) {
                        if (gameStart && timerMainRunnableActions % TIME_RUNNABLE_DIVIDER_WOLF_PROCESSING == 0) {
                            for (Essence essence : worldCurrent.listOfEssences) { //То, что находится в этом цикле for, произойдёт со всеми объектами из списка listOfEssences.
                                if (essence.name.equals("Wolf")) { //Отсортировываем всех существ и берём только волков.
                                    if (!collisionWithBarrier(essence.xOnFrame, essence.yOnFrame)) { //Если волк не наступил на барьер.
                                        boolean isX = false; //Создаём булеву переменную для проверки близости игрока к волку по оси x.
                                        boolean isY = false; //Создаём булеву переменную для проверки близости игрока к волку по оси y.
                                        if (essence.xOnFrame - playerXFrame < 300 && essence.xOnFrame - playerXFrame > -300) { //Если игрок относительно волка находится не дальше 300 пикселей по оси x.
                                            isX = true; //То даем переменной isX значение true, чтобы показать, что игрок близок к волку по оси x.
                                        } //Конец if.
                                        if (essence.yOnFrame - playerYFrame < 300 && essence.yOnFrame - playerYFrame > -300) { //Если игрок относительно волка находится не дальше 300 пикселей по оси y.
                                            isY = true; //То даем переменной isY значение true, чтобы показать, что игрок близок к волку по оси y.
                                        } //Конец if.
                                        if (isX && isY) { //Если игрок близок к волку и по оси x, и по оси y.
                                            if ((playerYFrame - essence.yOnFrame < 5 && playerYFrame - essence.yOnFrame > -5)
                                                    && (playerXFrame - essence.xOnFrame < 5 && playerXFrame - essence.xOnFrame > -5)) { //Если волк очень близко к игроку.
                                                playerXFrame -= 10;
                                                try { //try-catch для паузы.
                                                    Thread.sleep(2); //Пауза в размере 2 милисекунд.
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace(); //Обработка ошибки.
                                                }
                                                playerXFrame += 20;
                                                try { //try-catch для паузы.
                                                    Thread.sleep(2); //Пауза в размере 2 милисекунд.
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace(); //Обработка ошибки.
                                                }
                                                playerXFrame -= 10;
                                                if (timerPlayerTakeDamage == 0) { //Если переменная-таймер timerPlayerTakeDamage равна 0.
                                                    playerCurrent.health--; //У игрока отнимается одна жизнь.
                                                    timerPlayerRegeneration = TIME_PLAYER_REGENERATION_AFTER_TAKE_DAMAGE;
                                                    frame.repaint();
                                                } //Конец if.
                                                if (playerCurrent.health == 0) { //Если у игрока 0 жизней.
                                                    deathAndRespawn(); //Он погибает и респавнится.
                                                } else { //Если у игрока не 0 жизней.
                                                    if (timerPlayerTakeDamage == 0) { //И если переменная-таймер timerPlayerTakeDamage равна 0.
                                                        timerPlayerTakeDamage = TIME_PLAYER_TAKE_DAMAGE; //Ей придаётся значение переменной TIME_PLAYER_TAKE_DAMAGE.
                                                    } else { //Если переменная-таймер timerPlayerTakeDamage не равна 0.
                                                        timerPlayerTakeDamage--; //Она уменьшается на единицу.
                                                    } //Конец else.
                                                } //Конец else.
                                            } else { //Если же волк не достаточно близок к игроку, чтобы укусить его.
                                                if (playerXFrame - essence.xOnFrame < -3) { //Если игрок находится левее волка.
                                                    essence.xOnFrame -= 2 * essence.essenceSpeed; //То волк двигается влево, по направлению к игроку.
                                                    essence.icon = ICON_WOLF_LEFT;
                                                } else if (playerXFrame - essence.xOnFrame > 3) { //Если игрок находится правее волка.
                                                    essence.xOnFrame += 2 * essence.essenceSpeed; //То волк двигается вправо, по направлению к игроку.
                                                    essence.icon = ICON_WOLF_RIGHT;
                                                }
                                                if (playerYFrame - essence.yOnFrame < -3) { //Если игрок находится выше волка.
                                                    essence.yOnFrame -= 2 * essence.essenceSpeed; //То волк двигается вверх, по направлению к игроку.
                                                } else if (playerYFrame - essence.yOnFrame > 3) { //Если игрок находится ниже волка.
                                                    essence.yOnFrame += 2 * essence.essenceSpeed; //То волк двигается вниз, по направлению к игроку.
                                                }
                                            }
                                        } else if (essence.timePassed == 0) { //Если же игрок не достаточно близок к волку, чтобы волк его заметил и при этом настало время для следующего шага.
                                            int rand = (int) (Math.random() * 4); //То вычисляем случайное значение для переменной rand в пределах от 0 до 3 включительно.
                                            switch (rand) { //Исли переменной rand дали значение...
                                                case 0: //...0
                                                    essence.xOnFrame -= 2 * essence.essenceSpeed; //Передвижение волка влево на определённое количество пикселей, в зависимости от скорости волка.
                                                    essence.icon = ICON_WOLF_LEFT;
                                                    break; //Конец кейса.
                                                case 1: //...1
                                                    essence.xOnFrame += 2 * essence.essenceSpeed; //Передвижение волка вправо на определённое количество пикселей, в зависимости от скорости волка.
                                                    essence.icon = ICON_WOLF_RIGHT;
                                                    break; //Конец кейса.
                                                case 2: //...2
                                                    essence.yOnFrame -= 2 * essence.essenceSpeed; //Передвижение волка вверх на определённое количество пикселей, в зависимости от скорости волка.
                                                    break; //Конец кейса.
                                                case 3: //...3
                                                    essence.yOnFrame += 2 * essence.essenceSpeed; //Передвижение волка вниз на определённое количество пикселей, в зависимости от скорости волка.
                                                    break; //Конец кейса.
                                            }
                                            essence.timePassed = essence.timeOfNextWalk; //Заводим новое время для того, чтобы волк не бегал, как сумасшедшиц.
                                        } else { //Если же время не настало и запущен таймер.
                                            essence.timePassed--; //То уменьшаем его.
                                        } //Конец else.
                                    } else { //Если же волк наступил на барьер.
                                        System.out.println(essence + " has died."); //Вывод системного уведомления.
                                        worldCurrent.listOfEssences.remove(essence); //Удаление волка из списка существ.
                                        System.out.println("Уведомление. Волк не знал, что в игре есть барьеры и умер от одного из них."); //Вывод пользовательского уведомления.
                                        break; //Выход
                                    }
                                } //Конец if
                            } //Конец цикла for.
                        }
                        if (_1 && timerMainRunnableActions % TIME_RUNNABLE_DIVIDER_RESOURCE_MINING == 0) {
                            resourceMining("SmallStone");
                        }
                        if (_2 && timerMainRunnableActions % TIME_RUNNABLE_DIVIDER_RESOURCE_MINING == 0) {
                            resourceMining("Wood");
                            resourceMining("Stone");
                        }
                        if (_3 && timerMainRunnableActions % TIME_RUNNABLE_DIVIDER_RESOURCE_MINING == 0) {
                            resourceMining("Gold");
                            resourceMining("Diamond");
                        }
                        if (_4 && timerMainRunnableActions % TIME_RUNNABLE_DIVIDER_RESOURCE_MINING == 0) {
                            resourceMining("Water");
                        }

                        if (w && !s && !S) {
                            playerMove('y', +1);
                        } else if (W && !S && !s) {
                            playerMove('y', +2);
                        }
                        if (s && !w && !W) {
                            playerMove('y', -1);
                        } else if (S && !W && !w) {
                            playerMove('y', -2);
                        }
                        if (d && !a && !A) {
                            playerMove('x', -1);
                        } else if (D && !A && !a) {
                            playerMove('x', -2);
                        }
                        if (a && !d && !D) {
                            playerMove('x', +1);
                        } else if (A && !D && !d) {
                            playerMove('x', +2);
                        }

                        if (timerMainRunnableActions % TIME_RUNNABLE_DIVIDER_SEARCH_NEARBY_OBJECTS == 0 && gameStart) {
                            searchForNearbyGameObjects(); //Поиск, выделение и сохранение близких к игроку объектов.
                        }
                        try { //try-catch для избегания остановки кода при ошибке.
                            Thread.sleep(10); //Пауза в размере 10 милисекунд для избегания постоянной перерисовки и большой нагрузки на компьютер.
                        } catch (InterruptedException e) {
                            e.printStackTrace(); //Обработка ошибки.
                        }
                        if (timerMainRunnableActions == TIME_RUNNABLE_END) {
                            timerMainRunnableActions = 0;
                        }
                        timerMainRunnableActions++;
                    } else {
                        try { //try-catch для избегания остановки кода при ошибке.
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace(); //Обработка ошибки.
                        }
                    }
                }
            };
            Thread mainThread = new Thread(mainRunnable);
            mainThread.start();
            printNote("Starting thread mainRunnable", NOTE_TYPE_DONE);

            printNote("Starting thread runnableHP", NOTE_TYPE_PROCESS);
            Runnable runnableHP = () -> {
                while (true) {
                    if (regenerationOn) {
                        if (timerPlayerRegeneration > 0) {
                            if (timerPlayerRegeneration == TIME_PLAYER_REGENERATION_GO && playerCurrent.health != playerCurrent.maxHealth) {
                                playerCurrent.health++;
                                if (playerCurrent.health != playerCurrent.maxHealth) {
                                    timerPlayerRegeneration = TIME_PLAYER_REGENERATION_AFTER_REGENERATION;
                                } else {
                                    timerPlayerRegeneration = 0;
                                }
                            } else {
                                timerPlayerRegeneration--;

                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        try { //try-catch для избегания остановки кода при ошибке.
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace(); //Обработка ошибки.
                        }
                    }
                }
            };
            Thread threadHP = new Thread(runnableHP);
            threadHP.start();
            printNote("Starting thread runnableHP", NOTE_TYPE_DONE);


            runnablePrepared = true; //Изменеие значения переменной runnablePrepared на true для запрещения очередного вызова этого метода.
            printNote("Completing method preparationRunnable()", NOTE_TYPE_DONE);
        } //Конец if.
    } //Конец метода preparationRunnable().

    private boolean collisionWithBarrier(int x, int y) {
        for (GameObject gameObject : worldCurrent.listOfObjects) {
            if (gameObject.name.equals("Barrier")) {
                if ((gameObject.xOnFrame+4 - x < 6 && gameObject.xOnFrame+4 - x > -6) && (gameObject.yOnFrame+4 - y < 6 && gameObject.yOnFrame+4 - y > -6)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void deathAndRespawn() {
        System.out.println("Уведомление. Вы умерли");
        playerCurrent.amountOfDeaths++;
        System.out.println("Уведомление. Ваше количество смертей: " + playerCurrent.amountOfDeaths);
        playerCurrent.health = playerCurrent.maxHealth;
        playerCurrent.slots.subList(0, playerCurrent.slots.size()).clear();
        for (Quest quest : worldCurrent.listOfQuests) {
            quest.setCompleted(false);
            ArrayList<Card> list = new ArrayList<>();
            quest.setReachCards(list);
            quest.setNow(false);
        }
        playerCurrent.amountOfCompletedQuests = 0;
        for (Essence essence : worldCurrent.listOfEssences) {
            essence.xOnFrame -= playerCurrent.xOfPlayer;
            essence.yOnFrame -= playerCurrent.yOfPlayer;
        }
        for (GameObject gameObject : worldCurrent.listOfObjects) {
            gameObject.xOnFrame -= playerCurrent.xOfPlayer;
            gameObject.yOnFrame -= playerCurrent.yOfPlayer;
        }
        for (Ground ground : worldCurrent.listOfGrounds) {
            ground.x -= playerCurrent.xOfPlayer;
            ground.y -= playerCurrent.yOfPlayer;
        }
        playerCurrent.xOfPlayer = 0;
        playerCurrent.yOfPlayer = 0;

        setNotification("Вы умерли! Ваше текущее количество смертей: " + playerCurrent.amountOfDeaths);

        iconPlayerCurrent = ICON_PLAYER_FRONT;
        searchForNearbyGameObjects(); //Поиск, выделение и сохранение близких к игроку объектов.
    }

    private void resourceMining(String nameOfSearchObject) {
        int indexOfNearbyObject = playerCurrent.listOfNearbyGameObjects.size() - 1; //В переменную n сохраняется длина массива listOfNearbyGameObjects.
        if (indexOfNearbyObject != -1) { //Если он не пустой, то это условие срабатывает.
            while (!playerCurrent.listOfNearbyGameObjects.get(indexOfNearbyObject).name.equals(nameOfSearchObject)) { //Поиск древесины в массиве listOfNearbyGameObjects.
                indexOfNearbyObject--;
                if (indexOfNearbyObject == -1) { //Если поблизости деревья не найдены, то программа выходит из цикла.
                    break;
                }
            }
            if (indexOfNearbyObject != -1) { //Повторный условный оператор, т.к. после не нахождения деревьев поблизости переменная n могла стать -1.
                if (playerCurrent.listOfNearbyGameObjects.get(indexOfNearbyObject).name.equals(nameOfSearchObject)) {
                    worldCurrent.listOfObjects.remove(playerCurrent.listOfNearbyGameObjects.get(indexOfNearbyObject));
                    Card card = null;
                    switch (playerCurrent.listOfNearbyGameObjects.get(indexOfNearbyObject).name){
                        case "Wood":
                            card = new CardWood();
                            playerCurrent.amountOfAllGettingCardWoods++;
                            setNotification("Добыт ресурс: Дерево");
                            break;
                        case "Stone":
                            card = new CardStone();
                            playerCurrent.amountOfAllGettingCardStones++;
                            setNotification("Добыт ресурс: Камень");
                            break;
                        case "SmallStone":
                            card = new CardSmallStone();
                            playerCurrent.amountOfAllGettingCardSmallStones++;
                            setNotification("Добыт ресурс: Маленький камень");
                            break;
                        case "Gold":
                            card = new CardGold();
                            playerCurrent.amountOfAllGettingCardGolds++;
                            setNotification("Добыт ресурс: Золото");
                            break;
                        case "Diamond":
                            card = new CardDiamond();
                            playerCurrent.amountOfAllGettingCardDiamonds++;
                            setNotification("Добыт ресурс: Алмаз");
                            break;
                        case "Water":
                            card = new CardWater();
                            playerCurrent.amountOfAllGettingCardWaters++;
                            setNotification("Добыт ресурс: Вода");
                            break;
                    }
                    playerCurrent.slots.add(card);
                    playerCurrent.amountOfAllGettingCards++;
                    System.out.println("Уведомление. Получен ресурс: " + playerCurrent.listOfNearbyGameObjects.get(indexOfNearbyObject).name);
                }
            }
        }
    }

    private boolean playerMoveCollision(char l) {
        boolean ret = true;
        int xPlayer = playerXFrame;
        int yPlayer = playerYFrame;
        int xObject;
        int yObject;
        switch (l) {
            case 'w':
                for (int n = playerCurrent.listOfNearbyGameObjects.size() - 1; n >= 0; n--) {
                    if (playerCurrent.listOfNearbyGameObjects.get(n).name.equals("Stone")) {
                        xObject = playerCurrent.listOfNearbyGameObjects.get(n).xOnFrame;
                        yObject = playerCurrent.listOfNearbyGameObjects.get(n).yOnFrame;
                        for (int x2 = 10; x2 > 0; x2--) {
                            for (int x1 = playerCurrent.listOfNearbyGameObjects.get(n).height; x1 > 0; x1--) {
                                if (xPlayer == xObject) {
                                    for (int x3 = 10; x3 > 0; x3--) {
                                        for (int x4 = playerCurrent.listOfNearbyGameObjects.get(n).height; x4 > 0; x4--) {
                                            if (yPlayer == yObject) {
                                                ret = false;
                                            }
                                            yObject += 1;
                                        }
                                        yPlayer += 1;
                                        yObject = playerCurrent.listOfNearbyGameObjects.get(n).yOnFrame;
                                    }
                                }
                                xObject += 1;
                            }
                            xPlayer += 1;
                            xObject = playerCurrent.listOfNearbyGameObjects.get(n).xOnFrame;
                        }
                    }
                }
                break;
            case 's':
                for (int n = playerCurrent.listOfNearbyGameObjects.size() - 1; n >= 0; n--) {
                    if (playerCurrent.listOfNearbyGameObjects.get(n).name.equals("Stone")) {
                        xObject = playerCurrent.listOfNearbyGameObjects.get(n).xOnFrame + playerCurrent.listOfNearbyGameObjects.get(n).width;
                        yObject = playerCurrent.listOfNearbyGameObjects.get(n).yOnFrame + playerCurrent.listOfNearbyGameObjects.get(n).height;
                        for (int x2 = 10; x2 > 0; x2--) {
                            for (int x1 = playerCurrent.listOfNearbyGameObjects.get(n).height; x1 > 0; x1--) {
                                if (xPlayer == xObject) {
                                    for (int x3 = 10; x3 > 0; x3--) {
                                        for (int x4 = playerCurrent.listOfNearbyGameObjects.get(n).height; x4 > 0; x4--) {
                                            if (yPlayer == yObject) {
                                                ret = false;
                                            }
                                            yObject -= 1;
                                        }
                                        yPlayer += 1;
                                        yObject = playerCurrent.listOfNearbyGameObjects.get(n).yOnFrame;
                                    }
                                }
                                xObject -= 1;
                            }
                            xPlayer += 1;
                            xObject = playerCurrent.listOfNearbyGameObjects.get(n).xOnFrame;
                        }
                    }
                }
                break;
            case 'a':

                break;
            case 'd':

                break;
        }
        return ret;
    }

    public static void searchForNearbyGameObjects() {
        playerCurrent.listOfNearbyGameObjects.subList(0, playerCurrent.listOfNearbyGameObjects.size()).clear();
        for (GameObject gameObject : worldCurrent.listOfObjects) {
            gameObject.isNearby = false;
            for (int x = gameObject.xOnFrame - 40; x <= gameObject.xOnFrame + 40; x++) {
                if (x == playerXFrame) {
                    for (int y = gameObject.yOnFrame - 40; y <= gameObject.yOnFrame + 40; y++) {
                        if (y == playerYFrame) {
                            playerCurrent.listOfNearbyGameObjects.add(gameObject);
                            switch (gameObject.name) {
                                case "Wood":
                                case "Stone":
                                case "Gold":
                                case "Diamond":
                                case "SmallStone":
                                    gameObject.isNearby = true;
                                    break;
                                case "Water":
                                    gameObject.color = COLOR_OBJECT_WATER_NEARBY;
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }

    private ArrayList<GameObject> ObjectSortingByY(ArrayList<GameObject> gameObjects) {
        ArrayList<GameObject> returnGameObjects = new ArrayList<>();
        intList = new int[gameObjects.size()];
        for (GameObject gameObject : gameObjects) {
            intList[gameObjects.indexOf(gameObject)] = gameObject.yOnWorld;
        }
        Arrays.sort(intList);
        for (int integer : intList) {
            for (GameObject gameObject : gameObjects) {
                if (gameObject.yOnWorld == integer) {
                    returnGameObjects.add(gameObject);
                    break;
                }
            }
        }
        return returnGameObjects;

//        int trueTheNorthernY = -100000; //Север - меньший y, Юг - больший y.
//        for (int x = 1; x < gameObjects.size(); x++) {
//            int theNorthernY = 100000;
//            GameObject theNorthernObject = null;
//            for (GameObject gameObject : gameObjects) {
//                if (gameObject.yOnFrame < theNorthernY && gameObject.yOnFrame >= trueTheNorthernY) {
//                    theNorthernY = gameObject.yOnFrame;
//                    theNorthernObject = gameObject;
//                }
//            }
//            if (theNorthernObject != null) {
//                returnGameObjects.add(theNorthernObject);
//                trueTheNorthernY = theNorthernObject.yOnFrame;
//            }
//        }
    }

    private void playerMove(char XOnFrameOrYOnFrame, int numOfPixelsToMove) {
        if (!collisionWithBarrier(playerXFrame, playerYFrame)) {
            for (GameObject gameObject : worldCurrent.listOfObjects) {
                switch (XOnFrameOrYOnFrame) {
                    case 'x':
                        gameObject.xOnFrame += numOfPixelsToMove;
                        break;
                    case 'y':
                        gameObject.yOnFrame += numOfPixelsToMove;
                        break;
                }
            }
            if (numOfPixelsToMove > 0) {
                for (Ground ground : worldCurrent.listOfGrounds) {
                    switch (XOnFrameOrYOnFrame) {
                        case 'x':
                            ground.x += numOfPixelsToMove;
                            break;
                        case 'y':
                            ground.y += numOfPixelsToMove;
                            break;
                    }
                }
            } else {
                for (int x = worldCurrent.listOfGrounds.size()-1; x >= 0; x--) {
                    switch (XOnFrameOrYOnFrame) {
                        case 'x':
                            worldCurrent.listOfGrounds.get(x).x += numOfPixelsToMove;
                            break;
                        case 'y':
                            worldCurrent.listOfGrounds.get(x).y += numOfPixelsToMove;
                            break;
                    }
                }
            }
            for (Essence essence : worldCurrent.listOfEssences) {
                switch (XOnFrameOrYOnFrame) {
                    case 'x':
                        essence.xOnFrame += numOfPixelsToMove;
                        break;
                    case 'y':
                        essence.yOnFrame += numOfPixelsToMove;
                        break;
                }
            }
            switch (XOnFrameOrYOnFrame) {
                case 'x':
                    playerCurrent.xOfPlayer += numOfPixelsToMove;
                    break;
                case 'y':
                    playerCurrent.yOfPlayer += numOfPixelsToMove;
                    break;
            }
        } else {
            deathAndRespawn();
        }
    }

    static void setNotification(String notification) {
        JLabel labelNotification = getLabelNullLayout(notification, f25, frame, 1150, frame.getHeight()-120, 1000, 50, COLOR_INTERFACE_ORANGE) ;
        visTrue(labelNotification);
        Runnable runnable = () -> {
            int sleep = 50;
            while (labelNotification.getY() < frame.getHeight()+20) {
                labelNotification.setBounds(labelNotification.getX(), labelNotification.getY()+1, labelNotification.getWidth(), labelNotification.getHeight());
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (sleep < 40) {
                    labelNotification.setForeground(new Color(labelNotification.getForeground().getRed(), labelNotification.getForeground().getGreen(), labelNotification.getForeground().getBlue(), labelNotification.getForeground().getAlpha()-10));
                }
                if (labelNotification.getY()%3 == 0) {
                    sleep -= 1;
                }
            }
            visFalse(labelNotification);
        };
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("START                              NOT: " + notification);
    }

    private static void visFalseAll() {
        visFalse(buttonSinglePlayer);
        visFalse(buttonMultiPlayer);

        visFalse(buttonRegistration);
        visFalse(buttonEntry);
        visFalse(buttonLoadAccountFromNewAccount);
        visFalse(buttonNewAccountFromLoadAccount);
        visFalse(buttonNewWorld);
        visFalse(buttonSaveAccount);
        visFalse(buttonLoadWorld);
        visFalse(buttonExit);
        visFalse(buttonExitAccount);
        visFalse(buttonSettings);
        visFalse(buttonEndRegistration);
        visFalse(buttonRight);
        visFalse(buttonLeft);

        visFalse(buttonPantsClothes);
        visFalse(buttonShirtClothes);

        visFalse(buttonPantsSlots);
        visFalse(buttonShirtSlots);
        visFalse(buttonHandsSlots);

        visFalse(labelNewAccount);
        visFalse(labelRegisterNick);
        visFalse(labelRegisterPassword);
        visFalse(labelAccount);
        visFalse(labelWarning);
        visFalse(labelSlots);
        visFalse(labelNick);
        visFalse(labelSaveAccount);

        visFalse(textNick);
        visFalse(textPassword);

        visFalse(textNameForNewWorld);

        visFalse(textQuests);
    }

    //Не клиентская часть.
    public static boolean save() {
        if (accountCurrent != null) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("saves"+SEPARATOR+accountCurrent.nick + ".ser"));
                objectOutputStream.writeObject(accountCurrent);
                objectOutputStream.close();
                System.out.println("Аккаунт " + accountCurrent.nick + " успешно сохранён!");
                System.out.println(accountCurrent.toString());
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public static void firstRespawn() {
        searchForNearbyGameObjects(); //Поиск, выделение и сохранение близких к игроку объектов.
        if (playerCurrent.slots.isEmpty()) {
            CardPovertyPants cardPovertyPants = new CardPovertyPants();
            CardPovertyShirt cardPovertyShirt = new CardPovertyShirt();
            cardPovertyPants.isWear = true;
            cardPovertyShirt.isWear = true;
            playerCurrent.slots.add(cardPovertyPants);
            playerCurrent.slots.add(cardPovertyShirt);
        }
        setNotification("Мир успешно создан!");
        iconPlayerCurrent = ICON_PLAYER_FRONT;
    }
}