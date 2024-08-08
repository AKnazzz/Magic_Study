package org.workwork.c_java_core_one.homework_c8;

public class CarWrapper {
    private  int price;
    private Car car;


    public CarWrapper(int price, Car car) {
        this.price = price;
        this.car = car;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
