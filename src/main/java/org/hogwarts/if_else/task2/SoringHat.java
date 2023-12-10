package org.hogwarts.if_else.task2;

import java.util.Scanner;

public class SoringHat {
    public String sort() {

        Scanner scanner = new Scanner(System.in);

        String question1 = "Ты предпочитаешь работать в команде? (Да/Нет)";
        String question2 = "Ты любишь разгадывать головоломки? (Да/Нет)";
        String question3 = "Ты идешь на риск, чтобы достичь своей цели? (Да/Нет)";
        String question4 = "Ты проявляешь заботу к существам и природе? (Да/Нет)";

        System.out.println(question1);
        String answer1 = scanner.nextLine();
        System.out.println(question2);
        String answer2 = scanner.nextLine();
        System.out.println(question3);
        String answer3 = scanner.nextLine();
        System.out.println(question4);
        String answer4 = scanner.nextLine();

        if (answer1.equals("Да")) {
            if (answer3.equals("Да")) {
                return "Гриффиндор";
            } else if (answer4.equals("Да")) {
                return "Пуффендуй";
            } else if (answer2.equals("Да")) {
                return "Когтевран";
            } else {
                return "Слизерин";
            }
        } else if (answer3.equals("Да")) {
            return "Слизерин";
        } else {
            return "Пуффендуй";
        }

    }
}
