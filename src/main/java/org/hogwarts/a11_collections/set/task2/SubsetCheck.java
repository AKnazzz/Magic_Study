package org.hogwarts.a11_collections.set.task2;
import java.util.HashSet;

/**
 * Вам даны 2 множества. Вычислите, содержится ли второе множество внутри первого множества.
 * То есть является ли второе множество подмножеством первого.
 */

public class SubsetCheck {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        set2.add(2);
        set2.add(3);

        // Проверяем, является ли set2 подмножеством set1
        boolean isSubset = set1.containsAll(set2);

        if (isSubset) {
            System.out.println("Второе множество является подмножеством первого.");
        } else {
            System.out.println("Второе множество не является подмножеством первого.");
        }
    }
}
