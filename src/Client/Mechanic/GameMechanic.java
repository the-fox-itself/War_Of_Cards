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
import Client.Objects.Quest;
import Client.Objects.World;
import static Client.Mechanic.MainVariables.*;

//Импорт библиотек API.
import javax.swing.*;
import java.awt.event.*;

//Это - GameMechanic - класс для отслеживания пользовательских нажатий по мышке, клавиатуре, фрейму и т. д., также в этом классе хранятся потоки, которые используются в игровой механике.
class GameMechanic { //Этот класс наследует все открытые переменные класса MainVariables, а также всё то, что MainVariables унаследовал от своих классов-родителей.
    GameMechanic() { //Конструктор класса.
        //Вывод системных уседомлений.
        System.out.println("Creating object of class GameMechanic...");
        System.out.println("Finished creating object of class GameMechanic.");
    }
    //Метод preparationGUIAndWorld(), вызывающийся методом main(String[] args). Он подготавливает GUI и обработчики событий, мир и объекты в нём.
    void preparationGUIAndWorld() {
        //Обработка startFrame
        startFrame.setSize(600, 630);
        startFrame.setLocationRelativeTo(null);
        startFrame.setResizable(false);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lNull(startFrame);

        setComponentOnFrame(startFrame, buttonNewAccount, f45, 60, 260, 480, 65);
        setComponentOnFrame(startFrame, buttonLoadAccount, f45, 50, 360, 500, 65);
        setComponentOnFrame(startFrame, buttonExit, f40, 340, 535, 230, 50);
        setComponentOnFrame(startFrame, buttonSettings, f35, 30, 535, 270, 50);

        setComponentOnFrame(startFrame, buttonNewWorld, f35, 30, 240, 420, 60);
        setComponentOnFrame(startFrame, buttonLoadWorld, f35, 90, 330, 420, 60);
        setComponentOnFrame(startFrame, buttonSaveAccount, f35, 110, 420, 380, 55);
        setComponentOnFrame(startFrame, textNameForNewWorld, f35, 460, 235, 100, 50);

        setComponentOnFrame(startFrame, labelAccount, f32, 30, 540, 250, 40);

        lBord(startFrame);
        startFrame.getContentPane().add(new DrawPanel());
        startFrame.repaint();

        buttonNewAccount.addActionListener(new NewAccount()); //Обработчик событий, выслеживающий нажатия по кнопке Регистрация (в окне startFrame) - buttonNewAccount.
        buttonLoadAccount.addActionListener(new LoadAccount());
        buttonSaveAccount.addActionListener(new SaveAccount());
        buttonNewWorld.addActionListener(new NewWorld()); //Обработчик событий, выслеживающий нажатия по кнопке Войти в игру (в окне startFrame) - buttonNewWorld.
        buttonLoadWorld.addActionListener(new LoadWorld());
        buttonExit.addActionListener(new Exit()); //Обработчик событий, выслеживающий нажатия по кнопке Выйти (в окне startFrame) - buttonExit.
        buttonSettings.addActionListener(new Settings()); //Обработчик событий, выслеживающий нажатия по кнопке Настройки (в окне startFrame) - buttonSettings.
        System.out.println("JFrame startFrame has done.");


        //Обработка registrationFrame
        registrationFrame.setSize(300, 340);
        lNull(registrationFrame);
        registrationFrame.setLocationRelativeTo(null);
        registrationFrame.setResizable(false);

        setComponentOnFrame(registrationFrame, labelWarning, f20, 120, 110, 200, 30);
        setComponentOnFrame(registrationFrame, labelRegisterNick, f20, 10, 10, 300, 20);
        setComponentOnFrame(registrationFrame, textNick, f25, 10, 40, 220, 35);
        setComponentOnFrame(registrationFrame, labelRegisterAge, f20, 10, 85, 300, 20);
        setComponentOnFrame(registrationFrame, textAge, f20, 10, 115, 100, 25);
        setComponentOnFrame(registrationFrame, labelRegisterPassword, f20, 10, 150, 200, 20);
        setComponentOnFrame(registrationFrame, textPassword, f20, 10, 180, 250, 20);
        setComponentOnFrame(registrationFrame, buttonEndRegister, f30, 15, 250, 270, 45);
        setComponentOnFrame(registrationFrame, buttonRegistrationBack, f20, 180, 0, 125, 30);
        setComponentOnFrame(registrationFrame, buttonNewAccountFromLoadAccount, f20, 10, 210, 220, 30);
        setComponentOnFrame(registrationFrame, buttonLoadAccountFromNewAccount, f20, 10, 210, 220, 30);

        buttonEndRegister.addActionListener(new EndOfRegistrationAccount()); //Обработчик событий, выслеживающий нажатия по кнопке Регистрация (в окне registrationFrame) - buttonEndRegister.
        buttonRegistrationBack.addActionListener(new RegisterBack()); //Обработчик событий, выслеживающий нажатия по кнопке Назад (в окне registrationFrame) - buttonEndRegister.
        buttonNewAccountFromLoadAccount.addActionListener(new NewAccount());
        buttonLoadAccountFromNewAccount.addActionListener(new LoadAccount());
        System.out.println("JFrame registrationFrame has done.");

        //Обработка mainFrame
        mainFrame.setSize(widthOfFrame, heightOfFrame);
        lNull(mainFrame);

        setComponentOnFrame(mainFrame, labelNick, f15, xOfPlayerOnFrame - 30, yOfPlayerOnFrame - 55, 80, 20);

        setComponentOnFrame(mainFrame, labelSlots, f50, widthOfFrame/2 - 200, 50, 400, 50);

        setComponentOnFrame(mainFrame, buttonShirtSlots, f25, widthOfFrame/2 - 200, 300, 400, 50);
        setComponentOnFrame(mainFrame, buttonHandsSlots, f25, widthOfFrame/2 - 200, 400, 400, 50);
        setComponentOnFrame(mainFrame, buttonPantsSlots, f25, widthOfFrame/2 - 200, 500, 400, 50);

        setComponentOnFrame(mainFrame, buttonRight, f50, widthOfFrame-100, heightOfFrame/2 - 40, 90, 80);
        setComponentOnFrame(mainFrame, buttonLeft, f50, 10, heightOfFrame/2 - 40, 90, 80);

        setComponentOnFrame(mainFrame, textOfQuests, f20, widthOfFrame - 240, 30, 200, 200);

        textOfQuests.setEnabled(false);
        textOfQuests.setBackground(colorGameHandBackground2);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(isResizable);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lBord(mainFrame);
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
        lNull(settingsFrame);
        settingsFrame.setLocationRelativeTo(null);
        settingsFrame.setResizable(false);
        System.out.println("JFrame settingsFrame has done.");

        System.out.println("All ActionListeners have added.");

        System.out.println("preparationGUIAndWorld() has completed."); //Вывод системного уседомления.

        if (!isQuestsPrepared) {
            Quest quest1 = new Quest(1, "Собери 10 карт алмазов.", 10, 0, false);

            isQuestsPrepared = true;
        }

        accountMenu();
    }

