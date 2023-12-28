package ru.geekbrains.pets_registry.model;

import java.time.LocalDate;
import java.util.ArrayList;

import ru.geekbrains.pets_registry.model.pets.Cat;
import ru.geekbrains.pets_registry.model.pets.Dog;
import ru.geekbrains.pets_registry.model.pets.Hamster;
import ru.geekbrains.pets_registry.model.pets.Pet;

public class Service {

    private long petIdentifier;

    private PetsRegistry petsRegistry;

    public Service() {
        petIdentifier = 1;
        petsRegistry = new PetsRegistry();
    }

    public String createPetsList() {
        if (petsRegistry.isEmpty()) {
            return "Реестр домашних животных пуст.\n";
        }
        StringBuilder petsList = new StringBuilder();
        for (Pet pet : petsRegistry) {
            petsList.append(String.format("%s\n", pet));
        }
        return petsList.toString();
    }
    
    public boolean addPetToRegistry (String name, String type,
                                     LocalDate birthDate,
                                     ArrayList<String> commands) {
        if (type.equals("dog")) {
            Dog pet = new Dog(petIdentifier++, name, birthDate, commands);
            if (petsRegistry.add(pet)) {
                return true;
            }
        } else if (type.equals("cat")) {
            Cat pet = new Cat(petIdentifier++, name, birthDate, commands);
            if (petsRegistry.add(pet)) {
                return true;
            }
        } else if (type.equals("hamster")) {
            Hamster pet = new Hamster(petIdentifier++, name, birthDate, commands);
            if (petsRegistry.add(pet)) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    public boolean addCommandToPet (long identifier, String command) {
        if (!petsRegistry.isContain(identifier)) {
            return false;
        }
        petsRegistry.get(identifier).addCommand(command);
        return true;
    }

    public String countPets() {
        return String.format("Количество домашних животных - %d\n", petsRegistry.getEntries());
    }
}
