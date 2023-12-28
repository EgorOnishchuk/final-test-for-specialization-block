package ru.geekbrains.pets_registry.view;

import java.util.ArrayList;
import java.util.Arrays;

import ru.geekbrains.pets_registry.view.actions.Action;
import ru.geekbrains.pets_registry.view.actions.AddCommandToPet;
import ru.geekbrains.pets_registry.view.actions.AddPetToRegistry;
import ru.geekbrains.pets_registry.view.actions.CountPets;
import ru.geekbrains.pets_registry.view.actions.Exit;
import ru.geekbrains.pets_registry.view.actions.PrintPetsList;

public class ActionMenu {
    
    private ArrayList<Action> actions;

    public ActionMenu(ConsoleUserInterface consoleUserInterface) {
        actions = new ArrayList<>(Arrays.asList(new PrintPetsList(consoleUserInterface),
                                                new AddPetToRegistry(consoleUserInterface),
                                                new AddCommandToPet(consoleUserInterface),
                                                new CountPets(consoleUserInterface),
                                                new Exit(consoleUserInterface)));
    }

    public String getActions() {
        StringBuilder userActions = new StringBuilder();
        for (Action action : actions) {
            userActions.append(String.format("'%s' %s\n", action.getName(),
                                             action.getDescription()));
        }
        return userActions.toString();
    }

    public boolean performAction(String userAction) {
        for (Action action : actions) {
            if (action.getName().equals(userAction)) {
                action.perform();
                return true;
            }
        }
        return false;
    }

}
