package org.workwork.d_java_core_two.homeWork_d1.workshop.decorator;

abstract class Car {

    String name = "Unnamed Car";

    public String getInfo() {
        return name;
    }

    public abstract int getPrice();
}



