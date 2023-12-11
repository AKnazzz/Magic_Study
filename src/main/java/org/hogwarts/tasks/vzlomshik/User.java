package org.hogwarts.tasks.vzlomshik;

import java.util.HashSet;
import java.util.Set;

public class User { // с полями: id, фамилия, имя, отчество, адрес проживания.

    private int id;
    private String surname;
    private String name;
    private String secondName;
    private String address;

    private Set<String> ips = new HashSet<>();

    public User(int id, String surname, String name, String secondName, String address) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.address = address;
    }

    public User(String surname, String name, String secondName, String address) {
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<String> getIps() {
        return ips;
    }

    public void setIps(Set<String> ips) {
        this.ips = ips;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
