package org.workwork.d_java_core_two.work_1_adapter.workshop.adapter2;

public interface BasicCar {
    void drive();

    void xenonOn();

    void xenonOff();
}

interface BasicCarRus {
    void drive();

    void basicLightOn();

    void basicLightOff();
}

class AudiA3 implements BasicCar {

    final public int light = 100;

    @Override
    public void drive() {
        System.out.println("AudiA3 rides!");
    }

    @Override
    public void xenonOn() {
        System.out.println("AudiA3 xenon on!");
    }

    @Override
    public void xenonOff() {
        System.out.println("AudiA3 xenon off!");
    }

}

class AudiA3Rus implements BasicCarRus {
    final public int light = 50;

    @Override
    public void drive() {
        System.out.println("AudiA3 поехал!");
    }

    @Override
    public void basicLightOn() {
        System.out.println("AudiA3 включил фары");
    }

    @Override
    public void basicLightOff() {
        System.out.println("AudiA3 выключил фары");
    }
}

class CarAdapter implements BasicCar {
    BasicCarRus basicCarRus;

    public CarAdapter(BasicCarRus basicCarRus) {
        this.basicCarRus = basicCarRus;
    }

    @Override
    public void drive() {
        basicCarRus.drive();
    }

    @Override
    public void xenonOn() {
        basicCarRus.basicLightOn();
    }

    @Override
    public void xenonOff() {
        basicCarRus.basicLightOff();
    }
}

class CentralProcessor {
    private BasicCar car;

    public CentralProcessor(BasicCar car) {
        this.car = car;
    }

    public void work() {
        car.drive();
        car.xenonOn();
        car.xenonOff();
    }
}


class Example {
    public static void main(String[] args) {
        BasicCar audiA3 = new AudiA3();
        CentralProcessor cp = new CentralProcessor(audiA3);
        cp.work();

        CarAdapter carAdapter = new CarAdapter(new AudiA3Rus());
        cp = new CentralProcessor(carAdapter);
        cp.work();
    }
}