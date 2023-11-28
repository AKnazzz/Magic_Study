package org.hogwarts.reflection.examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ex2 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Class<?> employeeClass = Class.forName("org.hogwarts.reflection.examples.Employee");

        // ===> создание объекта класса Employee c помощью employeeClass

        // Так делали в старых версиях Java
        Employee o = (Employee) employeeClass.newInstance();
        System.out.println(o);
        System.out.println("*******");

        // Другие методы создания
        Constructor<Employee> constructor1 = (Constructor<Employee>) employeeClass.getConstructor();
        Employee obj1 = constructor1.newInstance();

        Constructor<?> constructor2 = employeeClass.getConstructor(int.class, String.class, String.class);
        Object obj2 = constructor2.newInstance(5, "Petr", "IT");
        System.out.println(obj2);
        System.out.println("*******");

        // ===> КАК ВЫЗВАТЬ МЕТОД С ПОМОЩЬЮ РЕФЛЕКСИИ
        Method method = employeeClass.getMethod("setSalary", double.class); // => название метода + параметр
        method.invoke(obj2, 800.88); // запуск метода = 1 параметр объект на котором вызываем метод, 2 параметр - указываем параметры на вход
        System.out.println(obj2);
        System.out.println("*******");

        // ЗАКОММЕНТИРУЕМ ГЕТТЕР И СЕТТЕР ДЛЯ salary + КОНТРУКТОР

    }
}
