package org.workwork.a_java_base.homework_a3.work_4;

import java.util.Arrays;

public class WorkShop {
    public static void main(String[] args) {
        Friend[] friends = {
                new Friend("Вася", 18 , true, 2.4f),
                new Friend("Катя", 19 , true, 8f),
                new Friend("Дима", 20 , true, 2.5f),
                new Friend("Саша", 20 , false, 1.0f)
        };
        System.out.println("My friends: " + Arrays.toString(friends));
    }
}

class Friend {
    private String name;
    private int age;
    private boolean isFriendFromSchool;
    private float hoursSpentTogetherLastWeek;

    public Friend(String name, int age, boolean isFriendFromSchool, float hoursSpentTogetherLastWeek) {
        this.name = name;
        this.age = age;
        this.isFriendFromSchool = isFriendFromSchool;
        this.hoursSpentTogetherLastWeek = hoursSpentTogetherLastWeek;
    }

    @Override
    public String toString() {
        return "\n" + "Friend{" +
                "имя='" + name + '\'' +
                ", возраст=" + age +
                ", друзья со школы=" + (isFriendFromSchool ? "Да":"Нет") +
                ", часы вместе на прошлой неделе=" + hoursSpentTogetherLastWeek +
                '}';
    }
}
