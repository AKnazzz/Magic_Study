package org.hogwarts.reflection.task;

import java.util.ArrayList;
import java.util.Arrays;

public class ReflectionApiTask {
    public static void main(String[] args) {
//  с помощью рефлексии вызвать метод print() и обработать все
//  возможные ошибки (в качестве аргумента передавать любое подходящее
//  число). При “ловле” исключений выводить на экран краткое описание ошибки.
//
//        try {
//            Method method = APrinter.class.getDeclaredMethod("print", int.class);
//            method.setAccessible(true);
//            method.invoke(new APrinter(), 20);
//        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }

        printInterfaceSuper(ArrayList.class);

    }

    // Написать метод, который с помощью рефлексии получит все интерфейсы
    // класса, включая интерфейсы от классов-родителей и интерфейсов-родителей
    static void printInterfaceSuper(Class<?> clazz) {

        for (Class<?> i = clazz; i != null; i = i.getSuperclass()) {
            System.out.println(i.getName());
            System.out.println(Arrays.toString(i.getInterfaces()));
        }

    }


}