    private void accountMenu() {
        visTrue(buttonNewAccount);
        visTrue(buttonLoadAccount);
        visTrue(buttonExit);
        visTrue(buttonSettings);

        visTrue(startFrame); //Отображение окна startFrame.
    }
    private void registrationMenu() {
        visTrue(labelRegisterNick);
        visTrue(textNick);
        visTrue(labelRegisterAge);
        visTrue(textAge);
        visTrue(labelRegisterPassword);
        visTrue(textPassword);
        visTrue(buttonEndRegister);
        visTrue(buttonRegistrationBack);

        visTrue(registrationFrame);
        registrationFrame.repaint();
        labelNick.requestFocus();
    }
    private void worldMenu() {
        visFalse(buttonNewAccount);
        visFalse(buttonLoadAccount);

        labelAccount.setText(accountNow.nick); //Появление надписи с введённым ником на startFrame.
        visTrue(labelAccount);

        visTrue(buttonNewWorld);
        visTrue(textNameForNewWorld);
        visTrue(buttonLoadWorld);
        visTrue(buttonSaveAccount);

        visTrue(startFrame);
    }
    private void gameMenu() {
        visTrue(labelNick);
        visTrue(textOfQuests);
    }

    //Метод preparationRunnable(), вызывающийся во время начала игры для подготовки и запуску потоков repaintRunnable и wolfRunnable.
    private void preparationRunnable() {
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
    public class NewWorld implements ActionListener { //Обработка нажатия кнопки buttonNewWorld.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            worldNow = new World();
            worldNow.name = textNameForNewWorld.getText();
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

            visFalse(startFrame); //То скрываем окно-меню startFrame.

            gameMenu();

            visTrue(mainFrame); //И отображаем окно игры mainFrame.
            phaseOfRepaint = 2; //Переключение фазы перерисовки на вторую.
            preparationRunnable(); //Вызов метода preparationRunnable() для создания и запуска нужных для игры потоков.

            gameIsStartedOrNot = true; //Выдача переменной gameIsStartedOrNot значение true.
            firstRespawn(); //Вызов метода firstRespawn() для выдачи игроку начальных предметов и первого поиска ближайших к нему объектов. Игра начинается.
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса NewWorld.
    private class LoadWorld implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (worldNow != null) {
                visFalse(startFrame);
                visTrue(mainFrame);
                phaseOfRepaint = 2;

                gameIsStartedOrNot = true;
            }
        }
    }
    private class SaveAccount implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

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
            visTrue(settingsFrame); //Открытие окна настроек.
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса Exit.

