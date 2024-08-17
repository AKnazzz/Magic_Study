package org.example.service;

import org.example.api.SearchNumber;
import org.example.drow.DrawAdminFilmsMeny;
import org.example.drow.DrawAdminUsersMeny;
import org.example.drow.DrawMenyInlet;

public class AdminSearch implements SearchNumber {

    public void adminSearch() {
        ScanFromCmd scanner = new ScanFromCmd();
        String input = scanner.scanFromCmd();
        try {
            int number = Integer.parseInt(input);
            searchNumber(number);
        } catch (NumberFormatException e) {
            System.out.println(" ");
        }
    }

    @Override
    public void searchNumber(int number) {
        switch (number) {
            case 1:
                new DrawAdminFilmsMeny().drawMeny();
                break;
            case 2:
                new DrawAdminUsersMeny().drawAdminUsers();
                break;
            case 3:
                System.out.println("Выход........");
                new DrawMenyInlet().drawMeny();
            default:
                break;
        }

    }


}
