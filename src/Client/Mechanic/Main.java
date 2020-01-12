package Client.Mechanic; //Пакет класса.

public class Main { //Класс Main, в котором на ходится метод main и с которого начинается программа.
    public static void main(String[] args) { //Метод main(String[] args).
        System.out.println("Starting...");
        GameMechanic gameMechanic = new GameMechanic();
        gameMechanic.preparationGUIAndWorld(); //Вызов метода preparationGUIAndWorld() из объекта класса GameMechanic.
    }
}
