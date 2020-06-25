package Client.Mechanic;

import Client.Objects.Cards.Card;
import Client.Objects.Essences.Essence;
import Client.Objects.Essences.EssenceWolf;
import Client.Objects.GameObjects.*;
import Client.Objects.Grounds.Ground;
import Client.Objects.Grounds.GroundGrass;
import Client.Objects.Grounds.GroundWater;
import Client.Objects.TechnicalObjects.Account;
import Client.Objects.TechnicalObjects.Player;
import Client.Objects.TechnicalObjects.Quest;
import Client.Objects.TechnicalObjects.World;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import static Client.Mechanic.ClientGameMechanic.*;
import static Client.Mechanic.MainGUIVariables.*;
import static Client.Mechanic.SwingPlus.Methods.*;

public class GUIListeners {
    GUIListeners() {
        printNote("Creating an object of class GUIListeners", NOTE_TYPE_DONE);
    }

    public static class SinglePlayer implements ActionListener { //Обработка нажатия кнопки buttonNewWorld.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            if (registered) {
                menuSinglePlayerWorlds();
            } else {
                visTrue(labelNeedRegistration);
                Runnable runnable = () -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    visFalse(labelNeedRegistration);
                };
                Thread thread = new Thread(runnable);
                thread.start();
            }
        }
    }
    public static class MultiPlayer implements ActionListener { //Обработка нажатия кнопки buttonNewWorld.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            if (registered) {

            } else {
                visTrue(labelNeedRegistration);
                Runnable runnable = () -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    visFalse(labelNeedRegistration);
                };
                Thread thread = new Thread(runnable);
                thread.start();
            }
        }
    }

    public static class NewWorld implements ActionListener { //Обработка нажатия кнопки buttonNewWorld.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            textQuests.requestFocus();
            worldCurrent = new World();
            playerCurrent = new Player();
            worldCurrent.listOfPlayers.add(playerCurrent);
            accountCurrent.listOfWorlds.add(worldCurrent);

            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier(x*10+1, 5001);
                worldCurrent.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier(-(x*10)+1, 5001);
                worldCurrent.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier(x*10+1, -4999);
                worldCurrent.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier(-(x*10)+1, -4999);
                worldCurrent.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier(5001, x*10+1);
                worldCurrent.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier(-4999, x*10+1);
                worldCurrent.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier(5001, -(x*10)+1);
                worldCurrent.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier(-4999, -(x*10)+1);
                worldCurrent.listOfObjects.add(barrier);
            }
            System.out.println("All ObjectBarriers have created.");

            for (int x = worldCurrent.startAmountOfWoods; x > 0; x--) {
                GameObject wood = new ObjectWood();
                wood.setLocations(wood);
                worldCurrent.listOfObjects.add(wood);
            }
            System.out.println("All ObjectWoods have created.");

            for (int x = worldCurrent.startAmountOfStones; x > 0; x--) {
                GameObject stone = new ObjectStone();
                stone.setLocations(stone);
                worldCurrent.listOfObjects.add(stone);
            }
            System.out.println("All ObjectStones have created.");
            for (int x = worldCurrent.startAmountOfSmallStones; x > 0; x--) {
                GameObject smallStone = new ObjectSmallStone();
                smallStone.setLocations(smallStone);
                worldCurrent.listOfObjects.add(smallStone);
            }
            System.out.println("All ObjectsSmallStones have created.");
            for (int x = worldCurrent.startAmountOfGolds; x > 0; x--) {
                GameObject gold = new ObjectGold();
                gold.setLocations(gold);
                worldCurrent.listOfObjects.add(gold);
            }
            System.out.println("All ObjectGolds have created.");
            for (int x = worldCurrent.startAmountOfDiamonds; x > 0; x--) {
                GameObject diamond = new ObjectDiamond();
                diamond.setLocations(diamond);
                worldCurrent.listOfObjects.add(diamond);
            }
            System.out.println("All ObjectDiamonds have created.");
            for (int x = worldCurrent.startAmountOfWolfs; x > 0; x--) {
                Essence wolf = new EssenceWolf();
                worldCurrent.listOfEssences.add(wolf);
            }
            System.out.println("All EssenceWolfs have created.");
            for (int x = -5000; x < 5000; x+=50) {
                for (int y = -5000; y < 5000; y+=50) {
                    GroundGrass groundGrass = new GroundGrass(x, y);
                    worldCurrent.listOfGrounds.add(groundGrass);
                }
            }
            System.out.println("All GroundGrasses have created.");
            for (int x = worldCurrent.startAmountOfWaters; x > 0; x--) {
                int xOfGround = ((int) (Math.random() * 200)-100)*50;
                int yOfGround = ((int) (Math.random() * 200)-100)*50;
                GroundWater groundWater = new GroundWater(xOfGround, yOfGround);
                worldCurrent.listOfGrounds.add(groundWater);
            }
            System.out.println("All GroundWaters have created.");
            Quest quest1 = new Quest(1, "Собрать 10 карт\n\n Дерево", 10, "Wood");
            quest1.runnableOn();
            Quest quest2 = new Quest(2, "Собрать 10 карт\n\n Камень", 10, "Stone");
            quest2.runnableOn();
            Quest quest3 = new Quest(3, "Собрать 5 карт\n\n Мальнький камень", 5, "SmallStone");
            quest3.runnableOn();
            Quest quest4 = new Quest(4, "Собрать 10 карт\n\n Золото", 10, "Gold");
            quest4.runnableOn();
            Quest quest5 = new Quest(5, "Собрать 10 карт\n\n Алмаз", 10, "Diamond");
            quest5.runnableOn();
            worldCurrent.listOfQuests.add(quest1);
            worldCurrent.listOfQuests.add(quest2);
            worldCurrent.listOfQuests.add(quest3);
            worldCurrent.listOfQuests.add(quest4);
            worldCurrent.listOfQuests.add(quest5);
            System.out.println("NEW WORLD HAS CREATED.");

            menuGame();
            visFalse(labelSaveAccount);

            runnableOn = true;
            regenerationOn = true;

            repaintPhase = REPAINT_GAME;
