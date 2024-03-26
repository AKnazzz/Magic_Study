package org.hogwarts.a6_oop.hogwarts61.beast;

public class Hogwarts61 {
    public static void main(String[] args) {
        Hippogriff hippo1 = new Hippogriff("Hippo", 5, "Purely white", "Invisibility");
        Hippogriff hippo2 = new Hippogriff("Griffin");
        Hippogriff hippo3 = new Hippogriff("Thunder", "Golden");
        Hippogriff hippo4 = new Hippogriff();

        hippo4.setName("Storm");

        // Теперь у нас есть 4 объекта класса Hippogriff с разными характеристиками

        String[] abilities = {"Смелость", "Красота", "Удача"};

        Student student = new Student("Harry Potter", "Gryffindor", 14, abilities);

        String result = hippo1.giveRide(student);

        System.out.println(result);
    }
}
