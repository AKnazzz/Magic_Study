package org.workwork.d_java_core_one.homework_d2.work_1.ArrayListString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> name = new ArrayList<>();
        name.add("Ира");
        name.add("Яна");
        name.add("Ира");
        name.add("Света");
        name.add("Лена");
        name.add("Ира");

        Set<String> uniqueName = new HashSet<>(name);
        name.clear();
        name.addAll(uniqueName);

        System.out.println("Name: " + name);
    }
}