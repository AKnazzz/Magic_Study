package org.hogwarts.a8_exceptions.hogwarts81;


public class Spell {
    private String title;
    private int power;

    public Spell(String title, int power) {
        this.title = title;
        this.power = power;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (power < 1 || power > 7) {
            throw new IllegalArgumentException("Power must be between 1 and 7");
        }
        this.power = power;
    }
}