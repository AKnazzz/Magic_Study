package org.hogwarts.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionApiTask {
    public static void main(String[] args) {

        try {
            Method method = APrinter.class.getDeclaredMethod("print", int.class);
            method.setAccessible(true);
            method.invoke(new APrinter(), 20);
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }



}
