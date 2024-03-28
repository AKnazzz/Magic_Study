package org.hogwarts.a9_interfaces.hogwarts91;

import org.hogwarts.a8_exceptions.hogwarts81.Student;

public class Car implements Invisible {
    private Student driver;
    private int speed;
    private boolean isFlying;

    public Car(Student driver, int speed, boolean isFlying) {
        this.driver = driver;
        this.speed = speed;
        this.isFlying = isFlying;
    }

    @Override
    public void becomeInvisible() {
        System.out.println("The car is now invisible.");
    }

    @Override
    public void becomeVisible() {
        System.out.println("The car is now visible.");
    }

    public Student getDriver() {
        return driver;
    }

    public void setDriver(Student driver) {
        this.driver = driver;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }
}