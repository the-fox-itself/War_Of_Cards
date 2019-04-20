package Client.Mechanic; //Пакет класса.

import Client.Objects.Cards.Card; //Импорт классов из других пакетов.
import Client.Objects.Cards.Materials.*;
import Client.Objects.Essences.Essence;
import Client.Objects.GameObjects.GameObject;

import java.awt.*;
import java.awt.event.*; //Импорт библиотек.

public class GameEvents extends GameGUI implements Runnable { //Класс для хранения событий нажатий кнопок во фрейме и кнопок на клавиатуре.
    void readyActionListeners() { //Метод, вызывающийся методом main. Он устанавливает обработчиков событий и вызывает метод, подготавливающий GUI игры.
        readyGUI();
        buttonPlay.addActionListener(new Play());
        buttonExit.addActionListener(new Exit());
        buttonSettings.addActionListener(new Settings());
        buttonRegister.addActionListener(new Register());
        buttonEndRegister.addActionListener(new EndRegister());
        buttonRegisterBack.addActionListener(new RegisterBack());
        gameFrame.addKeyListener(new ClickGameFrame());
        startFrame.setVisible(true);

        buttonHandsSlots.addActionListener(new InventorySlotsHands());
        buttonPantsSlots.addActionListener(new InventorySlotsPants());
        buttonShirtSlots.addActionListener(new InventorySlotsShirt());
        buttonRight.addActionListener(new InventoryRight());
        buttonLeft.addActionListener(new InventoryLeft());
    }
    void readyRunnable() {
        if (!isRunnable) {
            Runnable repaintRunnable = new GameEvents();
            Thread thread1 = new Thread(repaintRunnable);
            thread1.start();
            Runnable wolfRunnable = new GameProgress();
            Thread thread = new Thread(wolfRunnable);
            thread.start();
            isRunnable = true;
        }
    }

    //Обработка событий кнопок.
    public class Play implements ActionListener { //Обработка нажатия кнопки buttonPlay.
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (password != null && age != 0 && !nick.equals("")) {
                startFrame.setVisible(false);
                gameFrame.setVisible(true);
                phase = 1;
                readyRunnable();
                spawn();
            } else {
                registerFrame.setVisible(true);
                textNick.requestFocus();
                ifStartRegister = true;
            }
        }
    }

    public class Exit implements ActionListener { //Обработка нажатия кнопки buttonExit.
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(0); //Завершение игры.
        }
    }

    public class Settings implements ActionListener { //Обработка нажатия кнопки buttonSettings.
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            settingsFrame.setVisible(true); //Открытие окна настроек.
        }
    }

    public class Register implements ActionListener { //Обработка нажатия кнопки buttonRegister.
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ifStartRegister = false; //Сохранение информации о том, что регистрация была начата с кнопки buttonRegister.
            registerFrame.setVisible(true);
            textNick.requestFocus();
        }
    }

    private class EndRegister implements ActionListener { //Обработка нажатия кнопки buttonEndRegister.
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try { //Проверка правильного введения возраста.
                age = Integer.parseInt(textAge.getText()); //Если переведение вписанного возраста в числа выдаст ошибку, программа перейдёт в catch.
                registerFrame.remove(labelWarning); //Удаление надписи, предупреждающей о неправильном введении возраста.
            } catch (NumberFormatException e) {
                age = 0; //Исправление значения переменной age.
                textAge.setText(""); //Опустошение поля возраст для неудачной работы следующего условия.
                textAge.requestFocus(); //Наведение курсора на поле Возраст.
                labelWarning.setBounds(120, 110, 200, 30); //Появление надписи, предупреждающей о неправильном введении возраста.
            }
            if (!textNick.getText().equals("") && !textPassword.getText().equals("") && !textAge.getText().equals("")) { //Если все поля регистрации чем-то заполнены, а возраст получилось перевести в цифры, то это условие срабатывает.
                nick = textNick.getText(); //Сохранение ника.
                password = textPassword.getText(); //Сохранение пароля.
                startFrame.remove(buttonRegister); //Удаление кнопки buttonRegister со startFrame.
                labelAccount.setText(nick); //Появление надписи с введённым ником на startFrame.
                labelAccount.setBounds(30, 540, 250, 40);
                registerFrame.setVisible(false); //Скрытие registerFrame.
                if (ifStartRegister) { //Если регистрация была совершена посредством нажатия кнопки buttonPlay, то это условие срабатывает.
                    startFrame.setVisible(false); //Скрытие startFrame.
                    registerFrame.setVisible(false); //Скрытие registerFrame.
                    settingsFrame.setVisible(false); //Скрытие settingsFrame.
                    gameFrame.setVisible(true);
                    phase = 1;
                    readyRunnable();
                    spawn(); //Начало игры.
                }
            }
        }
    }

    private class RegisterBack implements ActionListener { //Обработка нажатия кнопки buttonRegisterBack.
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            registerFrame.setVisible(false); //Закрытие окна регистрации.
        }
    }
