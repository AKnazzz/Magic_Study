package org.workwork.a_java_base.homework_a5;

import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) {

        char[] s = {'H','e','l','l','o'};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(s));
        solution.reverseString(s);
        System.out.println(Arrays.toString(s));

        System.out.println("=======================");

        Solution2 solution2 = new Solution2();
        System.out.println(Arrays.toString(s));
        solution2.reverseString(s);
        System.out.println(Arrays.toString(s));

        System.out.println("=======================");

        Solution3 solution3 = new Solution3();
        System.out.println(Arrays.toString(s));
        solution3.reverseString(s);
        System.out.println(Arrays.toString(s));


    }
}
