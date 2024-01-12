package org.workwork.b_java_objects.homework_b2.solution;

public class CombustionCar extends Car {

    public CombustionCar(String name, int hp, int weight, Engine engine, CarType carType) {
        super(name, hp, weight, engine, carType);
    }

    @Override
    public void drive() {
        getEngine().startEngine();
        getWheel().steer();
        getEngine().stopEngine();
    }
}
