package org.hogwarts.a6_oop.hogwarts61.beast;

import java.util.Random;

/**
 * В классе Hippogriff создать поля с нужными типами для имени, возраста, цвета, и особого умения.
 * Подумайте, какие типы данных подходят каждому из полей.
 * Мы хотим попробовать создавать разных гиппогрифов с особыми умениями.
 * Итак, когда поля созданы, давайте создадим конструкторы в этом классе.
 * Здесь есть удобный hotkey в идее, чтобы это сделать. Жмем alt+insert и в появившемся окошке выбираем Constructor. Нужно создать 4 разных конструктора:
 * Содержит все 4 поля.
 * <p>
 * Содержит только имя.
 * <p>
 * Содержит имя и цвет.
 * <p>
 * Пустой конструктор, не инициализирует полей вообще.
 */
public class Hippogriff {
    private String name;
    private int age;
    private String color;
    private String specialAbility;

    public Hippogriff(String name, int age, String color, String specialAbility) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.specialAbility = specialAbility;
    }

    public Hippogriff(String name) {
        this.name = name;
    }

    public Hippogriff(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Hippogriff() {
        // Пустой конструктор
    }

    // Метод eat
    public void eat(String food) {
        if (food.equals("мясо")) {
            System.out.println(this.name + " ест с удовольствием!");
        } else {
            System.out.println(this.name + " не будет есть " + food + ".");
        }
    }

    // Метод fly
    public String fly() {
        if (this.age > 2) {
            return this.name + " летит!";
        } else {
            return this.name + " слишком мал, чтобы летать.";
        }
    }

    // Метод giveRide
    public String giveRide(Student student) {
        Random random = new Random();
        int isGivingRide = random.nextInt(10) + 1;

        if (isGivingRide >= 1 && isGivingRide <= 3) {
            return student.getName() + " летит на гиппогрифе!";
        } else if (isGivingRide >= 4 && isGivingRide <= 8) {
            return this.name + " отказывается летать.";
        } else {
            return "Попробуйте снова!";
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public void setSpecialAbility(String specialAbility) {
        this.specialAbility = specialAbility;
    }
}