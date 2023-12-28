package ru.geekbrains.pets_registry.model.pets;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cat extends Pet {
    
    public Cat(long identifier, String name, LocalDate birthDate,
               ArrayList<String> commands) {
        super(identifier, name, birthDate, commands);
        type = "кошка";
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s, %s", identifier, type, name,
                             birthDate, commands);
    }

    public long getIdentifier() {
        return identifier;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

}
