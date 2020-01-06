package Client.Mechanic; //Пакет класса.

//Импорт классов из пакетов Mechanic и Objects.
import Client.Objects.Account;
import Client.Objects.Cards.Card;
import Client.Objects.Cards.Materials.*;
import Client.Objects.Essences.Essence;
import Client.Objects.Essences.EssenceWolf;
import Client.Objects.GameObjects.*;
import Client.Objects.Quest;
import Client.Objects.World;
import static Client.Mechanic.MainVariables.*;
import static Client.Mechanic.GameProgress.*;

//Импорт библиотек API.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Это - GameMechanic - класс для отслеживания пользовательских нажатий по мышке, клавиатуре, фрейму и т. д., также в этом классе хранятся потоки, которые используются в игровой механике.
abstract class GameMechanic { //Этот класс наследует все открытые переменные класса MainVariables, а также всё то, что MainVariables унаследовал от своих классов-родителей.
    GameMechanic() { //Конструктор класса.
        //Вывод системных уседомлений.
        System.out.println("Creating object of class GameMechanic...");
        System.out.println("Finished creating object of class GameMechanic.");
    }
    //Метод preparationGUIAndWorld(), вызывающийся методом main(String[] args). Он подготавливает GUI и обработчики событий, мир и объекты в нём.
    static void preparationGUIAndWorld() {
        //Обработка startFrame
        startFrame.setSize(600, 630);
        startFrame.setLayout(null);
        startFrame.setLocationRelativeTo(null);
        startFrame.setResizable(false);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startFrame.add(buttonNewAccount);
        buttonNewAccount.setBounds(60, 260, 480, 65);
        startFrame.add(buttonLoadAccount);
        buttonLoadAccount.setBounds(50, 360, 500, 65);
        startFrame.add(buttonExit);
        buttonExit.setBounds(340, 535, 230, 50);
        startFrame.add(buttonSettings);
        buttonSettings.setBounds(30, 535, 270, 50);

        startFrame.add(buttonNewWorld);
        startFrame.add(buttonLoadWorld);
        startFrame.add(buttonSaveAccount);
        startFrame.add(textNameForNewWorld);

        startFrame.setLayout(new BorderLayout());
        startFrame.getContentPane().add(new DrawPanel());
        startFrame.repaint();

        buttonNewAccount.addActionListener(new NewAccount()); //Обработчик событий, выслеживающий нажатия по кнопке Регистрация (в окне startFrame) - buttonNewAccount.
        buttonLoadAccount.addActionListener(new LoadAccount());
        buttonLoadAccountFromNewAccount.addActionListener(new LoadAccount());
        buttonNewAccountFromLoadAccount.addActionListener(new NewAccount());
        buttonSaveAccount.addActionListener(new SaveAccount());
        buttonNewWorld.addActionListener(new NewWorld()); //Обработчик событий, выслеживающий нажатия по кнопке Войти в игру (в окне startFrame) - buttonNewWorld.
        buttonLoadWorld.addActionListener(new LoadWorld());
        buttonExit.addActionListener(new Exit()); //Обработчик событий, выслеживающий нажатия по кнопке Выйти (в окне startFrame) - buttonExit.
        buttonSettings.addActionListener(new Settings()); //Обработчик событий, выслеживающий нажатия по кнопке Настройки (в окне startFrame) - buttonSettings.
        System.out.println("JFrame startFrame has done.");


        //Обработка registrationFrame
        registrationFrame.setSize(300, 340);
        registrationFrame.setLayout(null);
        registrationFrame.setLocationRelativeTo(null);
        registrationFrame.setResizable(false);

        registrationFrame.add(labelWarning);

        registrationFrame.add(labelRegisterNick);
        registrationFrame.add(textNick);
        registrationFrame.add(labelRegisterAge);
        registrationFrame.add(textAge);
        registrationFrame.add(labelRegisterPassword);
        registrationFrame.add(textPassword);
        registrationFrame.add(buttonEndRegister);
        registrationFrame.add(buttonRegisterBack);
        registrationFrame.add(buttonLoadAccountFromNewAccount);

        labelRegisterNick.setBounds(10, 10, 300, 20);
        textNick.setBounds(10, 40, 220, 35);
        labelRegisterAge.setBounds(10, 85, 300, 20);
        textAge.setBounds(10, 115, 100, 25);
        labelRegisterPassword.setBounds(10, 150, 200, 20);
        textPassword.setBounds(10, 180, 250, 20);
        buttonEndRegister.setBounds(15, 250, 270, 45);
        buttonRegisterBack.setBounds(180, 0, 125, 30);
        buttonLoadAccountFromNewAccount.setBounds(10, 210, 220, 30);

        buttonEndRegister.addActionListener(new EndOfRegistrationAccount()); //Обработчик событий, выслеживающий нажатия по кнопке Регистрация (в окне registrationFrame) - buttonEndRegister.
        buttonRegisterBack.addActionListener(new RegisterBack()); //Обработчик событий, выслеживающий нажатия по кнопке Назад (в окне registrationFrame) - buttonEndRegister.
        System.out.println("JFrame registrationFrame has done.");


        //Обработка mainFrame
        mainFrame.setSize(widthOfFrame, heightOfFrame);
        mainFrame.setLayout(null);

        mainFrame.add(labelNick);
        labelNick.setVisible(true);
        mainFrame.add(buttonPantsSlots);
        mainFrame.add(buttonShirtSlots);
        mainFrame.add(buttonHandsSlots);
        buttonPantsSlots.setBounds(widthOfFrame/2 - 200, 500, 400, 50);
        buttonShirtSlots.setBounds(widthOfFrame/2 - 200, 300, 400, 50);
        buttonHandsSlots.setBounds(widthOfFrame/2 - 200, 400, 400, 50);
        buttonPantsSlots.setVisible(false);
        buttonShirtSlots.setVisible(false);
        buttonHandsSlots.setVisible(false);
        mainFrame.add(buttonRight);
        buttonRight.setBounds(widthOfFrame-100, heightOfFrame/2 - 40, 90, 80);
        buttonRight.setVisible(false);
        mainFrame.add(buttonLeft);
        buttonLeft.setBounds(10, heightOfFrame/2 - 40, 90, 80);
        buttonLeft.setVisible(false);
        mainFrame.add(labelSlots);
        labelSlots.setBounds(widthOfFrame/2 - 200, 50, 400, 50);
        labelSlots.setVisible(false);
        mainFrame.add(textOfQuests);
        textOfQuests.setBounds(widthOfFrame - 240, 30, 200, 200);
        textOfQuests.setVisible(true);

        textOfQuests.setEnabled(false);
        textOfQuests.setBackground(colorGameHandBackground2);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(isResizable);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.getContentPane().add(new DrawPanel());

        mainFrame.addKeyListener(new MainFrameKeyListener()); //Обработчик событий, выслеживающий нажатия по клавиатуре при открытии окна mainFrame.
        mainFrame.addMouseListener(new MainFrameMouseListener());
        mainFrame.addMouseMotionListener(new MainFrameMouseMotionListener());
        buttonHandsSlots.addActionListener(new InventorySlotsHands()); //Обработчик событий, выслеживающий нажатия по кнопке Ручной инвентарь (в окне mainFrame) - buttonHandsSlots.
        buttonPantsSlots.addActionListener(new InventorySlotsPants()); //Обработчик событий, выслеживающий нажатия по кнопке Карманы штанов (в окне mainFrame) - buttonPantsSlots.
        buttonShirtSlots.addActionListener(new InventorySlotsShirt()); //Обработчик событий, выслеживающий нажатия по кнопке Карманы куртки (в окне mainFrame) - buttonShirtSlots.
        buttonRight.addActionListener(new InventoryRight()); //Обработчик событий, выслеживающий нажатия по кнопке > (вправо) (в окне mainFrame) - buttonRight.
        buttonLeft.addActionListener(new InventoryLeft()); //Обработчик событий, выслеживающий нажатия по кнопке < (влево) (в окне mainFrame) - buttonLeft.

        System.out.println("JFrame mainFrame has done.");


        //Обработка settingsFrame
        settingsFrame.setSize(500, 530);
        settingsFrame.setLayout(null);
        settingsFrame.setLocationRelativeTo(null);
        settingsFrame.setResizable(false);
        System.out.println("JFrame settingsFrame has done.");

        System.out.println("All ActionListeners have added.");


        //Обработка фонтов
        labelAccount.setFont(f32);
        labelNick.setFont(f15);
        textOfQuests.setFont(f20);

        buttonRight.setFont(f50);
        buttonLeft.setFont(f50);
        buttonPantsSlots.setFont(f25);
        buttonShirtSlots.setFont(f25);
        buttonHandsSlots.setFont(f25);
        labelSlots.setFont(f50);

        buttonNewAccount.setFont(f45);
        buttonLoadAccount.setFont(f45);

        buttonNewWorld.setFont(f35);
        buttonLoadWorld.setFont(f35);
        buttonSaveAccount.setFont(f35);

        buttonExit.setFont(f40);
        buttonSettings.setFont(f35);

        buttonRegisterBack.setFont(f20);
        buttonLoadAccountFromNewAccount.setFont(f20);
        buttonNewAccountFromLoadAccount.setFont(f20);
        buttonEndRegister.setFont(f30);
        labelRegisterNick.setFont(f20);
        textNick.setFont(f25);
        labelRegisterAge.setFont(f20);
        textAge.setFont(f20);
        labelRegisterPassword.setFont(f20);
        textPassword.setFont(f20);
        System.out.println("All Fonts has done.");

        startFrame.setVisible(true); //Отображение окна startFrame.
        System.out.println("startFrame has displayed."); //Вывод системного уседомления.

        System.out.println("preparationGUIAndWorld() has completed."); //Вывод системного уседомления.

        preparationQuests();
    }

