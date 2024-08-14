package org.workwork.d_java_core_two.work_1_adapter.workshop.decorator;

abstract class Car {

    String name = "Unnamed Car";

    public String getInfo() {
        return name;
    }

    public abstract int getPrice();
}



