package org.hogwarts.a6_oop.object_class.fina_static_ex;

public class Zadacha2 {

    public final static double PI = 3.14;

    public static double dlina(double radius2) {
        double dl = 2 * PI * radius2;
        return dl;
    }

    public double ploshad(double radius) {
        double pl = PI * radius * radius;
        return pl;
    }

    public void info(double radius3) {
        System.out.println("Радиус = " + radius3);
        System.out.println("Площадь круга = " + ploshad(radius3));
        System.out.println("Длина окружности = " + dlina(radius3));
    }
}

class ZadachaTest {
    public static void main(String[] args) {

        Zadacha2 zadacha2 = new Zadacha2();

        zadacha2.info(5);


    }
}