    private static void preparationQuests() {
        if (!isQuestsPrepared) {
            Quest quest1 = new Quest(1, "Собери 10 карт алмазов.", 10, 0, false);

            isQuestsPrepared = true;
        }
    }

    //Метод preparationRunnable(), вызывающийся во время начала игры для подготовки и запуску потоков repaintRunnable и wolfRunnable.
    private static void preparationRunnable() {
        if (!isRunnablePrepared) { //Эта строчка и переменная isRunnablePrepared нужны для того, чтобы метод запускался только один раз, а не преумножался при каждом старте игры.
            Runnable runnable = () -> {
                while (true) {
                    if (isRepaint) { //Переменная isRepaint нужна для временной остановки перерисовки экрана, но из-за большой нагрузки на компьютер, я врядли буду её когда-нибудь менять.
                        mainFrame.repaint(); //Выполнение перерисовки окна mainFrame.
                    }
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
                                                essence.icon = iconOfWolfLeft;
                                            } else if (xOfPlayerOnFrame - essence.xOnFrame > 3) { //Если игрок находится правее волка.
                                                essence.xOnFrame += 2 * essence.essenceSpeed; //То волк двигается вправо, по направлению к игроку.
                                                essence.icon = iconOfWolfRight;
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
                                                essence.icon = iconOfWolfLeft;
                                                break; //Конец кейса.
                                            case 1: //...1
                                                essence.xOnFrame += 2 * essence.essenceSpeed; //Передвижение волка вправо на определённое количество пикселей, в зависимости от скорости волка.
                                                essence.icon = iconOfWolfRight;
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
                        resourceMining("SmallStone", 1);
                    }
                    if (is2Pressed && timeForRunnable % 3 == 0) {
                        resourceMining("Wood", 3);
                        resourceMining("Stone", 3);
                    }
                    if (is3Pressed && timeForRunnable % 3 == 0) {
                        resourceMining("Gold", 3);
                        resourceMining("Diamond", 3);
                    }
                    if (is4Pressed && timeForRunnable % 3 == 0) {
                        resourceMining("Water", 2);
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

                    if (timeForRunnable % 5 == 0) {
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
            System.out.println("runnable has started"); //Вывод системного уседомления.

            isRunnablePrepared = true; //Изменеие значения переменной isRunnablePrepared на true для запрещения очередного вызова этого метода.
            System.out.println("preparationRunnable() has completed."); //Вывод системного уведомления.
        } //Конец if.
    } //Конец метода preparationRunnable().


    //Обработка событий нажатий кнопок.
    public static class NewWorld implements ActionListener { //Обработка нажатия кнопки buttonNewWorld.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            worldNow = new World();
//            worldNow.name =
            accountNow.listOfWorlds.add(worldNow);

            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier();
                barrier.xOnFrame = x*10;
                barrier.yOnFrame = 5000;
                worldNow.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier();
                barrier.xOnFrame = -(x*10);
                barrier.yOnFrame = 5000;
                worldNow.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier();
                barrier.xOnFrame = x*10;
                barrier.yOnFrame = -5000;
                worldNow.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier();
                barrier.xOnFrame = -(x*10);
                barrier.yOnFrame = -5000;
                worldNow.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier();
                barrier.xOnFrame = 5000;
                barrier.yOnFrame = x*10;
                worldNow.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier();
                barrier.xOnFrame = -5000;
                barrier.yOnFrame = x*10;
                worldNow.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier();
                barrier.xOnFrame = 5000;
                barrier.yOnFrame = -(x*10);
                worldNow.listOfObjects.add(barrier);
            }
            for (int x = 0; x <= 500; x++) {
                ObjectBarrier barrier = new ObjectBarrier();
                barrier.xOnFrame = -5000;
                barrier.yOnFrame = -(x*10);
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
            for (int x = worldNow.startAmountOfWaters; x > 0; x--) {
                GameObject water = new ObjectWater();
                water.setLocations(water);
                worldNow.listOfObjects.add(water);
            }
            System.out.println("All ObjectWaters have created.");
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
            System.out.println("NEW WORLD HAS CREATED.");

            startFrame.setVisible(false); //То скрываем окно-меню startFrame.
            mainFrame.setVisible(true); //И отображаем окно игры mainFrame.
            phaseOfRepaint = 2; //Переключение фазы перерисовки на вторую.
            preparationRunnable(); //Вызов метода preparationRunnable() для создания и запуска нужных для игры потоков.

            gameIsStartedOrNot = true; //Выдача переменной gameIsStartedOrNot значение true.
            firstRespawn(); //Вызов метода firstRespawn() для выдачи игроку начальных предметов и первого поиска ближайших к нему объектов. Игра начинается.
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса NewWorld.
    private static class LoadWorld implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (worldNow != null) {
                startFrame.setVisible(false);
                mainFrame.setVisible(true);
                phaseOfRepaint = 2;

                gameIsStartedOrNot = true;
            }
        }
    }
    private static class SaveAccount implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public static class Exit implements ActionListener { //Обработка нажатия кнопки buttonExit.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(0); //Завершение игры.
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса Exit.

    public static class Settings implements ActionListener { //Обработка нажатия кнопки buttonSettings.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            settingsFrame.setVisible(true); //Открытие окна настроек.
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса Exit.

    public static class NewAccount implements ActionListener { //Обработка нажатия кнопки buttonNewAccount.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            registrationFrame.remove(buttonNewAccountFromLoadAccount);

            registrationFrame.add(buttonLoadAccountFromNewAccount);
            buttonLoadAccountFromNewAccount.setBounds(10, 210, 220, 30);

            buttonEndRegister.setText("Создать");

            isNewAccount = true;

            registrationFrame.setVisible(true);
            registrationFrame.repaint();
            textNick.requestFocus();
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса NewAccount.
    private static class LoadAccount implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            registrationFrame.remove(buttonLoadAccountFromNewAccount);

            registrationFrame.add(buttonNewAccountFromLoadAccount);
            buttonNewAccountFromLoadAccount.setBounds(10, 210, 220, 30);

            buttonEndRegister.setText("Войти");

            isNewAccount = false;

            registrationFrame.setVisible(true);
            registrationFrame.repaint();
        }
    }

    private static class EndOfRegistrationAccount implements ActionListener { //Обработка нажатия кнопки buttonEndRegister.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            try { //Проверка правильного введения возраста.
                Integer.parseInt(textAge.getText()); //Если переведение вписанного возраста в числа выдаст ошибку, программа перейдёт в catch.
                registrationFrame.remove(labelWarning); //Удаление надписи, предупреждающей о неправильном введении возраста.
            } catch (NumberFormatException e) {
                textAge.setText(""); //Опустошение поля возраст для неудачной работы следующего условия.
                textAge.requestFocus(); //Наведение курсора на поле Возраст.
                registrationFrame.add(labelWarning);
                labelWarning.setBounds(120, 110, 200, 30); //Появление надписи, предупреждающей о неправильном введении возраста.
            }
            //Если все поля регистрации чем-то заполнены, а возраст получилось перевести в цифры, то это условие срабатывает.
            if (!textNick.getText().equals("") && !textPassword.getText().equals("") && !textAge.getText().equals("")) {
                if (isNewAccount) {
                    registrationFrame.setVisible(false); //Скрытие registrationFrame.
                    startFrame.setVisible(false);

                    accountNow = new Account();
                    accountNow.nick = textNick.getText(); //Сохранение ника.
                    accountNow.age = Integer.parseInt(textAge.getText());
                    accountNow.password = textPassword.getText(); //Сохранение пароля.

                    startFrame.setLayout(null);

                    startFrame.remove(buttonNewAccount); //Удаление кнопки buttonNewAccount со startFrame.
                    startFrame.remove(buttonLoadAccount);

                    labelAccount.setText(accountNow.nick); //Появление надписи с введённым ником на startFrame.
                    startFrame.add(labelAccount);
                    labelAccount.setBounds(30, 540, 250, 40);

                    buttonNewWorld.setBounds(30, 240, 420, 60);
                    textNameForNewWorld.setBounds(460, 235, 100, 50);
                    buttonLoadWorld.setBounds(90, 330, 420, 60);
                    buttonSaveAccount.setBounds(110, 420, 380, 55);

                    startFrame.setVisible(true);
                }
            }
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса EndOfRegistrationAccount.

    private static class RegisterBack implements ActionListener { //Обработка нажатия кнопки buttonRegisterBack.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            registrationFrame.setVisible(false); //Закрытие окна registrationFrame.
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса RegisterBack.


    private static class InventoryRight implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            mainFrame.setLayout(null);
            buttonRight.setVisible(false);
            buttonRight.removeActionListener(new InventoryRight());
            buttonLeft.removeActionListener(new InventoryLeft());
            buttonLeft.addActionListener(new CharacterisesLeft());
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventoryRight.
    private static class InventoryLeft implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            mainFrame.setLayout(null);
            buttonLeft.setVisible(false);
            buttonLeft.removeActionListener(new InventoryLeft());
            buttonRight.removeActionListener(new InventoryRight());
            buttonRight.addActionListener(new ClothesRight());
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventoryLeft.

    private static class ClothesRight implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            mainFrame.setLayout(null);
            buttonLeft.addActionListener(new InventoryLeft());
            buttonLeft.setVisible(true);
            buttonRight.removeActionListener(new ClothesRight());
            buttonRight.addActionListener(new InventoryRight());
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса ClothesRight.
    private static class CharacterisesLeft implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            mainFrame.setLayout(null);
            buttonRight.addActionListener(new InventoryRight());
            buttonRight.setVisible(true);
            buttonLeft.removeActionListener(new CharacterisesLeft());
            buttonLeft.addActionListener(new InventoryLeft());
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса CharacterisesLeft.

    private static class InventorySlotsPants implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {

        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventorySlotsPants.
    private static class InventorySlotsShirt implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {

        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventorySlotsShirt.
    private static class InventorySlotsHands implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {

        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventorySlotsHands.

    //Событие нажатий клавиатуры
    public static class MainFrameKeyListener extends KeyAdapter implements KeyListener {
        @Override //Переопределение методов keyPressed(KeyEvent button), keyReleased(KeyEvent e) и keyTyped(KeyEvent e).
        public void keyPressed(KeyEvent button) {
            switch (button.getKeyChar()) { //Сравнивание нажатой клавиши с её возможными значениями.
                case 0x31: //1
                    if (!is1Pressed) {
                        is1Pressed = true;
                    }
                    break;
                case 0x32: //2
                    if (!is2Pressed) {
                        is2Pressed = true;
                    }
                    break;
                case 0x33: //3
                    if (!is3Pressed) {
                        is3Pressed = true;
                    }
                    break;
                case 0x34: //4
                    if (!is4Pressed) {
                        is4Pressed = true;
                    }
                    break;
                case 0x11: //Control

                    break;
                case 'w': //w
                case 'ц': //ц
                    if (!iswPressed && !isWPressed) {
                        iswPressed = true;
                    }
                    break;

                case 'W': //W
                case 'Ц': //Ц
                    if (!iswPressed && !isWPressed) {
                        isWPressed = true;
                    }
                    break;

                case 'a': //a
                case 'ф': //ф
                    if (!isaPressed && !isAPressed) {
                        isaPressed = true;
                    }
                    break;
                case 'A': //A
                case 'Ф': //Ф
                    if (!isaPressed && !isAPressed) {
                        isAPressed = true;
                    }
                    break;

                case 's': //s
                case 'ы': //ы
                    if (!issPressed && !isSPressed) {
                        issPressed = true;
                    }
                    break;
                case 'S': //S
                case 'Ы': //Ы
                    if (!issPressed && !isSPressed) {
                        isSPressed = true;
                    }
                    break;

                case 'd': //d
                case 'в': //в
                    if (!isdPressed && !isDPressed) {
                        isdPressed = true;
                    }
                    break;
                case 'D': //D
                case 'В': //В
                    if (!isdPressed && !isDPressed) {
                        isDPressed = true;
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

                    mainFrame.setVisible(false);
                    phaseOfRepaint = 1;
                    startFrame.setVisible(true);
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
                        mainFrame.setLayout(null);

                        labelNick.setVisible(false);
                        labelSlots.setVisible(true);
                        buttonRight.setVisible(true);
                        buttonLeft.setVisible(true);
                        buttonPantsSlots.setVisible(true);
                        buttonShirtSlots.setVisible(true);
                        buttonHandsSlots.setVisible(true);

                        mainFrame.repaint();
                    } else {
                        mainFrame.setLayout(null);
                        labelNick.setVisible(true);
                        labelSlots.setVisible(false);
                        buttonRight.setVisible(false);
                        buttonLeft.setVisible(false);
                        buttonPantsSlots.setVisible(false);
                        buttonShirtSlots.setVisible(false);
                        buttonHandsSlots.setVisible(false);
                        mainFrame.setLayout(new BorderLayout());
                        phaseOfRepaint = 2;
                        mainFrame.repaint();
                        System.out.println("Уведомление. Выход из инвенторя.");
                        isRepaint = true;
                    }
                    break;
                case 't': //t
                case 'T': //T
                case 'е': //е
                case 'Е': //е
                    int x = (int) (Math.random() * 10) * 100 - 500;
                    int y = (int) (Math.random() * 10) * 100 - 500;
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
                    searchForNearbyGameObjects(); //Поиск, выделение и сохранение близких к игроку объектов.
                    break;
                case 'k': //k
                case 'K': //K
                case 'л': //л
                case 'Л': //Л
                    respawn();
                    break;
            }
        }
        public void keyReleased(KeyEvent button) {
            switch (button.getKeyChar()) {
                case 'w': //w
                case 'ц': //ц
                    iswPressed = false;
                    break;
                case 'W': //W
                case 'Ц': //Ц
                    isWPressed = false;
                    break;
                case 'a': //a
                case 'ф': //ф
                    isaPressed = false;
                    break;
                case 'A': //A
                case 'Ф': //Ф
                    isAPressed = false;
                    break;
                case 's': //s
                case 'ы': //ы
                    issPressed = false;
                    break;
                case 'S': //S
                case 'Ы': //Ы
                    isSPressed = false;
                    break;
                case 'd': //d
                case 'в': //в
                    isdPressed = false;
                    break;
                case 'D': //D
                case 'В': //В
                    isDPressed = false;
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
    private static class MainFrameMouseListener implements MouseListener {
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

    private static class MainFrameMouseMotionListener implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    private static boolean ifNotOverBarrier(int x, int y) {
        boolean ret = true;
        for (GameObject gameObject : worldNow.listOfObjects) {
            if (gameObject.name.equals("Barrier")) {
                if ((gameObject.xOnFrame - x < 4 && gameObject.xOnFrame - x > -4) && (gameObject.yOnFrame - y < 4 && gameObject.yOnFrame - y > -4)) {
                    ret = false;
                }
            }
        }
        return ret;
    }
    private static void respawn() {
        System.out.println("Уведомление. Вы умерли");
        worldNow.amountOfDeaths++;
        System.out.println("Уведомление. Ваше количество смертей: " + worldNow.amountOfDeaths);
        worldNow.health = worldNow.maxHealth;
        worldNow.slots.subList(0, worldNow.slots.size()).clear();
        for (Essence essence : worldNow.listOfEssences) {
            essence.xOnFrame -= worldNow.xOfPlayer;
            essence.yOnFrame -= worldNow.yOfPlayer;
        }
        for (GameObject gameObject : worldNow.listOfObjects) {
            gameObject.xOnFrame -= worldNow.xOfPlayer;
            gameObject.yOnFrame -= worldNow.yOfPlayer;
        }
        worldNow.xOfPlayer = 0;
        worldNow.yOfPlayer = 0;
        searchForNearbyGameObjects(); //Поиск, выделение и сохранение близких к игроку объектов.
    }

    private static void resourceMining(String nameOfSearchObject, int chanceToGetResource) {
        int indexOfNearbyObject = worldNow.NearbyGameObjects.size() - 1; //В переменную n сохраняется длина массива NearbyGameObjects.
        if (indexOfNearbyObject != -1) { //Если он не пустой, то это условие срабатывает.
            while (!worldNow.NearbyGameObjects.get(indexOfNearbyObject).name.equals(nameOfSearchObject)) { //Поиск древесины в массиве NearbyGameObjects.
                indexOfNearbyObject--;
                if (indexOfNearbyObject == -1) { //Если поблизости деревья не найдены, то программа выходит из цикла.
                    break;
                }
            }
            if (indexOfNearbyObject != -1) { //Повторный условный оператор, т.к. после не нахождения деревьев поблизости переменная n могла стать -1.
                if (worldNow.NearbyGameObjects.get(indexOfNearbyObject).name.equals(nameOfSearchObject)) {
                    worldNow.NearbyGameObjects.get(indexOfNearbyObject).height -= 2;
                    worldNow.NearbyGameObjects.get(indexOfNearbyObject).width -= 2;
                    worldNow.NearbyGameObjects.get(indexOfNearbyObject).xOnFrame += 1;
                    worldNow.NearbyGameObjects.get(indexOfNearbyObject).yOnFrame += 1;
                    if (worldNow.NearbyGameObjects.get(indexOfNearbyObject).height <= 0 || worldNow.NearbyGameObjects.get(indexOfNearbyObject).width <= 0) {
                        worldNow.listOfObjects.remove(worldNow.NearbyGameObjects.get(indexOfNearbyObject));
                    }

                    int rand = (int) (Math.random() * chanceToGetResource);
                    Card card = null;
                    if (rand == 0) {
                        switch (worldNow.NearbyGameObjects.get(indexOfNearbyObject).name){
                            case "Wood":
                                card = new CardWood();
                                worldNow.amountOfAllGettingCardWoods++;

                                break;
                            case "Stone":
                                card = new CardStone();
                                worldNow.amountOfAllGettingCardStones++;
                                break;
                            case "SmallStone":
                                card = new CardSmallStone();
                                worldNow.amountOfAllGettingCardSmallStones++;
                                break;
                            case "Gold":
                                card = new CardGold();
                                worldNow.amountOfAllGettingCardGolds++;
                                break;
                            case "Diamond":
                                card = new CardDiamond();
                                worldNow.amountOfAllGettingCardDiamonds++;
                                break;
                            case "Water":
                                card = new CardWater();
                                worldNow.amountOfAllGettingCardWaters++;
                                break;
                        }
                        worldNow.slots.add(card);
                        worldNow.amountOfAllGettingCards++;
                        System.out.println("Уведомление. Получен ресурс: " + worldNow.NearbyGameObjects.get(indexOfNearbyObject).name);
                    }
                }
            }
        }
    }

    private static void playerMove(char XOnFrameOrYOnFrame, int numOfPixelsToMove) {
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
}
