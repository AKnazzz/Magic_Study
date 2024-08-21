package org.workwork.d_java_core_two.work_1_adapter.workshop.decorator.second;

public class SimpleCar implements Car {
    private int speed = 50;
    private int baggageWeight = 100;

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public int getBaggageWeight() {
        return this.baggageWeight;
    }
}
