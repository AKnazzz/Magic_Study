package org.workwork.c_java_core_one.homework_c8.workshop;

public class Processor<T extends Person> {
    private T object;

    public Processor(T object) {
        this.object = object;
    }

    public void process() {
        object.saySomthing();
    }

    public T getObject() {
        return object;
    }
}
