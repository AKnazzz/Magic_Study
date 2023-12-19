package org.workwork.stage_one_base.homework_3;

import java.util.Scanner;
public class HomeWorkOne {
    public static void main(String[] args) {
        System.out.println("Расскажите о вашем друге");
        System.out.println("Как зовут вашего друга ?");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Сколько лет вашему другу?");
        String age = in.nextLine();
        System.out.println("Моему другу с именем" + name + " сейчас " + age + " лет.");

    }

}
