package org.hogwarts.a9_interfaces.hogwarts91;

import org.hogwarts.a8_exceptions.hogwarts81.Student;

public class Main {
    public static void main(String[] args) {
        String[] abilities = {"Смелость", "Красота", "Удача"};
        Student harry = new Student("Harry Potter", "Gryffindor", 14, abilities);
        Car flyingCar = new Car(harry, 100, true);

        if (flyingCar.isFlying()) {
            flyingCar.becomeInvisible();
        } else {
            flyingCar.becomeVisible();
        }

        Cloak invisibilityCloak = new Cloak(1, 2);
        invisibilityCloak.becomeInvisible();
    }
}