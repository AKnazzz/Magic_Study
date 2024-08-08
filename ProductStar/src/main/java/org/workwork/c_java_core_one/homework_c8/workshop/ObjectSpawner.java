package org.workwork.c_java_core_one.homework_c8.workshop;

public class ObjectSpawner<C, T> {

    private Class<C> classC;
    private Class<T> classT;

    public ObjectSpawner(Class<C> classC, Class<T> classT) {
        this.classC = classC;
        this.classT = classT;
    }

    public C createC() throws InstantiationException, IllegalAccessException {
        return classC.newInstance();
    }

    public T createT() throws InstantiationException, IllegalAccessException {
        return classT.newInstance();
    }

}
