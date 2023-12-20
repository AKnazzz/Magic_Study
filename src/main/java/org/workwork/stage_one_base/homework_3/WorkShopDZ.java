package org.workwork.stage_one_base.homework_3;

import java.util.Arrays;

public class WorkShopDZ {

    public static void main(String[] args) {

        Friend [] friends =
                {new Friend("Вася", 18, "man", true),
                        new Friend("Петя", 20, "man", false),
                        new Friend("Катя", 25, "woman", false),
                        new Friend("Катя", 47, "woman", false)}
                ;

        System.out.println(" My Friends: " + Arrays.toString(friends));

    }
}

class Friend {
    private String name;
    private int age;
    private String gender;
    private boolean crank;

    public Friend(String name, int age, String gender, boolean b) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.crank = true;
    }

    @Override
    public String toString() {
        return "Friend{" + "name='" + name + '\'' + ", age=" + age + ", gender='" + gender + '\'' + ", crank=" + crank + '}';
    }
}