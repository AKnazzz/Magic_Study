package org.workwork.a_java_base.homework_a3.work_6;

import java.util.Arrays;

public class Workshop {
    public static void main(String[] args) {
        Friend[] friends = {
                new Friend("Dima",20,true,0),
                new Friend("Sasha",21,false,2.2f),
                new Friend("Diana",21,true,40),
                new Friend("Kirill",21,true,20.8f)
        };
        //System.out.println(Arrays.toString(friends));
        for(Friend person:friends){
            System.out.println(person);
        }
    }
}

class Friend{
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
        return "Friend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isFriendFromSchool=" + isFriendFromSchool +
                ", hoursSpentTogetherLastWeek=" + hoursSpentTogetherLastWeek +
                '}';
    }
}