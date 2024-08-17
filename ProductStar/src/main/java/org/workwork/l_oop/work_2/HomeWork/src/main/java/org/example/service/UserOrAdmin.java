package org.example.service;

import org.example.model.User;
import org.example.storage.StorageUsers;

public class UserOrAdmin {

    public String userOrAdmin(String x) {
        String[] words = x.split(" ");


        User user = findUserByLogin(words[0]);

        if (user != null && user.getPassword().equals(words[1])) {
            return user.getRole().name();
        }
        return "";
    }

    private User findUserByLogin(String login) {
        for (User user : StorageUsers.getUsers()) {
            if (user.getName().equals(login)) {
                return user;
            }
        }
        return null;
    }
}
