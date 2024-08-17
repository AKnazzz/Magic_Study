package org.example.model;

public class User {
    private String name;
    private int age;
    private String gender;
    private Role role;
    private String password;

    public User(String name, int age, String gender, Role role, String password) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.role = role;
        this.password = password;
    }

    public User(){}

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                '}';
    }
}
