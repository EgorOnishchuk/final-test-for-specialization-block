package ru.geekbrains.pets_registry.model.pets;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Pet {
    
    public Pet(long identifier, String name, LocalDate birthDate,
               ArrayList<String> commands) {
        this.identifier = identifier;
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;        
    }

    long identifier;

    String type;

    String name;

    LocalDate birthDate;

    ArrayList<String> commands;

    public abstract long getIdentifier();

    public abstract void addCommand(String command);

}
