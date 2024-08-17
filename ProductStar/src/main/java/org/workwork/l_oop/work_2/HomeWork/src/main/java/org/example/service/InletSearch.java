package org.example.service;

import org.example.api.SearchNumber;

public class InletSearch implements SearchNumber {

    Entry entry = new Entry();
    Registration registration = new Registration();

    public void inletSearch() {
        ScanFromCmd scanner = new ScanFromCmd();
        String input = scanner.scanFromCmd();
        try {
            int number = Integer.parseInt(input);
            searchNumber(number);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введено некорректное число.");
        }
    }

    @Override
    public void searchNumber(int number) {
        switch (number) {
            case 1:
                entry.entry();
                break;
            case 2:
                registration.registration();
                break;
            case 3:
                System.out.println("Выход........");
                break;
            default:
                System.out.println("Число не найдено.");
                break;
        }
    }
}