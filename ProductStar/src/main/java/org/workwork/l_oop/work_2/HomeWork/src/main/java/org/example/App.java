package org.example;

import org.example.drow.DrawMenyInlet;
import org.example.model.Role;
import org.example.model.User;
import org.example.storage.StorageUsers;

public class App {

    App(){
        User admin = new User("123",123,"123", Role.ADMIN,"123");
        User user = new User("456",456,"456", Role.USER,"456");
        StorageUsers.getUsers().add(user);
        StorageUsers.getUsers().add(admin);
        new DrawMenyInlet().drawMeny();
    }
}
