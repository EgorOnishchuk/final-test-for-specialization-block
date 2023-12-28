package ru.geekbrains.pets_registry.model;

import java.util.ArrayList;
import java.util.Iterator;

import ru.geekbrains.pets_registry.model.pets.Pet;

public class PetsRegistry implements Iterable<Pet> {

    private ArrayList<Pet> pets;

    public PetsRegistry() {
        this.pets = new ArrayList<>();
    }

    public boolean add(Pet pet) {
        if (pets.contains(pet)) {
            return false;
        }
        pets.add(pet);
        return true;
    }

    public Pet get(long identifier) {
        for (Pet pet : pets) {
            if (pet.getIdentifier() == identifier) {
                return pet;
            }
        }
        return null;
    }

    public int getEntries() {
        return pets.size();
    }

    public boolean isContain(long identifier) {
        for (Pet pet : pets) {
            if (pet.getIdentifier() == identifier) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return pets.isEmpty();
    }

    @Override
    public Iterator<Pet> iterator() {
        return new PetsRegistryIterator<Pet>(pets);
    }
    
}
