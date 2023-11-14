package org.hogwarts.vzlomshik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

public class GoodVersion {

    public static void main(String[] args) {


    }

    // метод прочтения файла и записи его в мапу для логов
    public static HashMap<String, Integer> fileServerRead(File file) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            HashMap<String, Integer> ips = new HashMap<>();
            while (bufferedReader.ready()) {
                String ip = bufferedReader.readLine().split(":")[0];
                ips.put(ip, ips.getOrDefault(ip, 0) + 1);
            }
            System.out.println("Файл " + file + " прочитан.");
            return ips; // возвращаем мапу ip ---> кол-во вызовов
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // метод прочтения файла и записи его в мапу для юзеров
    public static TreeMap<Integer, User> fileUsersRead(File file) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            TreeMap<Integer, User> users = new TreeMap<>(); //  id ---> User
            bufferedReader.readLine();
            while (bufferedReader.ready()) {
                String[] dataUser = bufferedReader.readLine().split(";");
                String ip = dataUser[0];
                int id = Integer.parseInt(dataUser[1]);
                String address = dataUser[3];
                String[] fioUser = dataUser[2].split(" ");
                String surname = fioUser[0];
                String name = fioUser[1];
                String secondName = fioUser[2];
                if (users.containsKey(id)) {
                    users.get(id).getIps().add(ip);
                } else {
                    User user = new User(id, surname, name, secondName, address);
                    user.getIps().add(ip);
                    users.put(id, user); // возвращаем мапу id ---> User
                }
            }
            System.out.println("Файл " + file + " прочитан.");
            return users;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
