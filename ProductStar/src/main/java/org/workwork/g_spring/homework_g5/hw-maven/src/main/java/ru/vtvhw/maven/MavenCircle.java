package org.workwork.g_spring.homework_g5.hw;

public class MavenCircle {
    private int radius;

    public MavenCircle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getLength() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "MavenCircle{radius=" + radius + "}";
    }
}
