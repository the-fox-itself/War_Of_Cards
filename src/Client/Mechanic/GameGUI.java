package Client.Mechanic; //Пакет класса.

import Client.Objects.Essences.EssenceWolf;
import Client.Objects.GameObjects.*; //Импорт классов из других пакетов.

import javax.swing.*; //Импорт библиотек.
import java.awt.*;

class GameGUI extends MainVariables { //Класс для хранения всех объектов GUI в игре.
    //Объекты GUI
    static JFrame startFrame = new JFrame("War Of Cards 0.1");
    static JFrame registerFrame = new JFrame("War Of Cards 0.1");
    static JFrame settingsFrame = new JFrame("War Of Cards 0.1");
    static JFrame gameFrame = new JFrame("War Of Cards 0.1");

    JButton buttonPlay = new JButton("Войти в игру");
    JButton buttonExit = new JButton("Выйти");
    JButton buttonSettings = new JButton("Настройки");
    JButton buttonRegister = new JButton("Регистрация");
    JButton buttonRegisterBack = new JButton("Назад");
    JButton buttonEndRegister = new JButton("Регистрация");
    JButton buttonRight = new JButton(">");
    JButton buttonLeft = new JButton("<");

    JButton buttonPantsClothes = new JButton();
    JButton buttonShirtClothes = new JButton();

    JButton buttonPantsSlots = new JButton();
    JButton buttonShirtSlots = new JButton();
    JButton buttonHandsSlots = new JButton("Ручной инвентарь");

    private JLabel labelRegisterNick = new JLabel("Логин");
    private JLabel labelRegisterAge = new JLabel("Возраст");
    private JLabel labelRegisterPassword = new JLabel("Пароль");
    JLabel labelAccount = new JLabel();
    JLabel labelWarning = new JLabel("Введите целое число");
    JLabel labelSlots = new JLabel("Слоты");

    static JLabel labelNick = new JLabel();

    static JTextField textNick = new JTextField();
    JTextField textAge = new JTextField();
    JTextField textPassword = new JPasswordField();

    private JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem("Вход в аккаунт");

    private Font f50 = new Font("", Font.BOLD, 50);
    private Font f45 = new Font("", Font.BOLD, 45);
    private Font f40 = new Font("", Font.BOLD, 40);
    private Font f35 = new Font("", Font.BOLD, 35);
    private Font f32 = new Font("", Font.BOLD, 32);
    private Font f30 = new Font("", Font.BOLD, 30);
    private Font f27 = new Font("", Font.BOLD, 27);
    private Font f25 = new Font("", Font.BOLD, 25);
    private Font f20 = new Font("", Font.BOLD, 20);
    private Font f15 = new Font("", Font.BOLD, 15);

    //Метод для подготовки GUI к работе.
    void readyGUI() {
        //Обработка DrawPanel
        for (int x = amountOfWoods; x > 0; x--) {
            ObjectWood wood = new ObjectWood();
            wood.setLocations(wood);
            listOfObjects.add(wood);
        }
        for (int x = amountOfStones; x > 0; x--) {
            ObjectStone stone = new ObjectStone();
            stone.setLocations(stone);
            listOfObjects.add(stone);
        }
        for (int x = amountOfSmallStones; x > 0; x--) {
            ObjectSmallStone smallStone = new ObjectSmallStone();
            smallStone.setLocations(smallStone);
            listOfObjects.add(smallStone);
        }
        for (int x = amountOfWaters; x > 0; x--) {
            ObjectWater water = new ObjectWater();
            water.setLocations(water);
            listOfObjects.add(water);
        }
        for (int x = amountOfGold; x > 0; x--) {
            ObjectGold gold = new ObjectGold();
            gold.setLocations(gold);
            listOfObjects.add(gold);
        }
        for (int x = amountOfWolfs; x > 0; x--) {
            EssenceWolf wolf = new EssenceWolf();
            listOfEssences.add(wolf);
        }

        //Обработка startFrame
        startFrame.setSize(600, 630);
        startFrame.setLayout(null);
        startFrame.setLocationRelativeTo(null);
        startFrame.setResizable(false);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startFrame.add(labelAccount);
        registerFrame.add(labelWarning);

        startFrame.add(buttonPlay);
        buttonPlay.setBounds(100, 270, 400, 65);
        startFrame.add(buttonExit);
        buttonExit.setBounds(180, 380, 230, 55);
        startFrame.add(buttonSettings);
        buttonSettings.setBounds(300, 535, 270, 50);
        startFrame.add(buttonRegister);
        buttonRegister.setBounds(30, 537, 230, 45);

        startFrame.setLayout(new BorderLayout());
        startFrame.getContentPane().add(new DrawPanel());
        startFrame.repaint();

        //Обработка registerFrame
        registerFrame.setSize(300, 340);
        registerFrame.setLayout(null);
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setResizable(false);

        registerFrame.add(checkBoxMenuItem);
        checkBoxMenuItem.setBounds(10, 210, 200, 30);

        registerFrame.add(labelRegisterNick);
        labelRegisterNick.setBounds(10, 10, 300, 20);
        registerFrame.add(textNick);
        textNick.setBounds(10, 40, 220, 35);

        registerFrame.add(labelRegisterAge);
        labelRegisterAge.setBounds(10, 85, 300, 20);
        registerFrame.add(textAge);
        textAge.setBounds(10, 115, 100, 25);

        registerFrame.add(labelRegisterPassword);
        labelRegisterPassword.setBounds(10, 150, 200, 20);
        registerFrame.add(textPassword);
        textPassword.setBounds(10, 180, 250, 20);

        registerFrame.add(buttonEndRegister);
        buttonEndRegister.setBounds(15, 250, 270, 45);
        registerFrame.add(buttonRegisterBack);
        buttonRegisterBack.setBounds(180, 0, 125, 30);

        //Обработка gameFrame
        gameFrame.setSize(widthOfFrame + 3, heightOfFrame + 27);
        gameFrame.setLayout(null);
        gameFrame.add(labelNick);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setResizable(false);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLayout(new BorderLayout());
        gameFrame.getContentPane().add(new DrawPanel());

        //Обработка settingsFrame
        settingsFrame.setSize(600, 630);
        settingsFrame.setLayout(null);
        settingsFrame.setLocationRelativeTo(null);
        settingsFrame.setResizable(false);

        //Обработка фонтов
        labelAccount.setFont(f32);
        labelNick.setFont(f15);

        buttonRight.setFont(f50);
        buttonLeft.setFont(f50);
        buttonPantsSlots.setFont(f25);
        buttonShirtSlots.setFont(f25);
        buttonHandsSlots.setFont(f25);
        labelSlots.setFont(f50);

        buttonPlay.setFont(f45);
        buttonExit.setFont(f40);
        buttonSettings.setFont(f35);
        buttonRegister.setFont(f27);

        buttonRegisterBack.setFont(f20);
        checkBoxMenuItem.setFont(f20);
        buttonEndRegister.setFont(f30);
        labelRegisterNick.setFont(f20);
        textNick.setFont(f25);
        labelRegisterAge.setFont(f20);
        textAge.setFont(f20);
        labelRegisterPassword.setFont(f20);
        textPassword.setFont(f20);
    }
}
