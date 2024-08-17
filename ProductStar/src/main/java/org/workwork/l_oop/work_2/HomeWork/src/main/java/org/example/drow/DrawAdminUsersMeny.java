package org.example.drow;

import org.example.api.DrawMeny;
import org.example.api.Scann;
import org.example.service.AllUser;

import static org.example.api.Scann.scanner;

public class DrawAdminUsersMeny implements DrawMeny {
    @Override
    public void drawMeny() {
        System.out.println("Меню\n" +
                "1.Все Пользователи\n" +
                "2.Назад\n");
    }
    public void drawAdminUsers() {
        drawMeny();
        int number = scanner.nextInt();

        switch (number){
            case 1:
                new AllUser().allUser();
                new DrawAdminUsersMeny().drawAdminUsers();
                break;
            case 2:
                new DrawMenyAdmin().drawMenyAdmin();
                break;
                default:
                    System.out.println(" ");
        }
    }

}
