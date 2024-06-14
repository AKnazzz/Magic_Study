package org.workwork.c_java_core_one.homework_c2.work_1.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer, String> originalMap = new HashMap<>();
        originalMap.put(1, "One");
        originalMap.put(2, "Two");
        originalMap.put(3, "Three");

        HashMap<String, Integer> swappedMap = swapKeysAndValues(originalMap);
        System.out.println("Swapped Map: " + swappedMap);
    }

    public static HashMap<String, Integer> swapKeysAndValues(HashMap<Integer, String> originalMap) {
        HashMap<String, Integer> swappedMap = new HashMap<>();

        for (Map.Entry<Integer, String> entry : originalMap.entrySet()) {
            swappedMap.put(entry.getValue(), entry.getKey());
        }

        return swappedMap;
    }
}