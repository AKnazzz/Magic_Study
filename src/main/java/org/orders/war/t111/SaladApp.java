package org.orders.war.t111;

import java.util.Random;

// Класс овоща
class Vegetable {
    private String name;

    public Vegetable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Класс для приготовления салатов
public class SaladApp {
    public static void main(String[] args) {
        prepareSalad("Овощной");
        prepareSalad("Оливье");
        prepareSalad("Селёдка под шубой");
    }

    private static void prepareSalad(String type) {
        System.out.println("Приготовление салата: " + type);

        switch (type) {
            case "Овощной":
                System.out.println("  Предварительная подготовка:");
                cutVegetables();
                break;
            case "Оливье":
                System.out.println("  Добавление соли");
                System.out.println("  Заправка салата майонезом");
                System.out.println("  Украсить салат");
                break;
            case "Селёдка под шубой":
                System.out.println("  Выложить первый слой");
                System.out.println("    Выложить все ингредиенты слоя");
                System.out.println("  Выложить второй слой");
                System.out.println("    Перемешивание всех ингредиентов слоя");
                System.out.println("    Выложить все ингредиенты слоя");
                System.out.println("  Выложить третий слой");
                System.out.println("    Заправка салата майонезом");
                System.out.println("    Перемешивание всех ингредиентов слоя");
                System.out.println("    Выложить все ингредиенты слоя");
                break;
            default:
                System.out.println("Неизвестный тип салата");
        }

        mixSalad();
        serveSalad();
    }

    private static void cutVegetables() {
        Vegetable tomato = new Vegetable("Помидоры");
        Vegetable cucumber = new Vegetable("Огурцы");
        Vegetable onion = new Vegetable("Лук");

        System.out.println("    Разрезаем " + tomato.getName() + " дольками");
        System.out.println("    Разрезаем " + cucumber.getName() + " кубиками");
        System.out.println("    Разрезаем " + onion.getName() + " кольцами");
    }

    private static void mixSalad() {
        System.out.println("  Перемешивание всех ингредиентов салата");
    }

    private static void serveSalad() {
        if (Math.random() > 0.5) {
            System.out.println("  Ой, разбилась тарелка!");
            System.out.println("  Выложить салат на другое блюдо");
        } else {
            System.out.println("  Выложить салат на блюдо");
        }
        System.out.println("  Подать клиенту");
    }
}
