package org.workwork;

public class Test {
    public static void main(String[] args) {
        char[] textArray = {'0','1','2','3','4','5','6','7','8','9'};
        String newString = String.copyValueOf(textArray,1,3);
        System.out.println(newString);

    }
}