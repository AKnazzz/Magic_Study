package org.example.service;

import org.example.api.SearchNumber;
import org.example.drow.DrawAdminFilmsMeny;
import org.example.drow.DrawAdminUsersMeny;
import org.example.drow.DrawMenyAdmin;
import org.example.drow.DrawMenyInlet;

public class AdminFilmSearch implements SearchNumber {

    public void adminFilmSearch() {
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
                new AddFilms().addFilms();
                break;
            case 2:
                System.out.println(new AddFilms().removeFilmByName());
                new DrawAdminFilmsMeny().drawMeny();
                break;
            case 3:
                new AllFilm().allFilm();
                new DrawAdminFilmsMeny().drawMeny();
                break;
            case 4:
                new DrawMenyAdmin().drawMenyAdmin();
                break;
            default:
                break;
        }
    }
}
