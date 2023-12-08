package org.hogwarts.regEx.test;

import java.util.Arrays;

public class testTwo {
    public static void main(String[] args) {

        // метод split

        String a1 = "Hello there hey";
        String[] words1 = a1.split("");
        System.out.println(Arrays.toString(words1));

        String a = "Hello there hey";
        String[] words = a.split(" ");
        System.out.println(Arrays.toString(words));

        String b = "Hello123123123123there2342342512312314hey";
        String[] words2 = b.split("\\d+");
        System.out.println(Arrays.toString(words2));


        String c = "Hello world Java";
        String modC = c.replace(" ", ".");
        System.out.println(modC);
    }

}
