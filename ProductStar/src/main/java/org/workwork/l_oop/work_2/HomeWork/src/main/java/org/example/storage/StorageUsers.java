package org.example.storage;

import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class StorageUsers {

    private static List<User> users = new ArrayList<>();
    public static List<User> getUsers(){
        return users;
    }

}
