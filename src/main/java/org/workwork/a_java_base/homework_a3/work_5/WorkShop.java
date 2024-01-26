package org.workwork.a_java_base.homework_a3.work_5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WorkShop {
    public static void main(String[] args) throws InterruptedException {
        Friend[] friends = {
                new Friend("John", 32, Sex.MALE, true, 2),
                new Friend("Oleg", 16, Sex.MALE, false, 0),
                null, null
        };
        friends[2] = new Friend("Katya", 31, Sex.FEMALE, true, 5);
        friends[3] = new Friend("Sveta", 27, Sex.MALE, false, 0);

        System.out.println(Arrays.stream(friends).map(String::valueOf).collect(Collectors.joining("\n")));
    }

}

enum Sex {
    MALE,
    FEMALE,
}

/**
 * Friend
 */
class Friend {
    private String name;
    private int age;
    private boolean isFriendFromSchool;
    private float hoursSpentTogetherLastWeek;
    private Sex sex;

    public Friend(String name, int age, Sex sex, boolean isFriendFromSchool, float hoursSpentTogetherLastWeek) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.isFriendFromSchool = isFriendFromSchool;
        this.hoursSpentTogetherLastWeek = hoursSpentTogetherLastWeek;
    }

    @Override
    public String toString() {
        return "Friend {name: " + name + ", age: " + age + ", sex: " + sex + ", isFriendFromSchool: "
                + isFriendFromSchool + ", hoursSpentTogetherLastWeek: " + hoursSpentTogetherLastWeek + "}";
    }
}