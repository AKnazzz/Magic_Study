package org.workwork.c_java_core_one.homework_c8.workshop;

public class ObjectSpawner2<C> {
    private Class<C> clazz;

    public ObjectSpawner2(Class<C> clazz) {
        this.clazz = clazz;
    }

    public C createC() throws InstantiationException, IllegalAccessException {
        return clazz.newInstance();
    }
}
