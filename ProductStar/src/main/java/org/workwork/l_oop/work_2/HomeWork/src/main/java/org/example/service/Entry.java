package org.example.service;

import org.example.api.Scann;
import org.example.drow.DrawMenyAdmin;
import org.example.drow.DrawMenyInlet;
import org.example.drow.DrawMenyUsers;

import java.util.Scanner;

public class Entry implements Scann {

    private UserOrAdmin userOrAdmin = new UserOrAdmin();
    private DrawMenyAdmin drawMenyAdmin = new DrawMenyAdmin();
    private DrawMenyUsers drawMenyUsers = new DrawMenyUsers();
    private SearchUser searchUser = new SearchUser();

    public void entry() {
        String x = scann();

        if (searchUser.searchUser(x)) {
            switch (userOrAdmin.userOrAdmin(x)) {
                case "ADMIN":
                    drawMenyAdmin.drawMenyAdmin();
                    break;
                case "USER":
                    drawMenyUsers.drawMeny();
                    break;
                default:
                    System.out.println("\nНеверный пароль\n");
                    new DrawMenyInlet().drawMeny();
                    break;
            }
        } else {
            System.out.println("\nНеверный логин или пароль\n");
            new DrawMenyInlet().drawMeny();
        }
    }

    @Override
    public String scann() {
        System.out.print("Логин: ");
        String login = scanner.nextLine().trim();
        System.out.print("Пароль: ");
        String password = scanner.nextLine().trim();
        return login + " " + password;
    }
}
