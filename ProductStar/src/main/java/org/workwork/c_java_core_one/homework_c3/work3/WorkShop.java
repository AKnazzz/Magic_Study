package org.workwork.c_java_core_one.homework_c3.work3;

import java.util.Arrays;

public class WorkShop {
    public static void main(String[] args) {
        Friend[] myFriends = new Friend[3];
        myFriends[0] = new Friend("Вася", Integer.parseInt("18"), Boolean.parseBoolean("true"), Float.parseFloat("5.2"),
                "Мужской");
        myFriends[1] = new Friend("Саша", Integer.parseInt("30"), Boolean.parseBoolean("false"),
                Float.parseFloat("5.2"), "Женский");
        myFriends[2] = new Friend("Женя", Integer.parseInt("24"), Boolean.parseBoolean("true"), Float.parseFloat("5.2"),
                "Мужской");

        System.out.println(Arrays.toString(myFriends));
    }
}

class Friend {
    String name;
    int age;
    boolean isFriendFromSchool;
    float hoursSpentTogetherLastWeek;
    String theGender;

    public Friend(String name, int age, boolean isFriendFromSchool, float hoursSpentTogetherLastWeek,
            String theGender) {
        this.name = name;
        this.age = age;
        this.isFriendFromSchool = isFriendFromSchool;
        this.hoursSpentTogetherLastWeek = hoursSpentTogetherLastWeek;
        this.theGender = theGender;
    }

    public String toString() {
        return "Friend{" + "name='" + name + '\'' +
                ",age=" + age +
                ",isFriendFromSchool=" + isFriendFromSchool +
                ",hoursSpentTogetherLastWeek=" + hoursSpentTogetherLastWeek +
                ",theGender=" + theGender +
                '}' + "\n";

    }
}