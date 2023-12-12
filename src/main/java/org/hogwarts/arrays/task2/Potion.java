package org.hogwarts.arrays.task2;

import java.util.Arrays;
import java.util.Scanner;

public class Potion {
    public boolean prepare() {
        Scanner scanner = new Scanner(System.in);
        String[] ingredients = {"Драконий коготь", "Лист мандрагоры", "Корень шершавой астрелии"};

        System.out.print("Ингредиенты требуются: ");
        for (int i = 0; i < ingredients.length; i++) {
            if (i == ingredients.length - 1) {
                System.out.println(ingredients[i]);
            } else {
                System.out.print(ingredients[i] + ", ");
            }
        }

        System.out.println("<<<-------------------------------------->>>");
        System.out.println("Добро пожаловать в лабораторию зелий!");
        System.out.print("Введите ингредиенты, которые у вас есть (через запятую):");


        String input = scanner.nextLine();
        String[] userIngredients = input.split(", ");
        System.out.println(Arrays.toString(userIngredients));


        int score = 0;
        for (int i = 0; i < userIngredients.length; i++) {
            for (int j = 0; j < ingredients.length; j++) {
                if (userIngredients[i].equals(ingredients[j])){
                    score++;
                }
            }
        }

        if (score == ingredients.length){
            System.out.println("У вас есть все необходимые ингредиенты для зелья! Можете начинать создание.");
            return true;
        } else {
            System.out.println("У вас не хватает некоторых ингредиентов. Нельзя приступать к созданию зелья.");
            return false;
        }
    }
}
