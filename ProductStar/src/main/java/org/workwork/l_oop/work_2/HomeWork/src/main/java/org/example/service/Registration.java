package org.example.service;

import org.example.api.Scann;
import org.example.drow.DrawMenyInlet;
import org.example.model.Role;
import org.example.model.User;
import org.example.storage.StorageUsers;

public class Registration implements Scann {

    public void registration(){

        System.out.println(scann());
        new DrawMenyInlet().drawMeny();
    }

    @Override
    public String scann() {
        System.out.print("Логин: ");
        String login = scanner.nextLine().trim();
        if (isLoginTaken(login)) {
            return "Логин уже существует. Попробуйте другой логин.";
        }

        System.out.print("Пароль: ");
        String password = scanner.nextLine().trim();
        System.out.print("Возраст: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return "Некорректный возраст. Попробуйте снова.";
        }
        System.out.print("Пол: ");
        String gender = scanner.nextLine().trim();
        System.out.print("Роль: ");
        Role role;
        try {
            role = Role.valueOf(scanner.nextLine().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return "Некорректная роль. Попробуйте снова.";
        }
        User user = new User(login, age, gender, role, password);
        StorageUsers.getUsers().add(user);

        return "Пользователь создан";
    }

    private boolean isLoginTaken(String login) {
        for (User user : StorageUsers.getUsers()) {
            if (user.getName().equalsIgnoreCase(login)) {
                return true;
            }
        }
        return false;
    }
}