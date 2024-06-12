package org.hogwarts.a6_oop.object_class.fina_static_ex;

public class Zadacha1 {

    static double umnojenie(double a, double b, double c) {
        System.out.println("Умножаем 3 числа: " + a + ", " + b + ", " + c);
        System.out.println("Результат: " + a * b * c);
        return a * b * c;
    }

    static void delenie(int a, int b) {
        System.out.println("Целое частное = " + a / b + " ;");
        System.out.println("Остаток = " + a % b + " ;");
    }

}

class Zadacha1Test {
    public static void main(String[] args) {
        Zadacha1.umnojenie(2, 3, 5);
        Zadacha1.delenie(5, 2);
        Zadacha1.umnojenie(2.5, 2, 3);
        Zadacha1.delenie(7, 3);
    }
}
