package org.workwork.c_java_core_one.homework_c2.theory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> surnames = new ArrayList<>();
        surnames.add("Smith");
        surnames.add("Johnson");
        surnames.add("Williams");
        surnames.add("Smith");

        System.out.println("surnames = " + surnames);

        // indexOf()
        System.out.println("surnames.indexOf(\"Williams\") = " + surnames.indexOf("Williams"));

        System.out.println("surname of index 1 " + surnames.get(1));

        // ADD METHOD and SET METHOD
        surnames.add(1, "Trump");
        System.out.println("surnames = " + surnames);

        surnames.set(1, "Bidon");
        System.out.println("surnames = " + surnames);

        System.out.println(surnames.contains("Bidon"));
        System.out.println(surnames.contains("Ivanov"));

        System.out.println(surnames.size());
        //surnames.clear();
        System.out.println(surnames.isEmpty());

        HashSet<String> surnamesSet = new HashSet<>();
        System.out.println("surnamesSet = " + surnamesSet);
        surnamesSet.addAll(surnames);
        System.out.println("surnamesSet = " + surnamesSet);

        surnamesSet.add("Ivanov");
        System.out.println("surnamesSet = " + surnamesSet);

        surnamesSet.remove("Ivanov");
        System.out.println("surnamesSet = " + surnamesSet);
        System.out.println(surnamesSet.size());
        // surnamesSet.clear();
        System.out.println(surnamesSet.isEmpty());

        HashSet<String> surnamesSet2 = new HashSet<>();
        surnamesSet2.add("Ivanov");

        System.out.println(surnamesSet.equals(surnamesSet2));

        surnamesSet2.clear();
        surnamesSet2.add("Johnson");
        surnamesSet2.add("Williams");
        surnamesSet2.add("Smith");
        surnamesSet2.add("Bidon");

        System.out.println(surnamesSet.equals(surnamesSet2));


        HashMap<String, Integer> nameAndAge = new HashMap<>();
        nameAndAge.put("Ivan", 20);
        nameAndAge.put("John", 21);

        System.out.println("nameAndAge = " + nameAndAge);
        System.out.println(nameAndAge.get("Ivan"));
        System.out.println(nameAndAge.get("Dmitry"));
        System.out.println(nameAndAge.size());
        System.out.println(nameAndAge.isEmpty());

        nameAndAge.put("Alex", 20);
        System.out.println("nameAndAge = " + nameAndAge);
    }
}
