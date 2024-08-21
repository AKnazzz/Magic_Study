package org.workwork.d_java_core_two.work_1_adapter.workshop.decorator.second;

public class SportCar implements Car {
    private Car car;
    public SportCar(Car car){
        this.car = car;
    }

    @Override
    public int getSpeed() {
        return this.car.getSpeed() + 50;
    }

    @Override
    public int getBaggageWeight() {
        return this.car.getBaggageWeight();
    }
}
