package org.workwork.a_java_base.homework_a3.work_7;

import java.util.Arrays;


public class WorkShop {
    public static void main(String[] args) {
        Friend[] friends = new Friend[3];
        friends[0] = new Friend("Vasy ",(18));
        friends[1] = new Friend("Sereja",(13));
        friends[2] =  new Friend("Alena",(17));


        System.out.println("My friends:" + Arrays.toString(friends));

        boolean Vasy = true;
        boolean Sereja = false;
        boolean Alena = false;
        if (Sereja) {
            System.out.println("Sereja is friend from school");

        } else if (Vasy) {
            System.out.println("Vasy is friend from school");

        } else if (Alena) {
            System.out.println("Alena is friend from school");

        }
        // float
        float a = 3;
        float b = 2;
        float time = 3 * 2; {
            System.out.println(time + "hours spent together last week");
        }









    }
}

class Friend{

    private String name;
    private int age;

    @java.lang.Override
    public java.lang.String toString() {
        return "Friend{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }

    public Friend(String name, int age) {
        this.name = name;
        this.age = age;

    }
}