/////////////////////////////////////////////////////////////////////////
    private class InventoryRight implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            gameFrame.remove(buttonRight);
            buttonRight.removeActionListener(new InventoryRight());
            buttonLeft.removeActionListener(new InventoryLeft());
            buttonLeft.addActionListener(new CharacterisesLeft());
        }
    }
    private class InventoryLeft implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            gameFrame.remove(buttonLeft);
            buttonLeft.removeActionListener(new InventoryLeft());
            buttonRight.removeActionListener(new InventoryRight());
            buttonRight.addActionListener(new ClothesRight());
        }
    }

    private class ClothesRight implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            gameFrame.add(buttonLeft);
            buttonLeft.addActionListener(new InventoryLeft());
            buttonLeft.setBounds(10, gameFrame.getHeight()/2 - 40, 90, 80);
            buttonRight.removeActionListener(new ClothesRight());
            buttonRight.addActionListener(new InventoryRight());
        }
    }
    private class CharacterisesLeft implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            gameFrame.add(buttonRight);
            buttonRight.addActionListener(new InventoryRight());
            buttonRight.setBounds(gameFrame.getWidth()-100, gameFrame.getHeight()/2 - 40, 90, 80);
            buttonLeft.removeActionListener(new CharacterisesLeft());
            buttonLeft.addActionListener(new InventoryLeft());
        }
    }

    private class InventorySlotsPants implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
    private class InventorySlotsShirt implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
    private class InventorySlotsHands implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
