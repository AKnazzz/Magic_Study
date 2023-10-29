package org.hogwarts;

import java.util.Stack;

/**
 * Дана строка, состоящая из символов “(“, “)”, “{”, “}”, “[“, “]”
 * Необходимо написать метод, принимающий эту строку и выводящий результат,
 * является ли она правильной скобочной последовательностью или нет.
 *  Строка является правильной скобочной последовательностью, если:
 * ● Пустая строка является правильной скобочной последовательностью.
 * ● Пусть S — правильная скобочная последовательность, тогда (S) есть правильная скобочная последовательность.
 * ● Пусть S1, S2 — правильные скобочные последовательности, тогда S1S2 есть правильная скобочная последовательность.
 * ● Открывающие скобки должны быть закрыты однотипными закрывающими скобками.
 * ● Каждой закрывающей скобке соответствует открывающая скобка того же
 * типа.
 */

public class Task_skobochki {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 30000; i++) {
            isTrue("[{(){}}][()]{}");
           // isCorrectBracketSequence("[{(){}}][()]{}");
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    //    System.out.println(isCorrectBracketSequence("[{(){}}][()]{}"));


    }

    // () {} [] ()({[()]})

    public static boolean isTrue(String s) {

        char[] simbols = s.toCharArray();

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (char thisChar : simbols) {
            if (thisChar == '(') {
                count1++;
            }
            if (thisChar == ')') {
                count1--;
            }
            if (thisChar == '{') {
                count2++;
            }
            if (thisChar == '}') {
                count2--;
            }
            if (thisChar == '[') {
                count3++;
            }
            if (thisChar == ']') {
                count3--;
            }
            if (count1 < 0 || count2 < 0 || count3 < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isCorrectBracketSequence(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // Метод isCorrectBracketSequence() принимает строку s и использует стек
    // для проверки правильности скобочной последовательности.
    // Если встречается открывающая скобка, она добавляется в стек. Если встречается закрывающая скобка,
    // проверяется соответствие с последней открывающей скобкой в стеке. Если они однотипны,
    // то открывающая скобка удаляется из стека, иначе возвращается false.
    // Если после обхода всей строки стек пустой, то возвращается true, иначе - false.

}
