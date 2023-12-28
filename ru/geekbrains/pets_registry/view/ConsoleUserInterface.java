package ru.geekbrains.pets_registry.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import ru.geekbrains.pets_registry.presenter.Presenter;

public class ConsoleUserInterface implements UserInterface {
    
    private Presenter presenter;

    private ActionMenu actionMenu;

    private Scanner scanner;

    private boolean isRunning;

    final private String inputError = "Данные введены неверно";

    public ConsoleUserInterface() {
        presenter = new Presenter(this);
        actionMenu = new ActionMenu(this);
        scanner = new Scanner(System.in);
        isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning) {
            print("Введите действие");
            printActions();
            performAction();
        }
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    private void printActions() {
        print(actionMenu.getActions());
    }

    private void performAction() {
        String action = scanner.nextLine().toLowerCase();
        print("");
        if (!actionMenu.performAction(action)) {
            print("Действие введено неверно.\n");
        }
    }

    public void printPetsList() {
        presenter.printPetsList();
    }

    public void addPetToRegistry() {
        print("Введите вид домашнего животного: 'dog', 'cat' или 'hamster'");
        String type = scanner.nextLine();
        if (!(type.equals("dog") || type.equals("cat") ||
            type.equals("hamster"))) {
                print(String.format("%s.", inputError));
                return;
            }
        
        print("Введите кличку домашнего животного.");
        String name = scanner.nextLine();

        print("Введите дату рождения домашнего животного в формате " +
              "'ДД-ММ-ГГГГ'.");
        String birthDate = scanner.nextLine();
        String [] date = birthDate.split("-");
        int dayOfMonth = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        if (year > LocalDate.now().getYear()) {
            print(String.format("%s.", inputError));
            return;
        }
        Calendar calendar = new GregorianCalendar(year, month, dayOfMonth);
        calendar.setLenient(false);
        try {
            calendar.set(year, month -1, dayOfMonth);
            calendar.getTime();
        } catch (IllegalArgumentException illegalArgumentException) {
            print(String.format("%s.", inputError));
            return;
        }

        print("Введите команды домашнего животного через пробел.");
        ArrayList<String> commands = new ArrayList<String>(Arrays.asList(scanner.nextLine().split(" ")));
        presenter.addPetToRegistry(name, type,
                                   LocalDate.of(year, month, dayOfMonth),
                                   commands);
    }

    public void addCommandToPet() {
        print("Введите идентификатор домашнего животного.");
        long identifier = Long.parseLong(scanner.nextLine());
        print("Введите команду для добавления домашнему животному");
        String command = scanner.nextLine();
        presenter.addCommandToPet(identifier, command);
    }

    public void countPets() {
        presenter.countPets();
    }

    public void exit() {
        isRunning = false;
        scanner.close();
    }

}
