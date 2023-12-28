package ru.geekbrains.pets_registry;

import ru.geekbrains.pets_registry.view.ConsoleUserInterface;
import ru.geekbrains.pets_registry.view.UserInterface;

public class Main {
    
    public static void main(String[] args) {

        UserInterface userInterface = new ConsoleUserInterface();
        userInterface.run();

    }

}
