package ru.geekbrains.pets_registry.view.actions;

import ru.geekbrains.pets_registry.view.ConsoleUserInterface;

public abstract class Action {
    
    String name;

    String description;

    ConsoleUserInterface consoleUserInterface;

    public Action(ConsoleUserInterface consoleUserInterface) {
        this.consoleUserInterface = consoleUserInterface;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract void perform();

}
