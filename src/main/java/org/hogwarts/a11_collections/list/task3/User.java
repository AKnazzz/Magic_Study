package org.hogwarts.a11_collections.list.task3;

import java.util.HashSet;
import java.util.Set;

/**
 * 1. В том же классе пользователя создать конструктор, который принимает в качестве параметров значения для всех полей класса.
 *
 * 2. В качестве статических констант в классе объявить 2 сета:
 *
 * VALID_JOBS— сразу инициализировать его, содержащим 3 строки: “Google”, “Uber”, “Amazon”;
 *
 * VALID_ADDRESSES— сразу инициализировать его, содержащим 3 строки: “London”, “New York”, “Amsterdam”.
 *
 * 3. В конструкторе провести валидацию этих параметров по следующим правилам:
 *
 * имя не может быть пустым;
 *
 * возраст не может быть меньше 18;
 *
 * место работы должно содержаться во множестве VALID_JOBS;
 *
 * адрес должен содержаться во множестве VALID_ADDRESSES.
 *
 * Если хотя бы одно из условий не выполняется, то выбросить исключение IllegalArgumentException. Иначе сохранить переданные значения в поля.
 */
public class User {
    private static final Set<String> VALID_JOBS = new HashSet<>();
    private static final Set<String> VALID_ADDRESSES = new HashSet<>();

    static {
        VALID_JOBS.add("Google");
        VALID_JOBS.add("Uber");
        VALID_JOBS.add("Amazon");

        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("New York");
        VALID_ADDRESSES.add("Amsterdam");
    }

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name.isEmpty() || age < 18 || !VALID_JOBS.contains(job) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid user information provided.");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

// геттеры и сеттеры
    // ...

    public static Set<String> getValidJobs() {
        return VALID_JOBS;
    }

    public static Set<String> getValidAddresses() {
        return VALID_ADDRESSES;
    }
}
