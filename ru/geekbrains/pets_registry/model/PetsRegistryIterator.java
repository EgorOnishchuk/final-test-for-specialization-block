package ru.geekbrains.pets_registry.model;

import java.util.ArrayList;
import java.util.Iterator;

public class PetsRegistryIterator<Pet> implements Iterator<Pet> {
    
    private int index;
    private ArrayList<Pet> pets;

    public PetsRegistryIterator(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public boolean hasNext() {
        return index < pets.size();
    }

    @Override
    public Pet next() {
        return pets.get(index++);
    }

}
