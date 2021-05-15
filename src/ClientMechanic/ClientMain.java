package ClientMechanic; //Пакет класса.

import static Libraries.Methods.*;

public class ClientMain { //Класс ClientMain, в котором находится метод main, с которого начинается программа.
    ClientMain() {
        printNote("Creating an object of class Main", NOTE_TYPE_DONE);
    }

    public static void main(String[] args) { //Метод main(String[] args).
        printNote("Starting program", NOTE_TYPE_PROCESS);
        new ClientGUIMechanic().preparationGUI();
        printNote("Staring program", NOTE_TYPE_DONE);
    }
}