    public class NewAccount implements ActionListener { //Обработка нажатия кнопки buttonNewAccount.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            visFalse(buttonNewAccountFromLoadAccount);
            visTrue(buttonLoadAccountFromNewAccount);
            buttonEndRegister.setText("Создать");
            isNewAccount = true;
            registrationMenu();
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса NewAccount.

    private class LoadAccount implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            visFalse(buttonLoadAccountFromNewAccount);
            visTrue(buttonNewAccountFromLoadAccount);
            buttonEndRegister.setText("Войти");
            isNewAccount = false;
            registrationMenu();
        }
    }

    private class EndOfRegistrationAccount implements ActionListener { //Обработка нажатия кнопки buttonEndRegister.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            try { //Проверка правильного введения возраста.
                Integer.parseInt(textAge.getText()); //Если переведение вписанного возраста в числа выдаст ошибку, программа перейдёт в catch.
                visFalse(labelWarning);
            } catch (NumberFormatException e) {
                textAge.setText(""); //Опустошение поля возраст для неудачной работы следующего условия.
                textAge.requestFocus(); //Наведение курсора на поле Возраст.
                visTrue(labelWarning);
            }
            //Если все поля регистрации чем-то заполнены, а возраст получилось перевести в цифры, то это условие срабатывает.
            if (!textNick.getText().equals("") && !textPassword.getText().equals("") && !textAge.getText().equals("")) {
                if (isNewAccount) {
                    visFalse(registrationFrame); //Скрытие registrationFrame.
                    visFalse(startFrame);

                    accountNow = new Account();
                    accountNow.nick = textNick.getText(); //Сохранение ника.
                    accountNow.age = Integer.parseInt(textAge.getText());
                    accountNow.password = textPassword.getText(); //Сохранение пароля.

                    lNull(startFrame);

                    worldMenu();
                }
            }
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса EndOfRegistrationAccount.

    private class RegisterBack implements ActionListener { //Обработка нажатия кнопки buttonRegistrationBack.
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            visFalse(registrationFrame); //Закрытие окна registrationFrame.
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса RegisterBack.


    private class InventoryLeft implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            lNull(mainFrame);
            if (buttonRight.isVisible())
                visFalse(buttonLeft);
            else
                visTrue(buttonRight);

            lBord(mainFrame);
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventoryLeft.

    private class InventoryRight implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            lNull(mainFrame);
            if (buttonLeft.isVisible())
                visFalse(buttonRight);
            else
                visTrue(buttonLeft);

            lBord(mainFrame);
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventoryRight.

    private class InventorySlotsPants implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            lBord(mainFrame);
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventorySlotsPants.
    private class InventorySlotsShirt implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            lBord(mainFrame);
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventorySlotsShirt.
    private class InventorySlotsHands implements ActionListener {
        @Override //Переопределение метода actionPerformed(ActionEvent actionEvent).
        public void actionPerformed(ActionEvent actionEvent) {
            lBord(mainFrame);
        } //Конец переопредлённого метода actionPerformed().
    } //Конец внутреннего класса InventorySlotsHands.

    //Событие нажатий клавиатуры
    public class MainFrameKeyListener extends KeyAdapter implements KeyListener {
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
                        lNull(mainFrame);

                        visFalse(labelNick);

                        visTrue(labelSlots);
                        visTrue(buttonRight);
                        visTrue(buttonLeft);
                        visTrue(buttonPantsSlots);
                        visTrue(buttonShirtSlots);
                        visTrue(buttonHandsSlots);

                        mainFrame.repaint();
                    } else {
                        lNull(mainFrame);

                        visTrue(labelNick);

                        visFalse(labelSlots);
                        visFalse(buttonRight);
                        visFalse(buttonLeft);
                        visFalse(buttonPantsSlots);
                        visFalse(buttonShirtSlots);
                        visFalse(buttonHandsSlots);

                        lBord(mainFrame);
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
                if ((gameObject.xOnFrame - x < 4 && gameObject.xOnFrame - x > -4) && (gameObject.yOnFrame - y < 4 && gameObject.yOnFrame - y > -4)) {
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

    private void resourceMining(String nameOfSearchObject, int chanceToGetResource) {
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

    private boolean collision(char l) {
        boolean ret = true;
        int xPlayer = xOfPlayerOnFrame;
        int yPlayer = yOfPlayerOnFrame;
        int xObject;
        int yObject;
        switch (l) {
            case 'w':
                for (int n = worldNow.NearbyGameObjects.size() - 1; n >= 0; n--) {
                    if (worldNow.NearbyGameObjects.get(n).name.equals("Stone")) {
                        xObject = worldNow.NearbyGameObjects.get(n).xOnFrame;
                        yObject = worldNow.NearbyGameObjects.get(n).yOnFrame;
                        for (int x2 = 10; x2 > 0; x2--) {
                            for (int x1 = worldNow.NearbyGameObjects.get(n).height; x1 > 0; x1--) {
                                if (xPlayer == xObject) {
                                    for (int x3 = 10; x3 > 0; x3--) {
                                        for (int x4 = worldNow.NearbyGameObjects.get(n).height; x4 > 0; x4--) {
                                            if (yPlayer == yObject) {
                                                ret = false;
                                            }
                                            yObject += 1;
                                        }
                                        yPlayer += 1;
                                        yObject = worldNow.NearbyGameObjects.get(n).yOnFrame;
                                    }
                                }
                                xObject += 1;
                            }
                            xPlayer += 1;
                            xObject = worldNow.NearbyGameObjects.get(n).xOnFrame;
                        }
                    }
                }
                break;
            case 's':
                for (int n = worldNow.NearbyGameObjects.size() - 1; n >= 0; n--) {
                    if (worldNow.NearbyGameObjects.get(n).name.equals("Stone")) {
                        xObject = worldNow.NearbyGameObjects.get(n).xOnFrame + worldNow.NearbyGameObjects.get(n).width;
                        yObject = worldNow.NearbyGameObjects.get(n).yOnFrame + worldNow.NearbyGameObjects.get(n).height;
                        for (int x2 = 10; x2 > 0; x2--) {
                            for (int x1 = worldNow.NearbyGameObjects.get(n).height; x1 > 0; x1--) {
                                if (xPlayer == xObject) {
                                    for (int x3 = 10; x3 > 0; x3--) {
                                        for (int x4 = worldNow.NearbyGameObjects.get(n).height; x4 > 0; x4--) {
                                            if (yPlayer == yObject) {
                                                ret = false;
                                            }
                                            yObject -= 1;
                                        }
                                        yPlayer += 1;
                                        yObject = worldNow.NearbyGameObjects.get(n).yOnFrame;
                                    }
                                }
                                xObject -= 1;
                            }
                            xPlayer += 1;
                            xObject = worldNow.NearbyGameObjects.get(n).xOnFrame;
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
