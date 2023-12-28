package ru.geekbrains.pets_registry.view.actions;

import ru.geekbrains.pets_registry.view.ConsoleUserInterface;

public class Exit extends Action{
    
    public Exit(ConsoleUserInterface consoleUserInterface) {
        super(consoleUserInterface);
        name = "exit";
        description = "для выхода из программы";
    }

    public void perform() {
        consoleUserInterface.exit();
    }

}
