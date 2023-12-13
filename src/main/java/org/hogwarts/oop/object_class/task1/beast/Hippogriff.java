package org.hogwarts.oop.object_class.task1.beast;

import org.hogwarts.oop.object_class.task1.student.Student;

import java.util.Random;

public class Hippogriff {

    private String name;
    private int age;
    private String color;
    private String ability;

    //Содержит все 4 поля.
    public Hippogriff(String name, int age, String color, String ability) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.ability = ability;
    }

    //Содержит только имя.

    public Hippogriff(String name) {
        this.name = name;
    }

    //Содержит имя и цвет.

    public Hippogriff(String name, String color) {
        this.name = name;
        this.color = color;
    }

    //Пустой конструктор, не инициализирует полей вообще.

    public Hippogriff() {
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

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }


    //eat(String food) — в этом методе можно написать простое условие, в зависимости от переданной строки.
    // Например, вы можете здесь указать, что гиппогриф ни за что не будет есть какую-то еду, а другую, наоборот, с радостью.

    public void eat(String food) {
        if (food.equals("Грибы")) {
            System.out.println("Зверь не хочет есть эту гадость!");
        } else {
            System.out.println("Зверь ест с радостью!");
        }
    }


    //fly() — все взрослые гиппогрифы умеют летать. Давайте внутри сделаем проверку — если гиппогриф старше двух лет,
    // он может летать. Иначе — нет, он еще слишком мал. Пусть этот метод имеет возвращаемое значение String. И если гиппогриф взлетел, вернуть (return) из метода строку о том, что он летит. В строке используйте имя гиппогрифа (this.name).
    public void fly() {
        if (getAge() > 2) {
            System.out.println("Зверь взлетел!");
        } else {
            System.out.println("Зверь должен быть старше 2х лет чтобы летать.");
        }
    }

    //giveRide(Student student) — давайте сделаем так, чтобы гиппогрифы катали не всех и не всегда. Добавьте методу
    // возвращаемое значение String. Внутри метода создадим поле int isGivingRide, которое сразу инициализируем рандомным
    // числом в диапазоне от 1 до 10. Дальше напишем условие: если isGivingRide в диапазоне от 1 до 3, то гиппогриф
    // покатает студента (return student.getName() летит на гиппогрифе!), если в диапазоне от 4 до 8, то гиппогриф
    // демонстративно отворачивается и отказывается летать — тут тоже вернуть подходящую строку. Если 9 или 10, студент
    // должен попробовать снова — верните строку, которая об этом сообщит.

    public String giveRide(Student student) {
        int isGivingRide = new Random().nextInt(0, 11);
        if (isGivingRide >= 1 && isGivingRide <= 3) {
            return student.getName() + " летит на гиппогрифе!";
        } else if (isGivingRide >= 4 && isGivingRide <= 8) {
            return "Гиппогриф демонстративно отворачивается и отказывается летать";
        } else {
            return "Cтудент должен попробовать снова!";
        }
    }
}