//            preparationRunnable(); //Вызов метода preparationRunnable() для создания и запуска нужных для игры потоков.

            gameStart = true; //Выдача переменной gameStart значение true.

            firstRespawn(); //Вызов метода firstRespawn() для выдачи игроку начальных предметов и первого поиска ближайших к нему объектов. Игра начинается.
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса NewWorld.
    public static class LoadWorld implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textQuests.requestFocus();
            if (worldCurrent != null) {
                for (Quest quest : worldCurrent.listOfQuests) {
                    quest.runnableOn();
                }

                repaintPhase = REPAINT_GAME;

                gameStart = true;

                menuGame();
                visFalse(labelSaveAccount);

                runnableOn = true;
                regenerationOn = true;
                visFalse(frame);
                visTrue(frame);
            }
        }
    }
    public static class SaveAccount implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttonSaveAccount.getBackground().equals(COLOR_INTERFACE_GREEN)) {
                if (save()) {
                    buttonSaveAccount.setBackground(COLOR_INTERFACE_ACTIVATE_GREEN);
                    labelSaveAccount.setText("Сохранение совершено успешно!");
                } else {
                    labelSaveAccount.setText("При сохранении произошли сбои.");
                }
                visTrue(labelSaveAccount);
                Runnable runnable = () -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    visFalse(labelSaveAccount);
                    if (buttonSaveAccount.getBackground().equals(COLOR_INTERFACE_ACTIVATE_GREEN)) {
                        buttonSaveAccount.setBackground(COLOR_INTERFACE_GREEN);
                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();
            }
        }
    }

    public static class Exit implements ActionListener { //Обработка нажатия кнопки buttonExit.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(0); //Завершение игры.
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса Exit.

    public static class ExitAccount implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            accountCurrent = null;
            registered = false;
            gameStart = false;
            labelAccount.setText("Вы не авторизованы");
            menuStartNotRegistered();
        }
    }

    public static class Settings implements ActionListener { //Обработка нажатия кнопки buttonSettings.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            if (buttonSettings.getBackground().equals(COLOR_INTERFACE_GREEN)) {
                buttonSettings.setBackground(COLOR_INTERFACE_ACTIVATE_GREEN);
                menuStartEnableSettings(true);
            } else if (buttonSettings.getBackground().equals(COLOR_INTERFACE_ACTIVATE_GREEN)){
                buttonSettings.setBackground(COLOR_INTERFACE_GREEN);
                menuStartEnableSettings(false);
            }
        } //Конец переопредлённого метода actionPerformed().
    }

    public static class NewAccount implements ActionListener { //Обработка нажатия кнопки buttonRegistration.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            textNick.setText("");
            textPassword.setText("");
            visFalse(labelWarning);
            visFalse(buttonNewAccountFromLoadAccount);
            buttonEndRegistration.setText("Зарегестрироваться");
            buttonEndRegistration.setFont(f20);
            if (buttonRegistration.getBackground().equals(COLOR_INTERFACE_GREEN)) {
                buttonRegistration.setBackground(COLOR_INTERFACE_ACTIVATE_GREEN);
                menuStartEnableRegistration(true);
                accountRegistration = true;
                visTrue(buttonLoadAccountFromNewAccount);
                if (buttonEntry.getBackground().equals(COLOR_INTERFACE_ACTIVATE_GREEN))
                    buttonEntry.setBackground(COLOR_INTERFACE_GREEN);
            } else if (buttonRegistration.getBackground().equals(COLOR_INTERFACE_ACTIVATE_GREEN)){
                buttonRegistration.setBackground(COLOR_INTERFACE_GREEN);
                menuStartEnableRegistration(false);
                accountRegistration = false;
                visFalse(buttonLoadAccountFromNewAccount);
            }
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса NewAccount.

    public static class LoadAccount implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textNick.setText("");
            textPassword.setText("");
            visFalse(labelWarning);
            visFalse(buttonLoadAccountFromNewAccount);
            buttonEndRegistration.setText("Войти");
            buttonEndRegistration.setFont(f30);
            if (buttonEntry.getBackground().equals(COLOR_INTERFACE_GREEN)) {
                buttonEntry.setBackground(COLOR_INTERFACE_ACTIVATE_GREEN);
                menuStartEnableRegistration(true);
                visTrue(buttonNewAccountFromLoadAccount);
                accountRegistration = false;
                if (buttonRegistration.getBackground().equals(COLOR_INTERFACE_ACTIVATE_GREEN))
                    buttonRegistration.setBackground(COLOR_INTERFACE_GREEN);
            } else if (buttonEntry.getBackground().equals(COLOR_INTERFACE_ACTIVATE_GREEN)){
                buttonEntry.setBackground(COLOR_INTERFACE_GREEN);
                menuStartEnableRegistration(false);
                visFalse(buttonNewAccountFromLoadAccount);
            }
        }
    }

    public static class EndOfRegistrationAccount implements ActionListener { //Обработка нажатия кнопки buttonEndRegistration.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            //Если все поля регистрации чем-то заполнены то это условие срабатывает.
            visFalse(labelNeedRegistration);
            if (!textNick.getText().equals("") && !textPassword.getText().equals("")) {
                if (accountRegistration) {
                    if (textNick.getText().split("").length > 20 || textPassword.getText().split("").length > 20) {
                        labelWarning.setFont(f17);
                        labelWarning.setText("Логин или пароль слишком длинные!");
                        visFalse(labelWarning);
                        visTrue(labelWarning);
                    } else {
                        boolean is = false;
                        try {
                            ObjectInputStream objectOutputStream = new ObjectInputStream(new FileInputStream("saves"+SEPARATOR+textNick.getText() + ".ser"));
                            objectOutputStream.readObject();
                        } catch (Exception e) {
                            e.printStackTrace();
                            is = true;
                        }
                        if (is) {
                            accountCurrent = new Account();
                            accountCurrent.nick = textNick.getText(); //Сохранение ника.
                            accountCurrent.password = textPassword.getText(); //Сохранение пароля.
                            registered = true;
                            makeRecentlySave();
                            buttonRegistration.setBackground(COLOR_INTERFACE_GREEN);
                            buttonEntry.setBackground(COLOR_INTERFACE_GREEN);
                            menuStartRegistered();
                        } else {
                            labelWarning.setFont(f17);
                            labelWarning.setText("Аккаунт с таким логином уже существует!");
                            visFalse(labelWarning);
                            visTrue(labelWarning);
                        }
                    }
                } else {
                    try {
                        ObjectInputStream objectOutputStream = new ObjectInputStream(new FileInputStream("saves"+SEPARATOR+textNick.getText() + ".ser"));
                        Account account = (Account) objectOutputStream.readObject();
                        if (account.password.equals(textPassword.getText())) {
                            accountCurrent = account;
                            accountCurrent.recovery();
                            if (accountCurrent.listOfWorlds.size() > 0) {
                                worldCurrent = accountCurrent.listOfWorlds.get(0);
                            }
                            registered = true;
                            makeRecentlySave();
                            buttonRegistration.setBackground(COLOR_INTERFACE_GREEN);
                            buttonEntry.setBackground(COLOR_INTERFACE_GREEN);
                            menuStartRegistered();
                        } else {
                            labelWarning.setFont(f20);
                            labelWarning.setText("Вход выполнен неудачно!");
                            visFalse(labelWarning);
                            visTrue(labelWarning);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        labelWarning.setFont(f20);
                        labelWarning.setText("Вход выполнен неудачно!");
                        visFalse(labelWarning);
                        visTrue(labelWarning);
                    }
                }
            } else if (textNick.getText().equals("") && textPassword.getText().equals("")) {
                labelWarning.setFont(f20);
                labelWarning.setText("Введите логин и пароль!");
                visFalse(labelWarning);
                visTrue(labelWarning);
            } else if (textNick.getText().equals("")) {
                labelWarning.setFont(f20);
                labelWarning.setText("Введите логин!");
                visFalse(labelWarning);
                visTrue(labelWarning);
            } else if (textPassword.getText().equals("")) {
                labelWarning.setFont(f20);
                labelWarning.setText("Введите пароль!");
                visFalse(labelWarning);
                visTrue(labelWarning);
            }
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса EndOfRegistrationAccount.


    public static class InventoryLeft implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            textQuests.requestFocus();
            if (buttonRight.isVisible()) {
                visFalse(buttonLeft);
//                labelSlots.setText();
            } else {
                visTrue(buttonRight);
            }

        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventoryLeft.

    public static class InventoryRight implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            textQuests.requestFocus();
            if (buttonLeft.isVisible()) {
                visFalse(buttonRight);
            } else {
                visTrue(buttonLeft);
            }

        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventoryRight.

    public static class InventorySlotsPants implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            textQuests.requestFocus();
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventorySlotsPants.
    public static class InventorySlotsShirt implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            textQuests.requestFocus();
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventorySlotsShirt.
    public static class InventorySlotsHands implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            textQuests.requestFocus();
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventorySlotsHands.

    //Событие нажатий клавиатуры
    public static class MainFrameKeyListener extends KeyAdapter implements KeyListener {
        @Override //Переопределение методов keyPressed(KeyEvent button), keyReleased(KeyEvent e) и keyTyped(KeyEvent e).
        public void keyPressed(KeyEvent button) {
            switch (button.getKeyChar()) { //Сравнивание нажатой клавиши с её возможными значениями.
                case '0':
                    if (!inventoryOpen) {
                        if (hitBoxModeOn) {
                            hitBoxModeOn = false;
                        } else {
                            hitBoxModeOn = true;
                            Color.RGBtoHSB(COLOR_GAME_PLAYER_SHADOW.getRed(), COLOR_GAME_PLAYER_SHADOW.getGreen(), COLOR_GAME_PLAYER_SHADOW.getBlue(), null);
                        }
                    }
                    break;
                case '1':
                    if (!inventoryOpen) {
                        if (!_1) {
                            _1 = true;
                        }
                    }
                    break;
                case '2':
                    if (!inventoryOpen) {
                        if (!_2) {
                            _2 = true;
                        }
                    }
                    break;
                case '3':
                    if (!inventoryOpen) {
                        if (!_3) {
                            _3 = true;
                        }
                    }
                    break;
                case '4':
                    if (!inventoryOpen) {
                        if (!_4) {
                            _4 = true;
                        }
                    }
                    break;
                case 'w':
                case 'ц':
                    if (!inventoryOpen) {
                        if (!w && !W) {
                            w = true;
                            if (!a && !A && !d && !D && !s && !S) {
                                iconPlayerCurrent = ANIMATION_PLAYER_BACK;
                            }
                        }
                    }
                    break;

                case 'W':
                case 'Ц':
                    if (!inventoryOpen) {
                        if (!w && !W) {
                            W = true;
                            if (!a && !A && !d && !D && !s && !S) {
                                iconPlayerCurrent = ANIMATION_PLAYER_BACK;
                            }
                        }
                    }
                    break;

                case 'a':
                case 'ф':
                    if (!inventoryOpen) {
                        if (!a && !A) {
                            a = true;
                            if (!d && !D) {
                                iconPlayerCurrent = ANIMATION_PLAYER_LEFT;
                            }
                        }
                    }
                    break;
                case 'A':
                case 'Ф':
                    if (!inventoryOpen) {
                        if (!a && !A) {
                            A = true;
                            if (!d && !D) {
                                iconPlayerCurrent = ANIMATION_PLAYER_LEFT;
                            }
                        }
                    }
                    break;

                case 's':
                case 'ы':
                    if (!inventoryOpen) {
                        if (!s && !S) {
                            s = true;
                            if (!a && !A && !d && !D && !w && !W) {
                                iconPlayerCurrent = ANIMATION_PLAYER_FRONT;
                            }
                        }
                    }
                    break;
                case 'S':
                case 'Ы':
                    if (!inventoryOpen) {
                        if (!s && !S) {
                            S = true;
                            if (!a && !A && !d && !D && !w && !W) {
                                iconPlayerCurrent = ANIMATION_PLAYER_FRONT;
                            }
                        }
                    }
                    break;

                case 'd':
                case 'в':
                    if (!inventoryOpen) {
                        if (!d && !D) {
                            d = true;
                            if (!a && !A) {
                                iconPlayerCurrent = ANIMATION_PLAYER_RIGHT;
                            }
                        }
                    }
                    break;
                case 'D':
                case 'В':
                    if (!inventoryOpen) {
                        if (!d && !D) {
                            D = true;
                            if (!a && !A) {
                                iconPlayerCurrent = ANIMATION_PLAYER_RIGHT;
                            }
                        }
                    }
                    break;

                case 0x1B: //Escape
                    if (!inventoryOpen) {
                        _1 = false;
                        _2 = false;
                        _3 = false;
                        _4 = false;
                        w = false;
                        W = false;
                        a = false;
                        A = false;
                        s = false;
                        S = false;
                        d = false;
                        D = false;
                        gameStart = false;

                        repaintPhase = REPAINT_MENU;
                        if (registered) {
                            menuStartRegistered();
                        } else {
                            menuStartNotRegistered();
                        }
                        frame.repaint();
                        visFalse(frame);
                        visTrue(frame);
                    }
                    break;

                case 'e':
                case 'E':
                case 'у':
                case 'У':
                    _1 = false;
                    _2 = false;
                    _3 = false;
                    _4 = false;
                    w = false;
                    W = false;
                    a = false;
                    A = false;
                    s = false;
                    S = false;
                    d = false;
                    D = false;

                    if (!inventoryOpen) {
                        System.out.println("\nУведомления. Ваши слоты:");
                        System.out.println("Древесина: " + playerCurrent.amountOfAllGettingCardWoods);
                        System.out.println("Камни: " + playerCurrent.amountOfAllGettingCardStones);
                        System.out.println("Маленькие камни: " + playerCurrent.amountOfAllGettingCardSmallStones);
                        System.out.println("Золото: " + playerCurrent.amountOfAllGettingCardGolds);
                        System.out.println("Алмаз: " + playerCurrent.amountOfAllGettingCardDiamonds);
                        System.out.println("Вода: " + playerCurrent.amountOfAllGettingCardWaters + "\n");

                        inventoryOpen = true;

                        for (Card card : playerCurrent.slots) {
                            if (card.name.equals("PovertyPants") && card.isWear) {
                                buttonPantsSlots.setText(card.name);
                                buttonPantsClothes.setText(card.name);
                            }
                        }
                        for (Card card : playerCurrent.slots) {
                            if (card.name.equals("PovertyShirt") && card.isWear) {
                                buttonShirtSlots.setText(card.name);
                                buttonShirtClothes.setText(card.name);
                            }
                        }

                        visFalse(labelNick);

                        visTrue(labelSlots);
                        visTrue(buttonRight);
                        visTrue(buttonLeft);
                        visTrue(buttonPantsSlots);
                        visTrue(buttonShirtSlots);
                        visTrue(buttonHandsSlots);

                        frame.repaint();
                    } else {
                        visTrue(labelNick);

                        visFalse(labelSlots);
                        visFalse(buttonRight);
                        visFalse(buttonLeft);
                        visFalse(buttonPantsSlots);
                        visFalse(buttonShirtSlots);
                        visFalse(buttonHandsSlots);

                        System.out.println("Уведомление. Выход из инвенторя.");
                        inventoryOpen = false;
                    }
                    break;
                case 't':
                case 'T':
                case 'е':
                case 'Е':
                    if (!inventoryOpen) {
                        int x = (int) ((Math.random() * 10) + 0.5) * 100 - 500; //450, 350, 250, 150, 50, -50, -150, -250, -350, -450
                        int y = (int) ((Math.random() * 10) + 0.5) * 100 - 500; //450, 350, 250, 150, 50, -50, -150, -250, -350, -450
                        playerCurrent.xOfPlayer -= x;
                        playerCurrent.yOfPlayer -= y;
                        for (Essence essence : worldCurrent.listOfEssences) {
                            essence.xOnFrame -= x;
                            essence.yOnFrame -= y;
                        }
                        for (GameObject gameObject : worldCurrent.listOfObjects) {
                            gameObject.xOnFrame -= x;
                            gameObject.yOnFrame -= y;
                        }
                        for (Ground ground : worldCurrent.listOfGrounds) {
                            ground.x -= x;
                            ground.y -= y;
                        }
                        setNotification("Использован телепорт радиусом 20 полей");
                        searchForNearbyGameObjects(); //Поиск, выделение и сохранение близких к игроку объектов.
                    }
                    break;
                case 'k':
                case 'K':
                case 'л':
                case 'Л':
                    if (!inventoryOpen) {
                        deathAndRespawn();
                    }
                    break;
            }
        }
        public void keyReleased(KeyEvent button) {
            switch (button.getKeyChar()) {
                case 'w':
                case 'ц':
                    if (!inventoryOpen) {
                        w = false;
                        if (s || S) {
                            iconPlayerCurrent = ANIMATION_PLAYER_FRONT;
                        } else if (!a && !A && !d && !D) {
                            iconPlayerCurrent = ICON_PLAYER_BACK;
                        }
                    }
                    break;
                case 'W':
                case 'Ц':
                    if (!inventoryOpen) {
                        W = false;
                        if (s || S) {
                            iconPlayerCurrent = ANIMATION_PLAYER_FRONT;
                        } else if (!a && !A && !d && !D) {
                            iconPlayerCurrent = ICON_PLAYER_BACK;
                        }
                    }
                    break;
                case 'a':
                case 'ф':
                    if (!inventoryOpen) {
                        a = false;
                        if (s || S) {
                            iconPlayerCurrent = ANIMATION_PLAYER_FRONT;
                        } else if (w || W) {
                            iconPlayerCurrent = ANIMATION_PLAYER_BACK;
                        } else if (d || D) {
                            iconPlayerCurrent = ANIMATION_PLAYER_RIGHT;
                        } else {
                            iconPlayerCurrent = ICON_PLAYER_LEFT;
                        }
                    }
                    break;
                case 'A':
                case 'Ф':
                    if (!inventoryOpen) {
                        A = false;
                        if (s || S) {
                            iconPlayerCurrent = ANIMATION_PLAYER_FRONT;
                        } else if (w || W) {
                            iconPlayerCurrent = ANIMATION_PLAYER_BACK;
                        } else if (d || D) {
                            iconPlayerCurrent = ANIMATION_PLAYER_RIGHT;
                        } else {
                            iconPlayerCurrent = ICON_PLAYER_LEFT;
                        }
                    }
                    break;
                case 's':
                case 'ы':
                    if (!inventoryOpen) {
                        s = false;
                        if (w || W) {
                            iconPlayerCurrent = ANIMATION_PLAYER_BACK;
                        } else if (!a && !A && !d && !D) {
                            iconPlayerCurrent = ICON_PLAYER_FRONT;
                        }
                    }
                    break;
                case 'S':
                case 'Ы':
                    if (!inventoryOpen) {
                        S = false;
                        if (w || W) {
                            iconPlayerCurrent = ANIMATION_PLAYER_BACK;
                        } else if (!a && !A && !d && !D) {
                            iconPlayerCurrent = ICON_PLAYER_FRONT;
                        }
                    }
                    break;
                case 'd':
                case 'в':
                    if (!inventoryOpen) {
                        d = false;
                        if (s || S) {
                            iconPlayerCurrent = ANIMATION_PLAYER_FRONT;
                        } else if (w || W) {
                            iconPlayerCurrent = ANIMATION_PLAYER_BACK;
                        } else if (a || A) {
                            iconPlayerCurrent = ANIMATION_PLAYER_LEFT;
                        } else {
                            iconPlayerCurrent = ICON_PLAYER_RIGHT;
                        }
                    }
                    break;
                case 'D':
                case 'В':
                    if (!inventoryOpen) {
                        D = false;
                        if (s || S) {
                            iconPlayerCurrent = ANIMATION_PLAYER_FRONT;
                        } else if (w || W) {
                            iconPlayerCurrent = ANIMATION_PLAYER_BACK;
                        } else if (a || A) {
                            iconPlayerCurrent = ANIMATION_PLAYER_LEFT;
                        } else {
                            iconPlayerCurrent = ICON_PLAYER_RIGHT;
                        }
                    }
                    break;
                case 0x31: //1
                    if (!inventoryOpen) {
                        _1 = false;
                    }
                    break;
                case 0x32: //2
                    if (!inventoryOpen) {
                        _2 = false;
                    }
                    break;
                case 0x33: //3
                    if (!inventoryOpen) {
                        _3 = false;
                    }
                    break;
                case 0x34: //4
                    if (!inventoryOpen) {
                        _4 = false;
                    }
                    break;
            }
        }

        public void keyTyped(KeyEvent button) {

        }
    }
    public static class MainFrameMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public static class MainFrameMouseMotionListener implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}
