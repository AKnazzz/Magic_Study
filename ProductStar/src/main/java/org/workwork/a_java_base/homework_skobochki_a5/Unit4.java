package org.workwork.a_java_base.homework_skobochki_a5;

import java.util.Scanner;
import java.util.Stack;

public class Unit4 {
    public static void main (String[] args) {

        System.out.println("Введите строку:");
        Scanner sc = new Scanner (System.in);
        String myLine = sc.nextLine();

        char[] charArray = myLine.toCharArray();
        Stack <Character> myStack = new Stack<>();
        char myChar;

        for (int i=0; i < charArray.length; i++) {
            if (charArray[i] == '{' || charArray[i] == '[' || charArray[i] == '(') {
                myStack.push(charArray[i]);
            } else if (charArray[i] == '}' || charArray[i] == ']' || charArray[i] == ')') {
                    if (myStack.isEmpty()) {
                        System.out.println("Ошибка c закрывающими скобками, позиция " + (i + 1));
                        return;
                    } else {
                        myChar = myStack.pop();

                        switch (myChar) {
                            case '{':
                                if (charArray[i] != '}') {
                                    System.out.println("Ошибка! Позиция " + (i + 1));
                                    System.out.print(myChar);
                                    System.out.print(charArray[i]);
                                    return;
                                }
                                break;
                            case '[':
                                if (charArray[i] != ']') {
                                    System.out.println("Ошибка! Позиция " + (i + 1));
                                    System.out.print(myChar + " " + charArray[i]);
                                    return;
                                }
                                break;
                            case '(':
                                if (charArray[i] != ')') {
                                    System.out.println("Ошибка! Позиция " + (i + 1));
                                    System.out.print(myChar + " " + charArray[i]);
                                    return;
                                }
                                break;
                        }
                    }
            }
        }
        if (!myStack.isEmpty()) {
            System.out.print("Не закрыты скобки!");
        } else {
            System.out.print("Ты справился!");
        }
    }
}
