package org.workwork.a_java_base.homework_a3.work_1;

import java.util.Arrays;


public class WorkShop {


    public static void main(String[] args) {
        Friend[] friends = {
                new Friend("Вася", Integer.parseInt("18"), true, 10),
                new Friend("Катя", Integer.parseInt("19"), true, 1),
                new Friend("Дима", Integer.parseInt("20"), true, 23),
                new Friend("Саша", Integer.parseInt("20"), false, 12),
                new Friend("Мария", Integer.parseInt("20"), false, 5)
        };


        System.out.println("My friends: " + Arrays.toString(friends));
    }
}


class Friend {


    boolean isFriendFromSchool;
    float hoursSpentTogetherLastWeek;
    private String name;
    private int age;


    public Friend(String name,
            int age,
            boolean isFriendFromSchool,
            float hoursSpentTogetherLastWeek) {


        this.name = name;
        this.age = age;
        this.isFriendFromSchool = isFriendFromSchool;
        this.hoursSpentTogetherLastWeek = hoursSpentTogetherLastWeek;
    }


    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isFriendFromSchool=" + isFriendFromSchool +
                ", hoursSpentTogetherLastWeek=" + hoursSpentTogetherLastWeek +
                '}';
    }
}

