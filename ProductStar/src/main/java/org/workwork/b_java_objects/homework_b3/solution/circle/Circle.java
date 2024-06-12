package org.workwork.b_java_objects.homework_b3.solution.circle;

/**
 * Заполните этот класс в соответсвии с заданием из лекции.
 */
public class Circle {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

}
