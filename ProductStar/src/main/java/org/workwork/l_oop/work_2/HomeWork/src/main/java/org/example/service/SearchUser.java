package org.example.service;

import org.example.storage.StorageUsers;

public class SearchUser {

    public boolean searchUser(String string) {
        String[] word = string.split(" ");
        System.out.println(string);
        if (word.length == 0) {
            return false;
        }
        return StorageUsers
                .getUsers()
                .stream()
                .anyMatch(user -> user.getName().equals(word[0]));
    }
}

