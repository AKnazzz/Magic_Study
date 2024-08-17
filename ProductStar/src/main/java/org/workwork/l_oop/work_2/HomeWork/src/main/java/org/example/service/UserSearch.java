package org.example.service;

import org.example.api.SearchNumber;
import org.example.drow.DrawAdminFilmsMeny;
import org.example.drow.DrawAdminUsersMeny;
import org.example.drow.DrawMenyInlet;
import org.example.drow.DrawMenyUsers;

public class UserSearch implements SearchNumber {
    public void userSearch() {
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
                new AllFilm().allFilm();
                new DrawMenyUsers().drawMeny();
                break;
            case 2:
                new DrawMenyInlet().drawMeny();
                break;
            default:
                break;
        }
    }
}