//////////////////////////////////////////////////////////////////////////
    //События клавиатуры
    public class ClickGameFrame extends KeyAdapter implements KeyListener {
        public void keyPressed(KeyEvent button) {
            isStartGame = true;
            phase = 1; //Изменение фазы DrawPanel на основную.
            gameFrame.add(labelAccount);
            labelAccount.setBounds(30, 540, 250, 40);
            gameFrame.remove(labelSlots);
            gameFrame.remove(buttonRight);
            gameFrame.remove(buttonLeft);
            gameFrame.remove(buttonPantsSlots);
            gameFrame.remove(buttonShirtSlots);
            gameFrame.remove(buttonHandsSlots);
            switch (button.getKeyChar()) { //Сравнивание нажатой клавиши с её возможными значениями.
                case '1': //Добыча древесины.
                    int n = NearbyGameObjects.size() - 1; //В переменную n сохраняется длина массива NearbyGameObjects.
                    if (n != -1) { //Если он не пустой, то это условие срабатывает.
                        while (!NearbyGameObjects.get(n).name.equals("Древесина")) { //Поиск древесины в массиве NearbyGameObjects.
                            n--;
                            if (n == -1) { //Если поблизости деревья не найдены, то программа выходит из цикла.
                                break;
                            }
                        }
                        if (n != -1) { //Повторный условный оператор, т.к. после не нахождения деревьев поблизости переменная n могла стать -1.
                            if (NearbyGameObjects.get(n).name.equals("Древесина")) {
                                double plus = 0;
                                int rand = (int) (Math.random() * 3);
                                switch (rand) {
                                    case 0:
                                        plus = 2.5;
                                        break;
                                    case 1:
                                        plus = 2.5;
                                        break;
                                    case 2:
                                        plus = 5;
                                }
                                NearbyGameObjects.get(n).x += plus;
                                NearbyGameObjects.get(n).y += plus;
                                NearbyGameObjects.get(n).height -= plus * 2;
                                NearbyGameObjects.get(n).width -= plus * 2;
                                if (NearbyGameObjects.get(n).height <= 0 || NearbyGameObjects.get(n).width <= 0) {
                                    listOfObjects.remove(NearbyGameObjects.get(n));
                                }
                                CardWood cardWood = new CardWood();
                                slots.add(cardWood);
                                System.out.println("Получен ресурс: " + NearbyGameObjects.get(n).name);
                            }
                        }
                    }
                    break;
                case '2': //Добыча камней и маленьких камней.
                    int n2 = NearbyGameObjects.size() - 1;
                    if (n2 != -1) {
                        while (!NearbyGameObjects.get(n2).name.equals("Камень") && !NearbyGameObjects.get(n2).name.equals("Маленький камень")) {
                            n2--;
                            if (n2 == -1) {
                                break;
                            }
                        }
                        if (n2 != -1) {
                            if (NearbyGameObjects.get(n2).name.equals("Камень")) {
                                double plus = 0;
                                int rand = (int) (Math.random() * 3);
                                switch (rand) {
                                    case 0:
                                        plus = 2.5;
                                        break;
                                    case 1:
                                        plus = 2.5;
                                        break;
                                    case 2:
                                        plus = 5;
                                }
                                NearbyGameObjects.get(n2).x += plus;
                                NearbyGameObjects.get(n2).y += plus;
                                NearbyGameObjects.get(n2).height -= plus * 2;
                                NearbyGameObjects.get(n2).width -= plus * 2;
                                if (NearbyGameObjects.get(n2).height <= 0 || NearbyGameObjects.get(n2).width <= 0) {
                                    listOfObjects.remove(NearbyGameObjects.get(n2));
                                }
                                CardStone cardStone = new CardStone();
                                slots.add(cardStone);
                                System.out.println("Получен ресурс: " + NearbyGameObjects.get(n2).name);
                            }
                            if (NearbyGameObjects.get(n2).name.equals("Маленький камень")) {
                                listOfObjects.remove(NearbyGameObjects.get(n2));
                                CardSmallStone cardSmallStone = new CardSmallStone();
                                slots.add(cardSmallStone);
                                System.out.println("Получен ресурс: " + NearbyGameObjects.get(n2).name);
                            }
                        }
                    }
                    break;
                case '3': //Добыча камней и маленьких камней.
                    int n3 = NearbyGameObjects.size() - 1;
                    if (n3 != -1) {
                        while (!NearbyGameObjects.get(n3).name.equals("Золото")) {
                            n3--;
                            if (n3 == -1) {
                                break;
                            }
                        }
                        if (n3 != -1) {
                            if (NearbyGameObjects.get(n3).name.equals("Золото")) {
                                double plus = 0;
                                int rand = (int) (Math.random() * 3);
                                switch (rand) {
                                    case 0:
                                        plus = 1;
                                        break;
                                    case 1:
                                        plus = 1;
                                        break;
                                    case 2:
                                        plus = 2;
                                }
                                NearbyGameObjects.get(n3).x += plus;
                                NearbyGameObjects.get(n3).y += plus;
                                NearbyGameObjects.get(n3).height -= plus * 2;
                                NearbyGameObjects.get(n3).width -= plus * 2;
                                if (NearbyGameObjects.get(n3).height <= 0 || NearbyGameObjects.get(n3).width <= 0) {
                                    listOfObjects.remove(NearbyGameObjects.get(n3));
                                }
                                CardGold cardGold = new CardGold();
                                slots.add(cardGold);
                                System.out.println("Получен ресурс: " + NearbyGameObjects.get(n3).name);
                            }
                        }
                    }
                    break;
                case '4': //Добыча камней и маленьких камней.
                    int n4 = NearbyGameObjects.size() - 1;
                    if (n4 != -1) {
                        while (!NearbyGameObjects.get(n4).name.equals("Вода")) {
                            n4--;
                            if (n4 == -1) {
                                break;
                            }
                        }
                        if (n4 != -1) {
                            if (NearbyGameObjects.get(n4).name.equals("Вода")) {
                                double plus = 0;
                                int rand = (int) (Math.random() * 3);
                                switch (rand) {
                                    case 0:
                                        plus = 1;
                                        break;
                                    case 1:
                                        plus = 1;
                                        break;
                                    case 2:
                                        plus = 2;
                                }
                                NearbyGameObjects.get(n4).x += plus;
                                NearbyGameObjects.get(n4).y += plus;
                                NearbyGameObjects.get(n4).height -= plus * 2;
                                NearbyGameObjects.get(n4).width -= plus * 2;
                                if (NearbyGameObjects.get(n4).height <= 0 || NearbyGameObjects.get(n4).width <= 0) {
                                    listOfObjects.remove(NearbyGameObjects.get(n4));
                                }
                                CardWater cardWater = new CardWater();
                                slots.add(cardWater);
                                System.out.println("Получен ресурс: " + NearbyGameObjects.get(n4).name);
                            }
                        }
                    }
                    break;
                case 'w': //Хотьба вперёд.
                case 'ц':
                    for (GameObject gameObject : listOfObjects) {
                        gameObject.y += 2;
                    }
                    for (Essence essence : listOfEssences) {
                        essence.y += 2;
                    }
                    helpGroundXMinus = 20;
                    if (helpGroundYMinus == 20 || helpGroundYMinus == 16) {
                        helpGroundYMinus = 18;
                    } else if (helpGroundYMinus != 18) {
                        helpGroundYMinus = 20;
                    }
                    break;
                case 'Ц': //Бег вперёд.
                case 'W':
                    for (GameObject gameObject : listOfObjects) {
                        gameObject.y += 4;
                    }
                    for (Essence essence : listOfEssences) {
                        essence.y += 4;
                    }
                    helpGroundXMinus = 20;
                    if (helpGroundYMinus == 20 || helpGroundYMinus == 18) {
                        helpGroundYMinus = 16;
                    } else if (helpGroundYMinus != 16) {
                        helpGroundYMinus = 20;
                    }
                    break;

                case 'a': //Хотьба налево.
                case 'ф':
                    for (GameObject gameObject : listOfObjects) {
                        gameObject.x += 2;
                    }
                    for (Essence essence : listOfEssences) {
                        essence.x += 2;
                    }
                    helpGroundYMinus = 20;
                    if (helpGroundXMinus == 20 || helpGroundXMinus == 16) {
                        helpGroundXMinus = 18;
                    } else if (helpGroundXMinus != 18) {
                        helpGroundXMinus = 20;
                    }
                    break;
                case 'Ф': //Бег налево.
                case 'A':
                    for (GameObject gameObject : listOfObjects) {
                        gameObject.x += 4;
                    }
                    for (Essence essence : listOfEssences) {
                        essence.x += 4;
                    }
                    helpGroundYMinus = 20;
                    if (helpGroundXMinus == 20 || helpGroundXMinus == 18) {
                        helpGroundXMinus = 16;
                    } else if (helpGroundXMinus != 16) {
                        helpGroundXMinus = 20;
                    }
                    break;

                case 's': //Хотьба назад.
                case 'ы':
                    for (GameObject gameObject : listOfObjects) {
                        gameObject.y -= 2;
                    }
                    for (Essence essence : listOfEssences) {
                        essence.y -= 2;
                    }
                    helpGroundXMinus = 20;
                    if (helpGroundYMinus == 20 || helpGroundYMinus == 24) {
                        helpGroundYMinus = 22;
                    } else if (helpGroundYMinus != 22) {
                        helpGroundYMinus = 20;
                    }
                    break;
                case 'Ы': //Бег назад.
                case 'S':
                    for (GameObject gameObject : listOfObjects) {
                        gameObject.y -= 4;
                    }
                    for (Essence essence : listOfEssences) {
                        essence.y -= 4;
                    }
                    helpGroundXMinus = 20;
                    if (helpGroundYMinus == 20 || helpGroundYMinus == 22) {
                        helpGroundYMinus = 24;
                    } else if (helpGroundYMinus != 24) {
                        helpGroundYMinus = 20;
                    }
                    break;

                case 'd': //Хотьба направо.
                case 'в':
                    for (GameObject gameObject : listOfObjects) {
                        gameObject.x -= 2;
                    }
                    for (Essence essence : listOfEssences) {
                        essence.x -= 2;
                    }
                    helpGroundYMinus = 20;
                    if (helpGroundXMinus == 20 || helpGroundXMinus == 24) {
                        helpGroundXMinus = 22;
                    } else if (helpGroundXMinus != 22) {
                        helpGroundXMinus = 20;
                    }
                    break;
                case 'В': //Бег направо.
                case 'D':
                    for (GameObject gameObject : listOfObjects) {
                        gameObject.x -= 4;
                    }
                    for (Essence essence : listOfEssences) {
                        essence.x -= 4;
                    }
                    helpGroundYMinus = 20;
                    if (helpGroundXMinus == 20 || helpGroundXMinus == 22) {
                        helpGroundXMinus = 24;
                    } else if (helpGroundXMinus != 24) {
                        helpGroundXMinus = 20;
                    }
                    break;


                case 'ё': //Выход в меню.
                case 'Ё':
                case '`':
                case '~':
                    gameFrame.removeKeyListener(new ClickGameFrame());
                    gameFrame.setVisible(false);
                    phase = 0;
                    startFrame.setVisible(true);
                    break;

                case 'q': //Открытие инвентаря.
                case 'Q':
                case 'й':
                case 'Й':
                    int woods = 0;
                    int stones = 0;
                    int smallStones = 0;
                    int golds = 0;
                    int waters = 0;
                    for (Card card : slots) {
                        switch (card.name) {
                            case "Древесина":
                                woods++;
                                break;
                            case "Камень":
                                stones++;
                                break;
                            case "Маленький камень":
                                smallStones++;
                                break;
                            case "Золото":
                                golds++;
                                break;
                            case "Вода":
                                waters++;
                                break;
                        }
                    }
                    System.out.println("\nВаши слоты:");
                    System.out.println("Древесина: " + woods);
                    System.out.println("Камни: " + stones);
                    System.out.println("Маленькие камни: " + smallStones);
                    System.out.println("Золото: " + golds);
                    System.out.println("Вода: " + waters + "\n");
                    phase = 2;
                    for (Card card : slots) {
                        if (card.name.equals("Брюки бродяги") && card.isWear) {
                            buttonPantsSlots.setText(card.name);
                            buttonPantsClothes.setText(card.name);
                        }
                    }
                    for (Card card : slots) {
                        if (card.name.equals("Рубаха бродяги") && card.isWear) {
                            buttonShirtSlots.setText(card.name);
                            buttonShirtClothes.setText(card.name);
                        }
                    }
                    gameFrame.remove(labelAccount);
                    gameFrame.setLayout(null);
                    gameFrame.add(labelSlots);
                    labelSlots.setBounds(305, 50, 400, 50);
                    gameFrame.add(buttonRight);
                    buttonRight.setBounds(gameFrame.getWidth()-100, gameFrame.getHeight()/2 - 40, 90, 80);
                    gameFrame.add(buttonLeft);
                    buttonLeft.setBounds(10, gameFrame.getHeight()/2 - 40, 90, 80);
                    gameFrame.add(buttonPantsSlots);
                    buttonPantsSlots.setBounds(200, 500, 400, 50);
                    gameFrame.add(buttonShirtSlots);
                    buttonShirtSlots.setBounds(200, 300, 400, 50);
                    gameFrame.add(buttonHandsSlots);
                    buttonHandsSlots.setBounds(200, 400, 400, 50);
                    gameFrame.setLayout(new BorderLayout());
                    break;
            }
            searchForNearbyGameObjects(); //Поиск, выделение и сохранение близких к игроку объектов.
        }
    }
    public void run() {
        while (true) {
            gameFrame.repaint();
            System.out.println("repaint");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
