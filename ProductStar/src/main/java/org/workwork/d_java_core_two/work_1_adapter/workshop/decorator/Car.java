package org.workwork.d_java_core_two.work_1_adapter.workshop.decorator;

abstract class Car {

    String name = "Unnamed Car";

    public String getInfo() {
        return name;
    }

    public abstract int getPrice();
}


/*
    Декораторы должны относить к тому же типу что и декорируемые объекты.
 */

abstract class Decorator extends Car {
    public abstract String getInfo();
}

class AudiA3 extends Car {

    public AudiA3() {
        name = "Audi A3";
    }

    @Override
    public int getPrice() {
        return 10_000;
    }
}

class AudiA4 extends Car {

    public AudiA4() {
        name = "Audi A4";
    }

    @Override
    public int getPrice() {
        return 15_000;
    }
}

/*
    Реализуем тот же интерфейс или абстрактный класс, что и декорируемый компонент
    содержит компонент (ссылка на компонент хранится в переменной экземпляра)
    может расширить состояние компонента или добавить новые методы

 */

class GPS extends Decorator{
    Car car;

    public GPS(Car car) {
        this.car = car;
    }

    @Override
    public int getPrice() {
        return car.getPrice() + 1500;
    }

    @Override
    public String getInfo() {
        return car.getInfo() + " + GPS";
    }
}

class AirCondition extends Decorator{
    Car car;

    public AirCondition(Car car) {
        this.car = car;
    }

    @Override
    public int getPrice() {
        return car.getPrice() + 1000;
    }

    @Override
    public String getInfo() {
        return car.getInfo() + " + AirCondition" ;
    }
}

class Example{
    public static void main(String[] args) {

        Car car1 = new AudiA3();
        System.out.println(car1.getInfo());
        System.out.println(car1.getPrice());

        System.out.println("=============");

        car1 = new GPS(car1);
        System.out.println(car1.getInfo());
        System.out.println(car1.getPrice());

        System.out.println("=============");

        car1 = new AirCondition(car1);
        System.out.println(car1.getInfo());
        System.out.println(car1.getPrice());

        System.out.println("=============");

        Car car2= new AirCondition(new GPS(new AudiA4()));
        System.out.println(car2.getInfo());
        System.out.println(car2.getPrice());
    }
}

