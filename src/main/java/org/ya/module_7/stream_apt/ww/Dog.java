package org.ya.module_7.stream_apt.ww;

public class Dog implements Comparable<String> {
    String name;
    int age;


    @Override
    public int compareTo(String o) {
        return name.compareTo(o);
    }
}
