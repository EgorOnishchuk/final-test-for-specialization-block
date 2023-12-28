package ru.geekbrains.pets_registry.presenter;

import java.time.LocalDate;
import java.util.ArrayList;

import ru.geekbrains.pets_registry.model.Service;
import ru.geekbrains.pets_registry.view.UserInterface;

public class Presenter {

    private UserInterface userInterface;

    private Service service;

    public Presenter(UserInterface userInterface) {
        this.userInterface = userInterface;
        service = new Service();
    }

    public void printPetsList() {
        String petsList = service.createPetsList();
        userInterface.print(petsList);
    }

    public void addPetToRegistry(String name, String type,
                                 LocalDate birthDate,
                                 ArrayList<String> commands) {
        if (service.addPetToRegistry(name, type, birthDate, commands)) {
            userInterface.print("Домашнее животное добавлено в реестр.");
        } else {
            userInterface.print("Домашнее животное уже существует в реестре.");
        }
    }

    public void addCommandToPet(long identifier, String command) {
        if (service.addCommandToPet(identifier, command)) {
            userInterface.print("Команда добавлена домашнему животному.");
        } else {
            userInterface.print("Домашнего животного не существует в реестре.");
        }
    }

    public void countPets() {
        String petsNum = service.countPets();
        userInterface.print(petsNum);
    }

}
