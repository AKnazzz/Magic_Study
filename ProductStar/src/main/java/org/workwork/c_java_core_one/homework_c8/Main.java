package org.workwork.c_java_core_one.homework_c8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList();
        cars.add(new Car());

        Car newCar = cars.get(0);

        //-----------------
        Wrapper<Car> carWrapper = new Wrapper(400000, new Car());
        Car newCar2 = carWrapper.getObject();


        //----------------
        List<String> strings = spawnList();
        List<Integer> integers = spawnList();

        //----------------
        String string = new String("Some string");
        string = validate(string);
        System.out.println(string);

    }

    // параметризация в аргументе - в самом классе явно не указан Car
    public static void driveAndAdjustPrice(Wrapper<Car> wrapper) {
        wrapper.getObject().drive();
        wrapper.setPrice(wrapper.getPrice() + 10000);
    }

    // параметризация метода, т.е. компилятор сам будет понимать какой тип данных нам надо
    public static <C> List<C> spawnList() {
        return new ArrayList<>();
    }

    // метод валидации объекта например
    public static <D> D validate(D object) {
        if (object == null) {
            throw new RuntimeException("Object is null");
        }
        return object;
    }

}


