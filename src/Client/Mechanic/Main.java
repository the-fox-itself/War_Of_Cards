package Client.Mechanic; //Пакет класса.

import static Client.Mechanic.SwingPlus.Methods.*;

public class Main { //Класс Main, в котором на ходится метод main и с которого начинается программа.
    Main() {
        printNote("Creating an object of class Main", NOTE_TYPE_DONE);
    }

    public static void main(String[] args) { //Метод main(String[] args).
        printNote("Starting program", NOTE_TYPE_PROCESS);
        ClientGameMechanic clientGameMechanic = new ClientGameMechanic();
        clientGameMechanic.preparationGUI(); //Вызов метода preparationGUI() из объекта класса ClientGameMechanic.
        printNote("Staring program", NOTE_TYPE_DONE);
    }
}
