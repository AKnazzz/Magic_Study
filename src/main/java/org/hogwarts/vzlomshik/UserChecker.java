package org.hogwarts.vzlomshik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class UserChecker {
    public static void main(String[] args) {

        File logs = new File("C:\\Users\\Андрей\\dev\\magic\\Magic\\src\\main\\java\\org\\hogwarts\\vzlomshik\\server.log");
        File users = new File("C:\\Users\\Андрей\\dev\\magic\\Magic\\src\\main\\java\\org\\hogwarts\\vzlomshik\\users.db");

        String ip = mostPopularIp(fileServerRead(logs));
        int count = fileServerRead(logs).get(ip);
        TreeMap<Integer, User> usersDb =fileUsersRead(users);
        HashMap<Integer, Set<String>> idIps = fileUsersReadAndFindAddresses(users);

        Integer userId = findIdInSetByIp(idIps,ip);
        User user = usersDb.get(userId);
        System.out.println("Предполагаемый злоумышленник: ");
        System.out.println("ФИО: " + user.getSurname() + " " + user.getName() + " " + user.getSecondName());
        System.out.println("Адрес: " + user.getAddress());
        System.out.println("Количество входов: " + count);

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

    // метод поиска максимального встречающегося адреса
    public static String mostPopularIp(HashMap<String, Integer> ips) {

        Integer maxValue = Collections.max(ips.values()); // ---> наибольшее кол-во вызовов
        String maxKey = "";
        for (Map.Entry<String, Integer> entry : ips.entrySet()) {
            if (entry.getValue() == maxValue) {
                maxKey = entry.getKey();
                break;
            }
        }
        System.out.println("Искомый адрес: " + maxKey);
        return maxKey;                  // ---> получаем искомый Ip адрес
    }


    // метод прочтения файла и записи его в мапу для юзеров
    public static TreeMap<Integer, User> fileUsersRead(File file) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            TreeMap<Integer, User> users = new TreeMap<>(); //  id ---> User
            bufferedReader.readLine();
            while (bufferedReader.ready()) {
                String[] dataUser = bufferedReader.readLine().split(";");
                int id = Integer.parseInt(dataUser[1]);
                String address = dataUser[3];
                String[] fioUser = dataUser[2].split(" ");
                String surname = fioUser[0];
                String name = fioUser[1];
                String secondName = fioUser[2];
                User user = new User(id, surname, name, secondName, address);
                users.put(id, user); // возвращаем мапу id ---> User
            }
            System.out.println("Файл " + file + " прочитан.");
            return users;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // метод прочтения файла и записи его в мапу для юзеров
    public static HashMap<Integer, Set<String>> fileUsersReadAndFindAddresses (File file) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            HashMap<Integer, Set<String>> idAndIps = new HashMap<>(); //  id ---> Set <ips>
            bufferedReader.readLine();
            while (bufferedReader.ready()) {
                String[] dataUser = bufferedReader.readLine().split(";");
                int id = Integer.parseInt(dataUser[1]);
                String address = dataUser[0];

                if (idAndIps.containsKey(id)) {
                    if (idAndIps.get(id).contains(address)) {
                        idAndIps.get(id).add(address);
                    } else {
                        Set<String> addresses = idAndIps.get(id);
                        addresses.add(address);
                    }
                } else {
                    Set<String> addresses = new HashSet<>();
                    addresses.add(address);
                    idAndIps.put(id, addresses);
                }
            }
            System.out.println("Файл " + file + " прочитан. Получена связка ID <--> IP.");
            return idAndIps;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Integer findIdInSetByIp (HashMap<Integer, Set<String>> idIps, String ip){
        Integer targetKey = idIps.entrySet().stream()
                .filter(entry -> entry.getValue().contains(ip))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        return targetKey;
    }

}
