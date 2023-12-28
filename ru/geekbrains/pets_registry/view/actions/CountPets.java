package ru.geekbrains.pets_registry.view.actions;

import ru.geekbrains.pets_registry.view.ConsoleUserInterface;

public class CountPets extends Action {
    
    public CountPets(ConsoleUserInterface consoleUserInterface) {
        super(consoleUserInterface);
        name = "count";
        description = "для подсчёта количества домашних животных";
    }

    public void perform() {
        consoleUserInterface.countPets();
    }

}
