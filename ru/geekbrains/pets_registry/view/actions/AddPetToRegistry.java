package ru.geekbrains.pets_registry.view.actions;

import ru.geekbrains.pets_registry.view.ConsoleUserInterface;

public class AddPetToRegistry extends Action {
    
    public AddPetToRegistry(ConsoleUserInterface consoleUserInterface) {
        super(consoleUserInterface);
        name = "add pet";
        description = "для добавления домашнего животного";
    }

    public void perform() {
        consoleUserInterface.addPetToRegistry();
    }

}
