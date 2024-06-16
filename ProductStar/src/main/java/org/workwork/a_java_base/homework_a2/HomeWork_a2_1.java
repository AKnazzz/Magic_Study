package org.workwork.a_java_base.homework_a2;

import java.util.Scanner;

/**
 * 1. Создать программу, которая будет считывать информацию о вашем друге из консоли и распечатывать результат обратно в консоль.
 * <p>
 * > Расскажите о вашем друге
 * > Как зовут вашего друга
 * > Боря
 * > Сколько лет вашему другу
 * > 20
 * > Моему другу <Боря> сейчас <20> лет
 */

public class HomeWork_a2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Расскажите о вашем друге");
        System.out.println("Как зовут вашего друга ?");
        String friendName = scanner.nextLine();

        System.out.println("Сколько лет вашему другу?");
        int friendAge = scanner.nextInt();

        System.out.println("Моему другу с именем" + friendName + " сейчас " + friendAge + " лет.");
    }
}
