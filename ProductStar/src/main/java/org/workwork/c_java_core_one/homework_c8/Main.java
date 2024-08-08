package org.workwork.c_java_core_one.homework_c8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
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

        //-----------------

        ObjectSpawner<String,ArrayList> os = new ObjectSpawner<>(String.class,ArrayList.class);
        String newStr = os.createC();
        ArrayList newList = os.createT();

        ObjectSpawner<Object, HashSet> os2 = new ObjectSpawner<>(Object.class,HashSet.class);
        Object obj = os2.createC();
        HashSet hashSet = os2.createT();

        //-------------------

        StringSpawner ss = new StringSpawner();
        String ssSting = ss.createC();


        //---------------------

        Student student = new Student();
        Docent docent = new Docent();

        Processor<Student> studentProcessor = new Processor<>(student);
        studentProcessor.getObject();

        Processor<Docent> docentProcessor = new Processor<>(docent);
        docentProcessor.getObject();
        // Processor<String> strProcessor = new Processor<>(string); // - нельзя только наследники String


    }

    // параметризация в аргументе - в самом классе явно не указан Car
    public static void driveAndAdjustPrice(Wrapper<Car> wrapper) {
        wrapper.getObject().drive();
        wrapper.setPrice(wrapper.getPrice() + 10000);
    }

    // Параметризация метода, т.е. компилятор сам будет понимать какой тип данных нам надо
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


