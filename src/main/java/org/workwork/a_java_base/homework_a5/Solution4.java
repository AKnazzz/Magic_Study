package org.workwork.a_java_base.homework_a5;

public class Solution4 {
    public static String reverse(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
        reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String origin = "abcd";
        String reversed = reverse(origin);
        System.out.println(reversed);
    }
}
