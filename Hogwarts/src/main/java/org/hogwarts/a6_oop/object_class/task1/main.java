package org.hogwarts.a6_oop.object_class.task1;

import org.hogwarts.a6_oop.object_class.task1.beast.Hippogriff;

public class main {
    public static void main(String[] args) {
        Hippogriff hippogriff1 = new Hippogriff("Biba", 4, "Grey", "Roar");
        Hippogriff hippogriff2 = new Hippogriff("Biba", "White");
        Hippogriff hippogriff3 = new Hippogriff("Bobo");
        Hippogriff hippogriff4 = new Hippogriff();
        hippogriff4.setName("Leonid");
    }
}
