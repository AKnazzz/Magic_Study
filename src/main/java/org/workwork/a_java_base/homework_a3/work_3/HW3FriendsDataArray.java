package org.workwork.a_java_base.homework_a3.work_3;

import java.util.Arrays;

public class HW3FriendsDataArray {
    public static void main (String[] args) {
        Friend[] friends = {
                new Friend("Вася", Integer.parseInt("33"), true, true,  10),
                new Friend("Пётр", Integer.parseInt("28"), true, true, 12),
                new Friend("Стелла", Integer.parseInt("35"), false,false,  5),
                new Friend("Андрей", Integer.parseInt("27"), true, true, 8)
        };
        System.out.println("My friends: " + Arrays.toString(friends));
    }
}
class Friend {
    private String name;
    private int age;
    private boolean isFriendFromSchool;
    private int howLongKnowThem;
    private boolean rightHanded;
    public Friend(String name, int age, boolean rightHanded, boolean isFriendFromSchool, int howLongKnowThem) {
        this.name = name;
        this.age = age;
        this.isFriendFromSchool = isFriendFromSchool;
        this.howLongKnowThem = howLongKnowThem;
        this.rightHanded = rightHanded;
    }
    @Override
    public String toString() {
        return "\nFriend: " +
                "name= '" + name + '\'' +
                ", age= " + age + "; right handed - " +  rightHanded + "; know them from school: " + isFriendFromSchool +
                ". I know them " + howLongKnowThem + " years";
    }
}