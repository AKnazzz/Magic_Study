package org.ya.module_7.stream_apt.task_1;

import java.util.Arrays;
import java.util.List;

public class Practicum1 {
    public static void main(String[] args) {
        List<Circle> circles = Arrays.asList(
                new Circle(3, 5, 12),
                new Circle(1, -2, 4),
                new Circle(8, 8, 8),
                new Circle(5, 1, 8)
        );

        circles.sort((Circle circle1, Circle circle2) -> {
            if (circle1.getRadius() == circle2.getRadius()) {
                if ((circle1.getCenterX() + circle1.getCenterY()) > (circle2.getCenterX() + circle2.getCenterY())) {
                    return 1;
                }
                return -1;
            }
            return circle1.getRadius() - circle2.getRadius();
        });

        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}

class Circle {
    private int centerX;
    private int centerY;
    private int radius;

    public Circle(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Радиус окружности: " + radius
                + ", координаты: "
                + centerX
                + ", "
                + centerY;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }
}
