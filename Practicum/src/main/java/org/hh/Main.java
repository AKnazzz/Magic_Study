package org.hh;

import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var set = new HashSet<Integer>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            set.add(random.nextInt(10));
        }

        System.out.println(set.size());
    }
}
