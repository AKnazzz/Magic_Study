package org.hogwarts.strings.task2;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder str = new StringBuilder();
        while (scanner.hasNextLine()) {
            str.append(scanner.nextLine());
        }

        if (str.length() % 2 != 0) {
            System.out.println("Нечетное кол-во символов");
        }

    }
}
