package org.example.service;

import org.example.storage.StorageFilms;
import org.example.storage.StorageUsers;

public class AllUser {
    public void allUser() {
        for (int i = 0; i < StorageUsers.getUsers().size(); i++){
            System.out.println(StorageUsers.getUsers().get(i)+"\n");
        }
    }
}
