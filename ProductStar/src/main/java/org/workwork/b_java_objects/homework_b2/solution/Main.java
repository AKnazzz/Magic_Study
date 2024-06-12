package org.workwork.b_java_objects.homework_b2.solution;

public class Main {

    public static void main(String[] args) {
        Car mazdaCx5 = new CombustionCar("Mazda", 120, 2200, new Engine(), CarType.SUV);
        Car bmwm3 = new CombustionCar("BMW M3", 220, 1800, new Engine(), CarType.COUPE);
        Car tesla = new ElectricCar("Tesla", 250, 2000, CarType.SEDAN);


        testTheCar(mazdaCx5);
        testTheCar(bmwm3);
        testTheCar(tesla);
    }

    public static void testTheCar(Car car) {
        System.out.println("--------------");
        describeCar(car);
        if (car instanceof Drivable) {
            driveCar((Drivable) car);
        }
        System.out.println("--------------");

    }

    public static void describeCar(Car car) {
        System.out.println("Name: " + car.getName() + "\n" +
                "Type: " + car.getCarType() + "\n" +
                "HP: " + car.getHp() + "\n" +
                "Weight: " + car.getWeight());
    }

    public static void driveCar(Drivable driveable) {
        driveable.drive();
    }
}