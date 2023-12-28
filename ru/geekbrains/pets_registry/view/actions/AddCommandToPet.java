package ru.geekbrains.pets_registry.view.actions;

import ru.geekbrains.pets_registry.view.ConsoleUserInterface;

public class AddCommandToPet extends Action {

    public AddCommandToPet(ConsoleUserInterface consoleUserInterface) {
        super(consoleUserInterface);
        name = "add command";
        description = "для добавления команды домашнему животному";
    }

    public void perform() {
        consoleUserInterface.addCommandToPet();
    }

}
