package Client.Mechanic; //Пакет класса.

//Импорт классов из пакетов Mechanic и Objects.
import Client.Objects.Account;
import Client.Objects.Cards.Card;
import Client.Objects.Cards.Clothes.CardPovertyPants;
import Client.Objects.Cards.Clothes.CardPovertyShirt;
import Client.Objects.Cards.Materials.*;
import Client.Objects.Essences.Essence;
import Client.Objects.Essences.EssenceWolf;
import Client.Objects.GameObjects.*;
import Client.Objects.Ground.Ground;
import Client.Objects.Ground.GroundGrass;
import Client.Objects.Ground.GroundWater;
import Client.Objects.Quest;
import Client.Objects.World;

import static Client.Mechanic.MainVariables.*;

//Импорт библиотек API.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

//Это - GameMechanic - класс для отслеживания пользовательских нажатий по мышке, клавиатуре, фрейму и т. д., также в этом классе хранятся потоки, которые используются в игровой механике.
class GameMechanic { //Этот класс наследует все открытые переменные класса MainVariables, а также всё то, что MainVariables унаследовал от своих классов-родителей.
    GameMechanic() { //Конструктор класса.
        //Вывод системных уседомлений.
        System.out.println("Creating object of class GameMechanic...");
        System.out.println("Finished creating object of class GameMechanic.");
    }
    //Метод preparationGUIAndWorld(), вызывающийся методом main(String[] args). Он подготавливает GUI и обработчики событий, мир и объекты в нём.
    void preparationGUIAndWorld() {
        System.out.println((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth());
        System.out.println((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        //Обработка mainFrame
        mainFrame.setSize(widthOfScreen, heightOfScreen);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(isResizable);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);

        setComponentOnFrame(mainFrame, buttonNewAccount, f50, mainFrame.getWidth()/8*3-270/2, mainFrame.getHeight()/3-80/2+90, 710, 80);
        buttonNewAccount.setBackground(colorBackgroundGreen);
        setComponentOnFrame(mainFrame, buttonLoadAccount, f50, mainFrame.getWidth()/8*3-270/2, mainFrame.getHeight()/2-80/2+60, 710, 80);
        buttonLoadAccount.setBackground(colorBackgroundGreen);
        setComponentOnFrame(mainFrame, buttonExit, f50, mainFrame.getWidth()/8*5-300/2, mainFrame.getHeight()/3*2-80/2+40, 300, 80);
        buttonExit.setBackground(colorBackgroundGreen);
        setComponentOnFrame(mainFrame, buttonSettings, f50, mainFrame.getWidth()/8*3-270/2, mainFrame.getHeight()/3*2-80/2+40, 350, 80);
        buttonSettings.setBackground(colorBackgroundGreen);

        setComponentOnFrame(mainFrame, buttonNewWorld, f50, mainFrame.getWidth()/2-410, 360, 380, 80);
        buttonNewWorld.setBackground(colorBackgroundGreen);
        setComponentOnFrame(mainFrame, buttonLoadWorld, f50, mainFrame.getWidth()/2+50, 360, 400, 80);
        buttonLoadWorld.setBackground(colorBackgroundGreen);
        setComponentOnFrame(mainFrame, buttonSaveAccount, f50, mainFrame.getWidth()/2-410, 490, 860, 80);
        buttonSaveAccount.setBackground(colorBackgroundGreen);

        setComponentOnFrame(mainFrame, textNameForNewWorld, f50, mainFrame.getWidth()/2-100/2, 235, 400, 70);
        setComponentOnFrame(mainFrame, labelSaveAccount, f20, mainFrame.getWidth()/2+930/2, 480, 800, 70);

        setComponentOnFrame(mainFrame, labelAccount, f32, 80, mainFrame.getHeight()-117, 400, 60);


        setComponentOnFrame(mainFrame, labelNick, f15, xOfPlayerOnFrame - 40, yOfPlayerOnFrame - 60, 1000, 20);

        setComponentOnFrame(mainFrame, labelSlots, f50, mainFrame.getWidth() /2 - 200, 50, 400, 50);

        setComponentOnFrame(mainFrame, buttonShirtSlots, f25, mainFrame.getWidth() /2 - 200, 300, 400, 50);
        setComponentOnFrame(mainFrame, buttonHandsSlots, f25, mainFrame.getWidth() /2 - 200, 400, 400, 50);
        setComponentOnFrame(mainFrame, buttonPantsSlots, f25, mainFrame.getWidth() /2 - 200, 500, 400, 50);

        setComponentOnFrame(mainFrame, buttonRight, f50, mainFrame.getWidth() -100, mainFrame.getHeight() /2 - 40, 90, 80);
        setComponentOnFrame(mainFrame, buttonLeft, f50, 10, mainFrame.getHeight() /2 - 40, 90, 80);

        setComponentOnFrame(mainFrame, textOfQuests, f20, mainFrame.getWidth() - 240, 30, 200, 200);
        textOfQuests.setForeground(colorForegroundLightBlue);

        JLabel labelNotification = new JLabel();
        JLabel labelNotification1 = new JLabel();
        JLabel labelNotification2 = new JLabel();
        JLabel labelNotification3 = new JLabel();
        JLabel labelNotification4 = new JLabel();
        listOfLabelsNotification.add(labelNotification);
        listOfLabelsNotification.add(labelNotification1);
        listOfLabelsNotification.add(labelNotification2);
        listOfLabelsNotification.add(labelNotification3);
        listOfLabelsNotification.add(labelNotification4);
        listOfLabelsNotificationBool.add(false);
        listOfLabelsNotificationBool.add(false);
        listOfLabelsNotificationBool.add(false);
        listOfLabelsNotificationBool.add(false);
        listOfLabelsNotificationBool.add(false);
        setComponentOnFrame(mainFrame, labelNotification, f20, mainFrame.getWidth()/5*3-40, mainFrame.getHeight()-100, 600, 50);
        setComponentOnFrame(mainFrame, labelNotification1, f20, mainFrame.getWidth()/5*3-40, mainFrame.getHeight()-100, 600, 50);
        setComponentOnFrame(mainFrame, labelNotification2, f20, mainFrame.getWidth()/5*3-40, mainFrame.getHeight()-100, 600, 50);
        setComponentOnFrame(mainFrame, labelNotification3, f20, mainFrame.getWidth()/5*3-40, mainFrame.getHeight()-100, 600, 50);
        setComponentOnFrame(mainFrame, labelNotification4, f20, mainFrame.getWidth()/5*3-40, mainFrame.getHeight()-100, 600, 50);

        setComponentOnFrame(mainFrame, labelWarning, f20, 110, 650, 400, 30);
        setComponentOnFrame(mainFrame, labelRegisterNick    , f25, 165, 340, 300, 30);
        setComponentOnFrame(mainFrame, textNick             , f30, 80, 385, 250, 40);
        setComponentOnFrame(mainFrame, labelRegisterPassword, f25, 155, 440, 200, 30);
        setComponentOnFrame(mainFrame, textPassword         , f30, 80, 485, 250, 40);

        setComponentOnFrame(mainFrame, buttonEndRegistration, f20, 75, 600, 270, 45);

        setComponentOnFrame(mainFrame, buttonRegistrationBack, f20, 250, 290, 125, 30);
        setComponentOnFrame(mainFrame, buttonNewAccountFromLoadAccount, f20, 90, 545, 240, 35);
        setComponentOnFrame(mainFrame, buttonLoadAccountFromNewAccount, f20, 90, 545, 240, 35);

        textOfQuests.setEditable(false);
        textOfQuests.setBackground(colorGameHandBackground2);

        DrawPanel drawPanel = new DrawPanel();
        mainFrame.add(drawPanel);
        drawPanel.setBounds(0, 0, 2000, 2000);

        textOfQuests.addKeyListener(new MainFrameKeyListener()); //Обработчик событий, выслеживающий нажатия по клавиатуре при открытии окна mainFrame.
        textOfQuests.addMouseListener(new MainFrameMouseListener());
        textOfQuests.addMouseMotionListener(new MainFrameMouseMotionListener());

        buttonHandsSlots.addActionListener(new InventorySlotsHands()); //Обработчик событий, выслеживающий нажатия по кнопке Ручной инвентарь (в окне mainFrame) - buttonHandsSlots.
        buttonPantsSlots.addActionListener(new InventorySlotsPants()); //Обработчик событий, выслеживающий нажатия по кнопке Карманы штанов (в окне mainFrame) - buttonPantsSlots.
        buttonShirtSlots.addActionListener(new InventorySlotsShirt()); //Обработчик событий, выслеживающий нажатия по кнопке Карманы куртки (в окне mainFrame) - buttonShirtSlots.
        buttonRight.addActionListener(new InventoryRight()); //Обработчик событий, выслеживающий нажатия по кнопке > (вправо) (в окне mainFrame) - buttonRight.
        buttonLeft.addActionListener(new InventoryLeft()); //Обработчик событий, выслеживающий нажатия по кнопке < (влево) (в окне mainFrame) - buttonLeft.

        buttonNewAccount.addActionListener(new NewAccount()); //Обработчик событий, выслеживающий нажатия по кнопке Регистрация (в окне startFrame) - buttonNewAccount.
        buttonLoadAccount.addActionListener(new LoadAccount());
        buttonSaveAccount.addActionListener(new SaveAccount());
        buttonNewWorld.addActionListener(new NewWorld()); //Обработчик событий, выслеживающий нажатия по кнопке Войти в игру (в окне startFrame) - buttonNewWorld.
        buttonLoadWorld.addActionListener(new LoadWorld());
        buttonExit.addActionListener(new Exit()); //Обработчик событий, выслеживающий нажатия по кнопке Выйти (в окне startFrame) - buttonExit.
        buttonSettings.addActionListener(new Settings()); //Обработчик событий, выслеживающий нажатия по кнопке Настройки (в окне startFrame) - buttonSettings.

        buttonEndRegistration.addActionListener(new EndOfRegistrationAccount()); //Обработчик событий, выслеживающий нажатия по кнопке Регистрация (в окне registrationFrame) - buttonEndRegistration.
        buttonRegistrationBack.addActionListener(new RegisterBack()); //Обработчик событий, выслеживающий нажатия по кнопке Назад (в окне registrationFrame) - buttonEndRegistration.
        buttonNewAccountFromLoadAccount.addActionListener(new NewAccount());
        buttonLoadAccountFromNewAccount.addActionListener(new LoadAccount());

        System.out.println("JFrame mainFrame has done.");

        System.out.println("All ActionListeners have added.");

        System.out.println("preparationGUIAndWorld() has completed."); //Вывод системного уседомления.

        menuStartAccount();
    }

    private void menuStartAccount() {
        visFalseAll();

        visTrue(buttonNewAccount);
        visTrue(buttonLoadAccount);
        visTrue(buttonExit);
        visTrue(buttonSettings);
        visTrue(labelAccount);
        if (accountNow != null) {
            labelAccount.setText("Ваш аккаунт: " + accountNow.nick);
        }

        visTrue(mainFrame); //Отображение окна startFrame.

        Runnable runnable = () -> {
            while (true) {
                for (int x = 0; x < 2; x++) {
                    buttonNewAccount.setBounds(buttonNewAccount.getX(), buttonNewAccount.getY() - 1, buttonNewAccount.getWidth(), buttonNewAccount.getHeight());
                    buttonNewWorld.setBounds(buttonNewWorld.getX(), buttonNewWorld.getY() - 1, buttonNewWorld.getWidth(), buttonNewWorld.getHeight());
                    buttonLoadWorld.setBounds(buttonLoadWorld.getX(), buttonLoadWorld.getY() - 1, buttonLoadWorld.getWidth(), buttonLoadWorld.getHeight());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int x = 0; x < 4; x++) {
                    buttonNewAccount.setBounds(buttonNewAccount.getX(), buttonNewAccount.getY() - 2, buttonNewAccount.getWidth(), buttonNewAccount.getHeight());
                    buttonNewWorld.setBounds(buttonNewWorld.getX(), buttonNewWorld.getY() - 2, buttonNewWorld.getWidth(), buttonNewWorld.getHeight());
                    buttonLoadWorld.setBounds(buttonLoadWorld.getX(), buttonLoadWorld.getY() - 2, buttonLoadWorld.getWidth(), buttonLoadWorld.getHeight());
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int x = 0; x < 2; x++) {
                    buttonNewAccount.setBounds(buttonNewAccount.getX(), buttonNewAccount.getY() - 1, buttonNewAccount.getWidth(), buttonNewAccount.getHeight());
                    buttonNewWorld.setBounds(buttonNewWorld.getX(), buttonNewWorld.getY() - 1, buttonNewWorld.getWidth(), buttonNewWorld.getHeight());
                    buttonLoadWorld.setBounds(buttonLoadWorld.getX(), buttonLoadWorld.getY() - 1, buttonLoadWorld.getWidth(), buttonLoadWorld.getHeight());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int x = 0; x < 2; x++) {
                    buttonNewAccount.setBounds(buttonNewAccount.getX(), buttonNewAccount.getY() + 1, buttonNewAccount.getWidth(), buttonNewAccount.getHeight());
                    buttonNewWorld.setBounds(buttonNewWorld.getX(), buttonNewWorld.getY() + 1, buttonNewWorld.getWidth(), buttonNewWorld.getHeight());
                    buttonLoadWorld.setBounds(buttonLoadWorld.getX(), buttonLoadWorld.getY() + 1, buttonLoadWorld.getWidth(), buttonLoadWorld.getHeight());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int x = 0; x < 4; x++) {
                    buttonNewAccount.setBounds(buttonNewAccount.getX(), buttonNewAccount.getY() + 2, buttonNewAccount.getWidth(), buttonNewAccount.getHeight());
                    buttonNewWorld.setBounds(buttonNewWorld.getX(), buttonNewWorld.getY() + 2, buttonNewWorld.getWidth(), buttonNewWorld.getHeight());
                    buttonLoadWorld.setBounds(buttonLoadWorld.getX(), buttonLoadWorld.getY() + 2, buttonLoadWorld.getWidth(), buttonLoadWorld.getHeight());
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int x = 0; x < 2; x++) {
                    buttonNewAccount.setBounds(buttonNewAccount.getX(), buttonNewAccount.getY() + 1, buttonNewAccount.getWidth(), buttonNewAccount.getHeight());
                    buttonNewWorld.setBounds(buttonNewWorld.getX(), buttonNewWorld.getY() + 1, buttonNewWorld.getWidth(), buttonNewWorld.getHeight());
                    buttonLoadWorld.setBounds(buttonLoadWorld.getX(), buttonLoadWorld.getY() + 1, buttonLoadWorld.getWidth(), buttonLoadWorld.getHeight());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Runnable runnable1 = () -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                for (int x = 0; x < 2; x++) {
                    buttonLoadAccount.setBounds(buttonLoadAccount.getX(), buttonLoadAccount.getY() - 1, buttonLoadAccount.getWidth(), buttonLoadAccount.getHeight());
                    buttonSaveAccount.setBounds(buttonSaveAccount.getX(), buttonSaveAccount.getY() - 1, buttonSaveAccount.getWidth(), buttonSaveAccount.getHeight());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int x = 0; x < 4; x++) {
                    buttonLoadAccount.setBounds(buttonLoadAccount.getX(), buttonLoadAccount.getY() - 2, buttonLoadAccount.getWidth(), buttonLoadAccount.getHeight());
                    buttonSaveAccount.setBounds(buttonSaveAccount.getX(), buttonSaveAccount.getY() - 2, buttonSaveAccount.getWidth(), buttonSaveAccount.getHeight());
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int x = 0; x < 2; x++) {
                    buttonLoadAccount.setBounds(buttonLoadAccount.getX(), buttonLoadAccount.getY() - 1, buttonLoadAccount.getWidth(), buttonLoadAccount.getHeight());
                    buttonSaveAccount.setBounds(buttonSaveAccount.getX(), buttonSaveAccount.getY() - 1, buttonSaveAccount.getWidth(), buttonSaveAccount.getHeight());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int x = 0; x < 2; x++) {
                    buttonLoadAccount.setBounds(buttonLoadAccount.getX(), buttonLoadAccount.getY() + 1, buttonLoadAccount.getWidth(), buttonLoadAccount.getHeight());
                    buttonSaveAccount.setBounds(buttonSaveAccount.getX(), buttonSaveAccount.getY() + 1, buttonSaveAccount.getWidth(), buttonSaveAccount.getHeight());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int x = 0; x < 4; x++) {
                    buttonLoadAccount.setBounds(buttonLoadAccount.getX(), buttonLoadAccount.getY() + 2, buttonLoadAccount.getWidth(), buttonLoadAccount.getHeight());
                    buttonSaveAccount.setBounds(buttonSaveAccount.getX(), buttonSaveAccount.getY() + 2, buttonSaveAccount.getWidth(), buttonSaveAccount.getHeight());
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int x = 0; x < 2; x++) {
                    buttonLoadAccount.setBounds(buttonLoadAccount.getX(), buttonLoadAccount.getY() + 1, buttonLoadAccount.getWidth(), buttonLoadAccount.getHeight());
                    buttonSaveAccount.setBounds(buttonSaveAccount.getX(), buttonSaveAccount.getY() + 1, buttonSaveAccount.getWidth(), buttonSaveAccount.getHeight());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread1 = new Thread(runnable1);
        thread1.start();
        Runnable runnable2 = () -> {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                for (int x = 0; x < 2; x++) {
                    buttonExit.setBounds(buttonExit.getX(), buttonExit.getY() - 1, buttonExit.getWidth(), buttonExit.getHeight());
                    buttonSettings.setBounds(buttonSettings.getX(), buttonSettings.getY() - 1, buttonSettings.getWidth(), buttonSettings.getHeight());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int x = 0; x < 4; x++) {
                    buttonExit.setBounds(buttonExit.getX(), buttonExit.getY() - 2, buttonExit.getWidth(), buttonExit.getHeight());
                    buttonSettings.setBounds(buttonSettings.getX(), buttonSettings.getY() - 2, buttonSettings.getWidth(), buttonSettings.getHeight());
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int x = 0; x < 2; x++) {
                    buttonExit.setBounds(buttonExit.getX(), buttonExit.getY() - 1, buttonExit.getWidth(), buttonExit.getHeight());
                    buttonSettings.setBounds(buttonSettings.getX(), buttonSettings.getY() - 1, buttonSettings.getWidth(), buttonSettings.getHeight());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int x = 0; x < 2; x++) {
                    buttonExit.setBounds(buttonExit.getX(), buttonExit.getY() + 1, buttonExit.getWidth(), buttonExit.getHeight());
                    buttonSettings.setBounds(buttonSettings.getX(), buttonSettings.getY() + 1, buttonSettings.getWidth(), buttonSettings.getHeight());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int x = 0; x < 4; x++) {
                    buttonExit.setBounds(buttonExit.getX(), buttonExit.getY() + 2, buttonExit.getWidth(), buttonExit.getHeight());
                    buttonSettings.setBounds(buttonSettings.getX(), buttonSettings.getY() + 2, buttonSettings.getWidth(), buttonSettings.getHeight());
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int x = 0; x < 2; x++) {
                    buttonExit.setBounds(buttonExit.getX(), buttonExit.getY() + 1, buttonExit.getWidth(), buttonExit.getHeight());
                    buttonSettings.setBounds(buttonSettings.getX(), buttonSettings.getY() + 1, buttonSettings.getWidth(), buttonSettings.getHeight());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread2 = new Thread(runnable2);
        thread2.start();
    }
    private void menuStartAccountRegistrationEntry() {
        visTrue(labelRegisterNick);
        visTrue(textNick);
        visTrue(labelRegisterPassword);
        visTrue(textPassword);
        visTrue(buttonEndRegistration);
        visTrue(buttonRegistrationBack);

        labelNick.requestFocus();
    }
    private void menuStartWorld() {
        visFalseAll();

        labelAccount.setText(accountNow.nick); //Появление надписи с введённым ником на startFrame.
        visTrue(labelAccount);

        visTrue(buttonExit);
        visTrue(buttonSettings);
        visTrue(buttonNewWorld);
        visTrue(buttonLoadWorld);
        visTrue(buttonSaveAccount);

        visTrue(mainFrame);
    }
    private void menuGameMain() {
        visFalseAll();

        labelNick.setText(accountNow.nick);
        visTrue(labelNick);
        visTrue(textOfQuests);
        visFalse(mainFrame);
        visTrue(mainFrame);
    }

    //Метод preparationRunnable(), вызывающийся во время начала игры для подготовки и запуску потоков repaintRunnable и wolfRunnable.
    private void preparationRunnable() {
        if (!isRunnablePrepared) { //Эта строчка и переменная isRunnablePrepared нужны для того, чтобы метод запускался только один раз, а не преумножался при каждом старте игры.
            runnableRepaint = () -> {
                while (isRepaint && !threadRepaint.isInterrupted()) {
                    mainFrame.repaint(); //Выполнение перерисовки окна mainFrame.
//                    buttonNewAccount.setBounds(mainFrame.getWidth() / 2 - 480 / 2, mainFrame.getHeight() / 3 - 80 / 2, 480, 80);
                }
            };
            threadRepaint = new Thread(runnableRepaint);
            threadRepaint.start();

            Runnable runnable = () -> {
                while (true) {
                    if (gameIsStartedOrNot && timeForRunnable % 3 == 0) {
                        for (Essence essence : worldNow.listOfEssences) { //То, что находится в этом цикле for, произойдёт со всеми объектами из списка listOfEssences.
                            if (essence.name.equals("Wolf")) { //Отсортировываем всех существ и берём только волков.
                                if (ifNotOverBarrier(essence.xOnFrame, essence.yOnFrame)) { //Если волк не наступил на барьер.
                                    boolean isX = false; //Создаём булеву переменную для проверки близости игрока к волку по оси x.
                                    boolean isY = false; //Создаём булеву переменную для проверки близости игрока к волку по оси y.
                                    if (essence.xOnFrame - xOfPlayerOnFrame < 300 && essence.xOnFrame - xOfPlayerOnFrame > -300) { //Если игрок относительно волка находится не дальше 300 пикселей по оси x.
                                        isX = true; //То даем переменной isX значение true, чтобы показать, что игрок близок к волку по оси x.
                                    } //Конец if.
                                    if (essence.yOnFrame - yOfPlayerOnFrame < 300 && essence.yOnFrame - yOfPlayerOnFrame > -300) { //Если игрок относительно волка находится не дальше 300 пикселей по оси y.
                                        isY = true; //То даем переменной isY значение true, чтобы показать, что игрок близок к волку по оси y.
                                    } //Конец if.
                                    if (isX && isY) { //Если игрок близок к волку и по оси x, и по оси y.
                                        if ((yOfPlayerOnFrame - essence.yOnFrame < 5 && yOfPlayerOnFrame - essence.yOnFrame > -5)
                                                && (xOfPlayerOnFrame - essence.xOnFrame < 5 && xOfPlayerOnFrame - essence.xOnFrame > -5)) { //Если волк очень близко к игроку.
                                            xOfPlayerOnFrame -= 10;
                                            try { //try-catch для паузы.
                                                Thread.sleep(2); //Пауза в размере 2 милисекунд.
                                            } catch (InterruptedException e) {
                                                e.printStackTrace(); //Обработка ошибки.
                                            }
                                            xOfPlayerOnFrame += 20;
                                            try { //try-catch для паузы.
                                                Thread.sleep(2); //Пауза в размере 2 милисекунд.
                                            } catch (InterruptedException e) {
                                                e.printStackTrace(); //Обработка ошибки.
                                            }
                                            xOfPlayerOnFrame -= 10;
                                            if (timerStatement == 0) { //Если переменная-таймер timerStatement равна 0.
                                                worldNow.health--; //У игрока отнимается одна жизнь.
                                                timerStatementHP = 20;
                                                mainFrame.repaint();
                                            } //Конец if.
                                            if (worldNow.health == 0) { //Если у игрока 0 жизней.
                                                respawn(); //Он погибает и респавнится.
                                            } else { //Если у игрока не 0 жизней.
                                                if (timerStatement == 0) { //И если переменная-таймер timerStatement равна 0.
                                                    timerStatement = timeForTakingAHealth; //Ей придаётся значение переменной timeForTakingAHealth.
                                                } else { //Если переменная-таймер timerStatement не равна 0.
                                                    timerStatement--; //Она уменьшается на единицу.
                                                } //Конец else.
                                            } //Конец else.
                                        } else { //Если же волк не достаточно близок к игроку, чтобы укусить его.
                                            if (xOfPlayerOnFrame - essence.xOnFrame < -3) { //Если игрок находится левее волка.
                                                essence.xOnFrame -= 2 * essence.essenceSpeed; //То волк двигается влево, по направлению к игроку.
                                                essence.icon = iconWolfLeft;
                                            } else if (xOfPlayerOnFrame - essence.xOnFrame > 3) { //Если игрок находится правее волка.
                                                essence.xOnFrame += 2 * essence.essenceSpeed; //То волк двигается вправо, по направлению к игроку.
                                                essence.icon = iconWolfRight;
                                            }
                                            if (yOfPlayerOnFrame - essence.yOnFrame < -3) { //Если игрок находится выше волка.
                                                essence.yOnFrame -= 2 * essence.essenceSpeed; //То волк двигается вверх, по направлению к игроку.
                                            } else if (yOfPlayerOnFrame - essence.yOnFrame > 3) { //Если игрок находится ниже волка.
                                                essence.yOnFrame += 2 * essence.essenceSpeed; //То волк двигается вниз, по направлению к игроку.
                                            }
                                        }
                                    } else if (essence.timePassed == 0) { //Если же игрок не достаточно близок к волку, чтобы волк его заметил и при этом настало время для следующего шага.
                                        int rand = (int) (Math.random() * 4); //То вычисляем случайное значение для переменной rand в пределах от 0 до 3 включительно.
                                        switch (rand) { //Исли переменной rand дали значение...
                                            case 0: //...0
                                                essence.xOnFrame -= 2 * essence.essenceSpeed; //Передвижение волка влево на определённое количество пикселей, в зависимости от скорости волка.
                                                essence.icon = iconWolfLeft;
                                                break; //Конец кейса.
                                            case 1: //...1
                                                essence.xOnFrame += 2 * essence.essenceSpeed; //Передвижение волка вправо на определённое количество пикселей, в зависимости от скорости волка.
                                                essence.icon = iconWolfRight;
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
                                    worldNow.listOfEssences.remove(essence); //Удаление волка из списка существ.
                                    System.out.println("Уведомление. Волк не знал, что в игре есть барьеры и умер от одного из них."); //Вывод пользовательского уведомления.
                                    break; //Выход
                                }
                            } //Конец if
                        } //Конец цикла for.
                    }
                    if (is1Pressed && timeForRunnable % 3 == 0) {
                        resourceMining("SmallStone");
                    }
                    if (is2Pressed && timeForRunnable % 3 == 0) {
                        resourceMining("Wood");
                        resourceMining("Stone");
                    }
                    if (is3Pressed && timeForRunnable % 3 == 0) {
                        resourceMining("Gold");
                        resourceMining("Diamond");
                    }
                    if (is4Pressed && timeForRunnable % 3 == 0) {
                        resourceMining("Water");
                    }

                    if (iswPressed && !issPressed && !isSPressed) {
                        playerMove('y', +1);
                    } else if (isWPressed && !isSPressed && !issPressed) {
                        playerMove('y', +2);
                    }
                    if (issPressed && !iswPressed && !isWPressed) {
                        playerMove('y', -1);
                    } else if (isSPressed && !isWPressed && !iswPressed) {
                        playerMove('y', -2);
                    }
                    if (isdPressed && !isaPressed && !isAPressed) {
                        playerMove('x', -1);
                    } else if (isDPressed && !isAPressed && !isaPressed) {
                        playerMove('x', -2);
                    }
                    if (isaPressed && !isdPressed && !isDPressed) {
                        playerMove('x', +1);
                    } else if (isAPressed && !isDPressed && !isdPressed) {
                        playerMove('x', +2);
                    }

                    if (timeForRunnable % 5 == 0 && gameIsStartedOrNot) {
                        searchForNearbyGameObjects(); //Поиск, выделение и сохранение близких к игроку объектов.
                    }
                    try { //try-catch для избегания остановки кода при ошибке.
                        Thread.sleep(10); //Пауза в размере 10 милисекунд для избегания постоянной перерисовки и большой нагрузки на компьютер.
                    } catch (InterruptedException e) {
                        e.printStackTrace(); //Обработка ошибки.
                    }
                    if (timeForRunnable == 15) {
                        timeForRunnable = 0;
                    }
                    timeForRunnable++;
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();

            Runnable runnableHP = () -> {
                while (true) {
                    if (timerStatementHP > 0) {
                        if (timerStatementHP == 1 && worldNow.health != worldNow.maxHealth) {
                            worldNow.health++;
                            if (worldNow.health != worldNow.maxHealth) {
                                timerStatementHP = 10;
                            } else {
                                timerStatementHP = 0;
                            }
                        } else {
                            timerStatementHP--;

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
                }
            };
            Thread threadHP = new Thread(runnableHP);
            threadHP.start();

            System.out.println("runnable has started"); //Вывод системного уседомления.

            isRunnablePrepared = true; //Изменеие значения переменной isRunnablePrepared на true для запрещения очередного вызова этого метода.
            System.out.println("preparationRunnable() has completed."); //Вывод системного уведомления.
        } //Конец if.
    } //Конец метода preparationRunnable().


    //Обработка событий нажатий кнопок.
    public class NewWorld implements ActionListener { //Обработка нажатия кнопки buttonNewWorld.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            worldNow = new World();
            accountNow.listOfWorlds.add(worldNow);

            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier();
                barrier.xOnFrame = x*10+1;
                barrier.yOnFrame = 5001;
                worldNow.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier();
                barrier.xOnFrame = -(x*10)+1;
                barrier.yOnFrame = 5001;
                worldNow.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier();
                barrier.xOnFrame = x*10+1;
                barrier.yOnFrame = -4999;
                worldNow.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier();
                barrier.xOnFrame = -(x*10)+1;
                barrier.yOnFrame = -4999;
                worldNow.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier();
                barrier.xOnFrame = 5001;
                barrier.yOnFrame = x*10+1;
                worldNow.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier();
                barrier.xOnFrame = -4999;
                barrier.yOnFrame = x*10+1;
                worldNow.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier();
                barrier.xOnFrame = 5001;
                barrier.yOnFrame = -(x*10)+1;
                worldNow.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier();
                barrier.xOnFrame = -4999;
                barrier.yOnFrame = -(x*10)+1;
                worldNow.listOfObjects.add(barrier);
            }
            System.out.println("All ObjectBarriers have created.");

            for (int x = worldNow.startAmountOfWoods; x > 0; x--) {
                GameObject wood = new ObjectWood();
                wood.setLocations(wood);
                worldNow.listOfObjects.add(wood);
            }
            System.out.println("All ObjectWoods have created.");

            for (int x = worldNow.startAmountOfStones; x > 0; x--) {
                GameObject stone = new ObjectStone();
                stone.setLocations(stone);
                worldNow.listOfObjects.add(stone);
            }
            System.out.println("All ObjectStones have created.");
            for (int x = worldNow.startAmountOfSmallStones; x > 0; x--) {
                GameObject smallStone = new ObjectSmallStone();
                smallStone.setLocations(smallStone);
                worldNow.listOfObjects.add(smallStone);
            }
            System.out.println("All ObjectsSmallStones have created.");
            for (int x = worldNow.startAmountOfGolds; x > 0; x--) {
                GameObject gold = new ObjectGold();
                gold.setLocations(gold);
                worldNow.listOfObjects.add(gold);
            }
            System.out.println("All ObjectGolds have created.");
            for (int x = worldNow.startAmountOfDiamonds; x > 0; x--) {
                GameObject diamond = new ObjectDiamond();
                diamond.setLocations(diamond);
                worldNow.listOfObjects.add(diamond);
            }
            System.out.println("All ObjectDiamonds have created.");
            for (int x = worldNow.startAmountOfWolfs; x > 0; x--) {
                Essence wolf = new EssenceWolf();
                worldNow.listOfEssences.add(wolf);
            }
            System.out.println("All EssenceWolfs have created.");
            for (int x = -5000; x < 5000; x+=50) {
                for (int y = -5000; y < 5000; y+=50) {
                    GroundGrass groundGrass = new GroundGrass(x, y);
                    worldNow.listOfGrounds.add(groundGrass);
                }
            }
            System.out.println("All GroundGrasses have created.");
            for (int x = worldNow.startAmountOfWaters; x > 0; x--) {
                int xOfGround = ((int) (Math.random() * 200)-100)*50;
                int yOfGround = ((int) (Math.random() * 200)-100)*50;
                GroundWater groundWater = new GroundWater(xOfGround, yOfGround);
                worldNow.listOfGrounds.add(groundWater);
            }
            System.out.println("All GroundWaters have created.");
            Quest quest1 = new Quest(1, "Собрать 10 карт:\n Дерево", 10, "Wood");
            quest1.runnableOn();
            Quest quest2 = new Quest(2, "Собрать 10 карт:\n Камень", 10, "Stone");
            quest2.runnableOn();
            Quest quest3 = new Quest(3, "Собрать 5 карт:\n Мальнький камень", 5, "SmallStone");
            quest3.runnableOn();
            Quest quest4 = new Quest(4, "Собрать 10 карт:\n Золото", 10, "Gold");
            quest4.runnableOn();
            Quest quest5 = new Quest(5, "Собрать 10 карт:\n Алмаз", 10, "Diamond");
            quest5.runnableOn();
            worldNow.listOfQuests.add(quest1);
            worldNow.listOfQuests.add(quest2);
            worldNow.listOfQuests.add(quest3);
            worldNow.listOfQuests.add(quest4);
            worldNow.listOfQuests.add(quest5);
            System.out.println("NEW WORLD HAS CREATED.");

            menuGameMain();

            preparationRunnable();

            phaseOfRepaint = 2; //Переключение фазы перерисовки на вторую.
//            preparationRunnable(); //Вызов метода preparationRunnable() для создания и запуска нужных для игры потоков.

            gameIsStartedOrNot = true; //Выдача переменной gameIsStartedOrNot значение true.

            firstRespawn(); //Вызов метода firstRespawn() для выдачи игроку начальных предметов и первого поиска ближайших к нему объектов. Игра начинается.
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса NewWorld.
    private class LoadWorld implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (worldNow != null) {
                for (Quest quest : worldNow.listOfQuests) {
                    quest.runnableOn();
                }

                phaseOfRepaint = 2;

                gameIsStartedOrNot = true;

                menuGameMain();

                preparationRunnable();
                visFalse(mainFrame);
                visTrue(mainFrame);
            }
        }
    }
    private class SaveAccount implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(accountNow.nick + ".ser"));
                objectOutputStream.writeObject(accountNow);
                objectOutputStream.close();
                System.out.println("Аккаунт " + accountNow.nick + " сохранён!");
                System.out.println(accountNow.toString());
                labelSaveAccount.setText("Аккаунт " + accountNow.nick + " успешно сохранён!");
                visTrue(labelSaveAccount);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public class Exit implements ActionListener { //Обработка нажатия кнопки buttonExit.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(0); //Завершение игры.
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса Exit.

    public class Settings implements ActionListener { //Обработка нажатия кнопки buttonSettings.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {

        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса Exit.

    public class NewAccount implements ActionListener { //Обработка нажатия кнопки buttonNewAccount.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            textNick.setText("");
            textPassword.setText("");
            visFalse(labelWarning);
            visFalse(buttonNewAccountFromLoadAccount);
            visTrue(buttonLoadAccountFromNewAccount);
            buttonEndRegistration.setText("Зарегестрироваться");
            buttonEndRegistration.setFont(f20);
            isNewAccount = true;
            menuStartAccountRegistrationEntry();
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса NewAccount.

    private class LoadAccount implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textNick.setText("");
            textPassword.setText("");
            visFalse(labelWarning);
            visFalse(buttonLoadAccountFromNewAccount);
            visTrue(buttonNewAccountFromLoadAccount);
            buttonEndRegistration.setText("Войти");
            buttonEndRegistration.setFont(f30);
            isNewAccount = false;
            menuStartAccountRegistrationEntry();
        }
    }

    private class EndOfRegistrationAccount implements ActionListener { //Обработка нажатия кнопки buttonEndRegistration.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            //Если все поля регистрации чем-то заполнены то это условие срабатывает.
            if (!textNick.getText().equals("") && !textPassword.getText().equals("")) {
                if (isNewAccount) {
                    boolean is = false;
                    try {
                        ObjectInputStream objectOutputStream = new ObjectInputStream(new FileInputStream(textNick.getText() + ".ser"));
                        Account account = (Account) objectOutputStream.readObject();
                    } catch (Exception e) {
                        e.printStackTrace();
                        is = true;
                    }
                    if (is) {
                        accountNow = new Account();
                        accountNow.nick = textNick.getText(); //Сохранение ника.
                        accountNow.password = textPassword.getText(); //Сохранение пароля.
                        menuStartWorld();
                    } else {
                        labelWarning.setFont(f17);
                        labelWarning.setText("Аккаунт с таким логином уже существует!");
                        visFalse(labelWarning);
                        visTrue(labelWarning);
                    }
                } else {
                    try {
                        ObjectInputStream objectOutputStream = new ObjectInputStream(new FileInputStream(textNick.getText() + ".ser"));
                        Account account = (Account) objectOutputStream.readObject();
                        if (account.password.equals(textPassword.getText())) {
                            accountNow = account;
                            accountNow.recovery();
                            if (accountNow.listOfWorlds.size() > 0) {
                                worldNow = accountNow.listOfWorlds.get(0);
                            }
                            menuStartWorld();
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

    private class RegisterBack implements ActionListener { //Обработка нажатия кнопки buttonRegistrationBack.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            menuStartAccount();
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса RegisterBack.


    private class InventoryLeft implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            if (buttonRight.isVisible())
                visFalse(buttonLeft);
            else
                visTrue(buttonRight);

        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventoryLeft.

    private class InventoryRight implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            if (buttonLeft.isVisible())
                visFalse(buttonRight);
            else
                visTrue(buttonLeft);

        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventoryRight.

    private class InventorySlotsPants implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {

        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventorySlotsPants.
    private class InventorySlotsShirt implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {

        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventorySlotsShirt.
    private class InventorySlotsHands implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {

        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventorySlotsHands.

    //Событие нажатий клавиатуры
    public class MainFrameKeyListener extends KeyAdapter implements KeyListener {
        @Override //Переопределение методов keyPressed(KeyEvent button), keyReleased(KeyEvent e) и keyTyped(KeyEvent e).
        public void keyPressed(KeyEvent button) {
            switch (button.getKeyChar()) { //Сравнивание нажатой клавиши с её возможными значениями.
                case '0':
                    if (isHitBoxMode) {
                        isHitBoxMode = false;
                    } else {
                        isHitBoxMode = true;
                        Color.RGBtoHSB(colorGamePlayerBackground.getRed(), colorGamePlayerBackground.getGreen(), colorGamePlayerBackground.getBlue(), null);
                    }
                    break;
                case '1':
                    if (!is1Pressed) {
                        is1Pressed = true;
                    }
                    break;
                case '2': //2
                    if (!is2Pressed) {
                        is2Pressed = true;
                    }
                    break;
                case '3': //3
                    if (!is3Pressed) {
                        is3Pressed = true;
                    }
                    break;
                case '4': //4
                    if (!is4Pressed) {
                        is4Pressed = true;
                    }
                    break;
                case 'w': //w
                case 'ц': //ц
                    if (!iswPressed && !isWPressed) {
                        iswPressed = true;
                        if (!isaPressed && !isAPressed && !isdPressed && !isDPressed && !issPressed && !isSPressed) {
                            iconPlayer = iconPlayerBack;
                        }
                    }
                    break;

                case 'W': //W
                case 'Ц': //Ц
                    if (!iswPressed && !isWPressed) {
                        isWPressed = true;
                        if (!isaPressed && !isAPressed && !isdPressed && !isDPressed && !issPressed && !isSPressed) {
                            iconPlayer = iconPlayerBack;
                        }
                    }
                    break;

                case 'a': //a
                case 'ф': //ф
                    if (!isaPressed && !isAPressed) {
                        isaPressed = true;
                        if (!isdPressed && !isDPressed) {
                            iconPlayer = iconPlayerLeft;
                        }
                    }
                    break;
                case 'A': //A
                case 'Ф': //Ф
                    if (!isaPressed && !isAPressed) {
                        isAPressed = true;
                        if (!isdPressed && !isDPressed) {
                            iconPlayer = iconPlayerLeft;
                        }
                    }
                    break;

                case 's': //s
                case 'ы': //ы
                    if (!issPressed && !isSPressed) {
                        issPressed = true;
                        if (!isaPressed && !isAPressed && !isdPressed && !isDPressed && !iswPressed && !isWPressed) {
                            iconPlayer = iconPlayerFront;
                        }
                    }
                    break;
                case 'S': //S
                case 'Ы': //Ы
                    if (!issPressed && !isSPressed) {
                        isSPressed = true;
                        if (!isaPressed && !isAPressed && !isdPressed && !isDPressed && !iswPressed && !isWPressed) {
                            iconPlayer = iconPlayerFront;
                        }
                    }
                    break;

                case 'd': //d
                case 'в': //в
                    if (!isdPressed && !isDPressed) {
                        isdPressed = true;
                        if (!isaPressed && !isAPressed) {
                            iconPlayer = iconPlayerRight;
                        }
                    }
                    break;
                case 'D': //D
                case 'В': //В
                    if (!isdPressed && !isDPressed) {
                        isDPressed = true;
                        if (!isaPressed && !isAPressed) {
                            iconPlayer = iconPlayerRight;
                        }
                    }
                    break;

                case 0x1B: //Escape
                    is1Pressed = false;
                    is2Pressed = false;
                    is3Pressed = false;
                    is4Pressed = false;
                    iswPressed = false;
                    isWPressed = false;
                    isaPressed = false;
                    isAPressed = false;
                    issPressed = false;
                    isSPressed = false;
                    isdPressed = false;
                    isDPressed = false;
                    gameIsStartedOrNot = false;

                    phaseOfRepaint = 1;
                    menuStartWorld();
                    mainFrame.repaint();
                    visFalse(mainFrame);
                    visTrue(mainFrame);
                    break;

                case 'e': //e
                case 'E': //E
                case 'у': //у
                case 'У': //У
                    is1Pressed = false;
                    is2Pressed = false;
                    is3Pressed = false;
                    is4Pressed = false;
                    iswPressed = false;
                    isWPressed = false;
                    isaPressed = false;
                    isAPressed = false;
                    issPressed = false;
                    isSPressed = false;
                    isdPressed = false;
                    isDPressed = false;

                    if (isRepaint) {
                        System.out.println("\nУведомления. Ваши слоты:");
                        System.out.println("Древесина: " + worldNow.amountOfAllGettingCardWoods);
                        System.out.println("Камни: " + worldNow.amountOfAllGettingCardStones);
                        System.out.println("Маленькие камни: " + worldNow.amountOfAllGettingCardSmallStones);
                        System.out.println("Золото: " + worldNow.amountOfAllGettingCardGolds);
                        System.out.println("Алмаз: " + worldNow.amountOfAllGettingCardDiamonds);
                        System.out.println("Вода: " + worldNow.amountOfAllGettingCardWaters + "\n");

                        threadRepaint.interrupt();
                        isRepaint = false;
                        phaseOfRepaint = 3;

                        for (Card card : worldNow.slots) {
                            if (card.name.equals("PovertyPants") && card.isWear) {
                                buttonPantsSlots.setText(card.name);
                                buttonPantsClothes.setText(card.name);
                            }
                        }
                        for (Card card : worldNow.slots) {
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

                        mainFrame.repaint();
                    } else {
                        visTrue(labelNick);

                        visFalse(labelSlots);
                        visFalse(buttonRight);
                        visFalse(buttonLeft);
                        visFalse(buttonPantsSlots);
                        visFalse(buttonShirtSlots);
                        visFalse(buttonHandsSlots);

                        phaseOfRepaint = 2;
                        mainFrame.repaint();
                        System.out.println("Уведомление. Выход из инвенторя.");
                        isRepaint = true;
                        threadRepaint = new Thread(runnableRepaint);
                        threadRepaint.start();
                    }
                    break;
                case 't': //t
                case 'T': //T
                case 'е': //е
                case 'Е': //е
                    int x = (int) ((Math.random() * 10)+0.5) * 100 - 500; //450, 350, 250, 150, 50, -50, -150, -250, -350, -450
                    int y = (int) ((Math.random() * 10)+0.5) * 100 - 500; //450, 350, 250, 150, 50, -50, -150, -250, -350, -450
                    worldNow.xOfPlayer -= x;
                    worldNow.yOfPlayer -= y;
                    for (Essence essence : worldNow.listOfEssences) {
                        essence.xOnFrame -= x;
                        essence.yOnFrame -= y;
                    }
                    for (GameObject gameObject : worldNow.listOfObjects) {
                        gameObject.xOnFrame -= x;
                        gameObject.yOnFrame -= y;
                    }
                    for (Ground ground : worldNow.listOfGrounds) {
                        ground.x -= x;
                        ground.y -= y;
                    }
                    setNotification("Использован телепорт радиусом 20 полей");
                    searchForNearbyGameObjects(); //Поиск, выделение и сохранение близких к игроку объектов.
                    break;
                case 'k': //k
                case 'K': //K
                case 'л': //л
                case 'Л': //Л
                    respawn();
                    break;
//                case ''
            }
        }
        public void keyReleased(KeyEvent button) {
            switch (button.getKeyChar()) {
                case 'w': //w
                case 'ц': //ц
                    iswPressed = false;
                    if (issPressed || isSPressed) {
                        iconPlayer = iconPlayerFront;
                    } else if (!isaPressed && !isAPressed && !isdPressed && !isDPressed) {
                        iconPlayer = iconPlayerBackStay;
                    }
                    break;
                case 'W': //W
                case 'Ц': //Ц
                    isWPressed = false;
                    if (issPressed || isSPressed) {
                        iconPlayer = iconPlayerFront;
                    } else if (!isaPressed && !isAPressed && !isdPressed && !isDPressed) {
                        iconPlayer = iconPlayerBackStay;
                    }
                    break;
                case 'a': //a
                case 'ф': //ф
                    isaPressed = false;
                    if (issPressed || isSPressed) {
                        iconPlayer = iconPlayerFront;
                    } else if (iswPressed || isWPressed) {
                        iconPlayer = iconPlayerBack;
                    } else if (isdPressed || isDPressed) {
                        iconPlayer = iconPlayerRight;
                    } else {
                        iconPlayer = iconPlayerLeftStay;
                    }
                    break;
                case 'A': //A
                case 'Ф': //Ф
                    isAPressed = false;
                    if (issPressed || isSPressed) {
                        iconPlayer = iconPlayerFront;
                    } else if (iswPressed || isWPressed) {
                        iconPlayer = iconPlayerBack;
                    } else if (isdPressed || isDPressed) {
                        iconPlayer = iconPlayerRight;
                    } else {
                        iconPlayer = iconPlayerLeftStay;
                    }
                    break;
                case 's': //s
                case 'ы': //ы
                    issPressed = false;
                    if (iswPressed || isWPressed) {
                        iconPlayer = iconPlayerBack;
                    } else if (!isaPressed && !isAPressed && !isdPressed && !isDPressed) {
                        iconPlayer = iconPlayerFrontStay;
                    }
                    break;
                case 'S': //S
                case 'Ы': //Ы
                    isSPressed = false;
                    if (iswPressed || isWPressed) {
                        iconPlayer = iconPlayerBack;
                    } else if (!isaPressed && !isAPressed && !isdPressed && !isDPressed) {
                        iconPlayer = iconPlayerFrontStay;
                    }
                    break;
                case 'd': //d
                case 'в': //в
                    isdPressed = false;
                    if (issPressed || isSPressed) {
                        iconPlayer = iconPlayerFront;
                    } else if (iswPressed || isWPressed) {
                        iconPlayer = iconPlayerBack;
                    } else if (isaPressed || isAPressed) {
                        iconPlayer = iconPlayerLeft;
                    } else {
                        iconPlayer = iconPlayerRightStay;
                    }
                    break;
                case 'D': //D
                case 'В': //В
                    isDPressed = false;
                    if (issPressed || isSPressed) {
                        iconPlayer = iconPlayerFront;
                    } else if (iswPressed || isWPressed) {
                        iconPlayer = iconPlayerBack;
                    } else if (isaPressed || isAPressed) {
                        iconPlayer = iconPlayerLeft;
                    } else {
                        iconPlayer = iconPlayerRightStay;
                    }
                    break;
                case 0x31: //1
                    is1Pressed = false;
                    break;
                case 0x32: //2
                    is2Pressed = false;
                    break;
                case 0x33: //3
                    is3Pressed = false;
                    break;
                case 0x34: //4
                    is4Pressed = false;
                    break;
            }
        }

        public void keyTyped(KeyEvent button) {

        }
    }
    private class MainFrameMouseListener implements MouseListener {
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

    private class MainFrameMouseMotionListener implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    private boolean ifNotOverBarrier(int x, int y) {
        boolean ret = true;
        for (GameObject gameObject : worldNow.listOfObjects) {
            if (gameObject.name.equals("Barrier")) {
                if ((gameObject.xOnFrame+4 - x < 6 && gameObject.xOnFrame+4 - x > -6) && (gameObject.yOnFrame+4 - y < 6 && gameObject.yOnFrame+4 - y > -6)) {
                    ret = false;
                }
            }
        }
        return ret;
    }
    private void respawn() {
        System.out.println("Уведомление. Вы умерли");
        worldNow.amountOfDeaths++;
        System.out.println("Уведомление. Ваше количество смертей: " + worldNow.amountOfDeaths);
        worldNow.health = worldNow.maxHealth;
        worldNow.slots.subList(0, worldNow.slots.size()).clear();
        for (Quest quest : worldNow.listOfQuests) {
            quest.setCompleted(false);
            ArrayList<Card> list = new ArrayList<>();
            quest.setReachCards(list);
            quest.setNow(false);
        }
        worldNow.amountOfCompletedQuests = 0;
        for (Essence essence : worldNow.listOfEssences) {
            essence.xOnFrame -= worldNow.xOfPlayer;
            essence.yOnFrame -= worldNow.yOfPlayer;
        }
        for (GameObject gameObject : worldNow.listOfObjects) {
            gameObject.xOnFrame -= worldNow.xOfPlayer;
            gameObject.yOnFrame -= worldNow.yOfPlayer;
        }
        for (Ground ground : worldNow.listOfGrounds) {
            ground.x -= worldNow.xOfPlayer;
            ground.y -= worldNow.yOfPlayer;
        }
        worldNow.xOfPlayer = 0;
        worldNow.yOfPlayer = 0;

        setNotification("Вы умерли! Ваше текущее количество смертей: " + worldNow.amountOfDeaths);

        iconPlayer = iconPlayerFrontStay;
        searchForNearbyGameObjects(); //Поиск, выделение и сохранение близких к игроку объектов.
    }

    private void resourceMining(String nameOfSearchObject) {
        int indexOfNearbyObject = worldNow.listOfNearbyGameObjects.size() - 1; //В переменную n сохраняется длина массива listOfNearbyGameObjects.
        if (indexOfNearbyObject != -1) { //Если он не пустой, то это условие срабатывает.
            while (!worldNow.listOfNearbyGameObjects.get(indexOfNearbyObject).name.equals(nameOfSearchObject)) { //Поиск древесины в массиве listOfNearbyGameObjects.
                indexOfNearbyObject--;
                if (indexOfNearbyObject == -1) { //Если поблизости деревья не найдены, то программа выходит из цикла.
                    break;
                }
            }
            if (indexOfNearbyObject != -1) { //Повторный условный оператор, т.к. после не нахождения деревьев поблизости переменная n могла стать -1.
                if (worldNow.listOfNearbyGameObjects.get(indexOfNearbyObject).name.equals(nameOfSearchObject)) {
                    worldNow.listOfObjects.remove(worldNow.listOfNearbyGameObjects.get(indexOfNearbyObject));
                    Card card = null;
                    switch (worldNow.listOfNearbyGameObjects.get(indexOfNearbyObject).name){
                        case "Wood":
                            card = new CardWood();
                            worldNow.amountOfAllGettingCardWoods++;
                            setNotification("Добыт ресурс: Дерево");
                            break;
                        case "Stone":
                            card = new CardStone();
                            worldNow.amountOfAllGettingCardStones++;
                            setNotification("Добыт ресурс: Камень");
                            break;
                        case "SmallStone":
                            card = new CardSmallStone();
                            worldNow.amountOfAllGettingCardSmallStones++;
                            setNotification("Добыт ресурс: Маленький камень");
                            break;
                        case "Gold":
                            card = new CardGold();
                            worldNow.amountOfAllGettingCardGolds++;
                            setNotification("Добыт ресурс: Золото");
                            break;
                        case "Diamond":
                            card = new CardDiamond();
                            worldNow.amountOfAllGettingCardDiamonds++;
                            setNotification("Добыт ресурс: Алмаз");
                            break;
                        case "Water":
                            card = new CardWater();
                            worldNow.amountOfAllGettingCardWaters++;
                            setNotification("Добыт ресурс: Вода");
                            break;
                    }
                    worldNow.slots.add(card);
                    worldNow.amountOfAllGettingCards++;
                    System.out.println("Уведомление. Получен ресурс: " + worldNow.listOfNearbyGameObjects.get(indexOfNearbyObject).name);
                }
            }
        }
    }

    private boolean collision(char l) {
        boolean ret = true;
        int xPlayer = xOfPlayerOnFrame;
        int yPlayer = yOfPlayerOnFrame;
        int xObject;
        int yObject;
        switch (l) {
            case 'w':
                for (int n = worldNow.listOfNearbyGameObjects.size() - 1; n >= 0; n--) {
                    if (worldNow.listOfNearbyGameObjects.get(n).name.equals("Stone")) {
                        xObject = worldNow.listOfNearbyGameObjects.get(n).xOnFrame;
                        yObject = worldNow.listOfNearbyGameObjects.get(n).yOnFrame;
                        for (int x2 = 10; x2 > 0; x2--) {
                            for (int x1 = worldNow.listOfNearbyGameObjects.get(n).height; x1 > 0; x1--) {
                                if (xPlayer == xObject) {
                                    for (int x3 = 10; x3 > 0; x3--) {
                                        for (int x4 = worldNow.listOfNearbyGameObjects.get(n).height; x4 > 0; x4--) {
                                            if (yPlayer == yObject) {
                                                ret = false;
                                            }
                                            yObject += 1;
                                        }
                                        yPlayer += 1;
                                        yObject = worldNow.listOfNearbyGameObjects.get(n).yOnFrame;
                                    }
                                }
                                xObject += 1;
                            }
                            xPlayer += 1;
                            xObject = worldNow.listOfNearbyGameObjects.get(n).xOnFrame;
                        }
                    }
                }
                break;
            case 's':
                for (int n = worldNow.listOfNearbyGameObjects.size() - 1; n >= 0; n--) {
                    if (worldNow.listOfNearbyGameObjects.get(n).name.equals("Stone")) {
                        xObject = worldNow.listOfNearbyGameObjects.get(n).xOnFrame + worldNow.listOfNearbyGameObjects.get(n).width;
                        yObject = worldNow.listOfNearbyGameObjects.get(n).yOnFrame + worldNow.listOfNearbyGameObjects.get(n).height;
                        for (int x2 = 10; x2 > 0; x2--) {
                            for (int x1 = worldNow.listOfNearbyGameObjects.get(n).height; x1 > 0; x1--) {
                                if (xPlayer == xObject) {
                                    for (int x3 = 10; x3 > 0; x3--) {
                                        for (int x4 = worldNow.listOfNearbyGameObjects.get(n).height; x4 > 0; x4--) {
                                            if (yPlayer == yObject) {
                                                ret = false;
                                            }
                                            yObject -= 1;
                                        }
                                        yPlayer += 1;
                                        yObject = worldNow.listOfNearbyGameObjects.get(n).yOnFrame;
                                    }
                                }
                                xObject -= 1;
                            }
                            xPlayer += 1;
                            xObject = worldNow.listOfNearbyGameObjects.get(n).xOnFrame;
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

    private static void searchForNearbyGameObjects() {
        worldNow.listOfNearbyGameObjects.subList(0, worldNow.listOfNearbyGameObjects.size()).clear();
        for (GameObject gameObject : worldNow.listOfObjects) {
            gameObject.isNearby = false;
            if (!gameObject.name.equals("Water") && !gameObject.name.equals("Barrier")) {
                for (int x = gameObject.xOnFrame - 40; x <= gameObject.xOnFrame + 40; x++) {
                    if (x == xOfPlayerOnFrame) {
                        for (int y = gameObject.yOnFrame - 40; y <= gameObject.yOnFrame + 40; y++) {
                            if (y == yOfPlayerOnFrame) {
                                worldNow.listOfNearbyGameObjects.add(gameObject);
                                switch (gameObject.name) {
                                    case "Wood":
                                    case "Stone":
                                    case "Gold":
                                    case "Diamond":
                                    case "SmallStone":
                                        gameObject.isNearby = true;
                                        break;
                                    case "Water":
                                        gameObject.color = colorWaterNearby;
                                        break;
                                }
                            }
                        }
                    }
                }
            }
        }

//        worldNow.listOfNearbyGameObjects.subList(0, worldNow.listOfNearbyGameObjects.size()).clear();
//        int x = xOfPlayerOnFrame - 40;
//        int y = yOfPlayerOnFrame - 40;
//        for (int z = 0; z < worldNow.listOfObjects.size(); z++) {
//            while (x <= xOfPlayerOnFrame + 40) {
//                if (worldNow.listOfObjects.get(z).name.equals("Water") || worldNow.listOfObjects.get(z).name.equals("Barrier") ? x == worldNow.listOfObjects.get(z).xOnFrame + (worldNow.listOfObjects.get(z).width / 2) : x == worldNow.listOfObjects.get(z).xOnFrame + (worldNow.listOfObjects.get(z).isNearby ? worldNow.listOfObjects.get(z).iconOfNearby.getWidth(null) / 2 : worldNow.listOfObjects.get(z).iconOfNearby.getWidth(null) / 2)) {
//                    while (y <= yOfPlayerOnFrame + 40) {
//                        if (worldNow.listOfObjects.get(z).name.equals("Water") || worldNow.listOfObjects.get(z).name.equals("Barrier") ? y == worldNow.listOfObjects.get(z).yOnFrame + (worldNow.listOfObjects.get(z).height / 2) : y == worldNow.listOfObjects.get(z).yOnFrame + (worldNow.listOfObjects.get(z).isNearby ? worldNow.listOfObjects.get(z).iconOfNearby.getHeight(null) / 2 : worldNow.listOfObjects.get(z).iconOfNearby.getHeight(null) / 2)) {
//                            worldNow.listOfNearbyGameObjects.add(worldNow.listOfObjects.get(z));
//                            switch (worldNow.listOfObjects.get(z).name) {
//                                case "Wood":
//                                case "Stone":
//                                case "Gold":
//                                case "Diamond":
//                                case "SmallStone":
//                                    worldNow.listOfObjects.get(z).isNearby = true;
//                                    break;
//                                case "Water":
//                                    worldNow.listOfObjects.get(z).color = colorWaterNearby;
//                                    break;
//                            }
//                        }
//                        y++;
//                    }
//                    y = yOfPlayerOnFrame - 40;
//                }
//                x++;
//            }
//            x = xOfPlayerOnFrame - 40;
//        }
//        int z1 = 0;
//        while (z1 < worldNow.listOfObjects.size()) {
//            if (worldNow.listOfNearbyGameObjects.indexOf(worldNow.listOfObjects.get(z1)) == -1) {
//                switch (worldNow.listOfObjects.get(z1).name) {
//                    case "Wood":
//                    case "Stone":
//                    case "Gold":
//                    case "Diamond":
//                    case "SmallStone":
//                        worldNow.listOfObjects.get(z1).isNearby = false;
//                        break;
//                    case "Water":
//                        worldNow.listOfObjects.get(z1).color = colorWater;
//                        break;
//                }
//            }
//            z1++;
//        }
    }

    //Метод
    private static void firstRespawn() {
        searchForNearbyGameObjects(); //Поиск, выделение и сохранение близких к игроку объектов.
        if (worldNow.slots.isEmpty()) {
            CardPovertyPants cardPovertyPants = new CardPovertyPants();
            CardPovertyShirt cardPovertyShirt = new CardPovertyShirt();
            cardPovertyPants.isWear = true;
            cardPovertyShirt.isWear = true;
            worldNow.slots.add(cardPovertyPants);
            worldNow.slots.add(cardPovertyShirt);
        }
        setNotification("Мир успешно создан!");
        iconPlayer = iconPlayerFrontStay;
    }

    private void playerMove(char XOnFrameOrYOnFrame, int numOfPixelsToMove) {
        if (ifNotOverBarrier(xOfPlayerOnFrame, yOfPlayerOnFrame)) {
            for (GameObject gameObject : worldNow.listOfObjects) {
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
                for (Ground ground : worldNow.listOfGrounds) {
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
                for (int x = worldNow.listOfGrounds.size()-1; x >= 0; x--) {
                    switch (XOnFrameOrYOnFrame) {
                        case 'x':
                            worldNow.listOfGrounds.get(x).x += numOfPixelsToMove;
                            break;
                        case 'y':
                            worldNow.listOfGrounds.get(x).y += numOfPixelsToMove;
                            break;
                    }
                }
            }
            for (Essence essence : worldNow.listOfEssences) {
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
                    worldNow.xOfPlayer += numOfPixelsToMove;
                    break;
                case 'y':
                    worldNow.yOfPlayer += numOfPixelsToMove;
                    break;
            }
        } else {
            respawn();
        }
    }

    static void setNotification(String notification) {
        for (JLabel label : listOfLabelsNotification) {
            if (label.isVisible()) {
                if (label.getY() != mainFrame.getHeight()-220) {
                    label.setBounds(label.getX(), label.getY() - 30, label.getWidth(), label.getHeight());
                } else {
                    visFalse(label);
                }
            }
        }
        for (JLabel label : listOfLabelsNotification) {
            if (!label.isVisible()) {
                visTrue(label);
                label.setBounds(mainFrame.getWidth()/5*3-40, mainFrame.getHeight()-100, 600, 50);
                label.setText(notification);
                listOfLabelsNotificationBool.add(listOfLabelsNotification.indexOf(label), true);
                break;
            }
        }
    }

    private void visFalseAll() {
        visFalse(buttonNewAccount);
        visFalse(buttonLoadAccount);
        visFalse(buttonLoadAccountFromNewAccount);
        visFalse(buttonNewAccountFromLoadAccount);
        visFalse(buttonNewWorld);
        visFalse(buttonSaveAccount);
        visFalse(buttonLoadWorld);
        visFalse(buttonExit);
        visFalse(buttonSettings);
        visFalse(buttonRegistrationBack);
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

        visFalse(textOfQuests);

        visFalse(comboBoxForLoadWorld);
    }
}