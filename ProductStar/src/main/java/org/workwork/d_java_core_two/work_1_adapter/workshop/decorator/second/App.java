package org.workwork.d_java_core_two.work_1_adapter.workshop.decorator.second;

public class App {
    public static void main(String[] args) {

        Car simpleCar = new SimpleCar();
        System.out.println("Speed of simple car - " + simpleCar.getSpeed());
        System.out.println("Simple car can accept baggage with weight " + simpleCar.getBaggageWeight());

        Car sportCar = new SportCar(simpleCar);

        System.out.println("Speed of sport car - " + sportCar.getSpeed());
        System.out.println("Sport car can accept baggage with weight " + sportCar.getBaggageWeight());

        Car truck = new Truck(simpleCar);

        System.out.println("Speed of truck - " + truck.getSpeed());
        System.out.println("Truck can accept baggage with weight " + truck.getBaggageWeight());
    }
}
