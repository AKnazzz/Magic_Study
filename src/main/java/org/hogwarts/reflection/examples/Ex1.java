package org.hogwarts.reflection.examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {

        // ТРИ ВАРИАНТА СОЗДАНИЯ Class

        // ===> 1 ВАРИАНТ создания Class class ===> используется путь (с пакетом)
        //    + не забыть добавить исключение
        Class<?> employeeClass = Class.forName("org.hogwarts.reflection.examples.Employee");

        // ===> 2 ВАРИАНТ создания
        // Class <?> employeeClass2 = Employee.class;

        // ===> 3 ВАРИАНТ
        // Employee emp = new Employee();
        // Class <?> employeeClass3 = emp.getClass();


        // ==> ПОЛЯ
        // ===>  КАК ПОЛУЧИТЬ ОДНО (!!!) ПОЛЕ ПО ИМЕНИ :
        // по имени поля + добавить исключение если такого поля нет
        Field someField = employeeClass.getField("id");
        System.out.println("Type of id field = " + someField.getType()); // => получаем тип поля
        System.out.println("*******");

        // ===> КАК ПОЛУЧИТЬ ВСЕ ПОЛЯ = получим массив Field:
        Field[] fields = employeeClass.getFields(); // = все поля класса Employee (!!!) БЕЗ private
        for (Field field : fields) {
            System.out.println("Type of " + field.getName() + " = " + field.getType());
        }
        System.out.println("*******");

        // ===> КАК ПОЛУЧИТЬ ВСЕ ПОЛЯ, ВКЛЮЧАЯ private:
        Field[] allFields = employeeClass.getDeclaredFields();
        for (Field field : allFields) {
            System.out.println("Type of " + field.getName() + " = " + field.getType());
        }
        System.out.println("----------------------------------------------------");


        // ====> МЕТОДЫ
        // ===> КАК ПОЛУЧИТЬ МЕТОД ПО ИМЕНИ МЕТОДА + добавить исключение:
        // ОБЯЗАТЕЛЬНО УКАЗЫВАТЬ ВТОРЫМ АГРУМЕНТОМ ТИПЫ ПАРАМЕТРОВ = СМ setSalary второй параметр

        Method someMethod = employeeClass.getMethod("increaseSalary");
        System.out.println("Return type of method increaseSalary = " + someMethod.getReturnType());
        System.out.println(
                "Return parameter types of method increaseSalary = " + Arrays.toString(someMethod.getParameterTypes()));
        // getParameterTypes => возвращает массив методов
        System.out.println("*******");

        Method someMethod2 = employeeClass.getMethod("setSalary", double.class);
        System.out.println("Return type of method setSalary = " + someMethod2.getReturnType());
        System.out.println(
                "Return parameter types of method setSalary = " + Arrays.toString(someMethod2.getParameterTypes()));
        System.out.println("*******");

        // ===> КАК ПОЛУЧИТЬ ВСЕ МЕТОДЫ КЛАССА: = ВКЛЮЧАЯ ВСЕ ЧТО УНАСЛЕДОВАНО ОТ РОДИТЕЛЕЙ
        // НО БЕЗ private
        Method[] methods = employeeClass.getMethods();
        for (Method method : methods) {
            System.out.println("Name of method = " + method.getName() + ", return type = " + method.getReturnType()
                    + ", parameters types = " + Arrays.toString(method.getParameterTypes()));
        }
        System.out.println("*******");

        // ===> КАК ПОЛУЧИТЬ ВСЕ МЕТОДЫ КЛАССА: = БЕЗ РОДИТЕЛЬСКИХ но с PRIVATE
        Method[] allMethods = employeeClass.getDeclaredMethods();
        for (Method method : allMethods) {
            System.out.println("Name of method = " + method.getName() + ", return type = " + method.getReturnType()
                    + ", parameters types = " + Arrays.toString(method.getParameterTypes()));
        }
        System.out.println("*******");

        // ===> КАК ПОЛУЧИТЬ только PUBLIC  МЕТОДЫ КЛАССА: = БЕЗ РОДИТЕЛЬСКИХ
        Method[] allMethods2 = employeeClass.getDeclaredMethods();
        for (Method method : allMethods2) {
            if (Modifier.isPublic(method.getModifiers())) { // ===> !!! ПРОВЕРЯЕМ МОДИФИКАТОР
                System.out.println("Name of method = " + method.getName() + ", return type = " + method.getReturnType()
                        + ", parameters types = " + Arrays.toString(method.getParameterTypes()));
            }
        }
        System.out.println("----------------------------------------------------");

        // ====> КОНСТРУКТОРЫ
        // ===> КАК ПОЛУЧИТЬ КОНСТРУКТОР БЕЗ ПАРАМЕТРОВ:

        Constructor<?> constructor1 = employeeClass.getConstructor(); // УКАЗАТЬ ПАРАМЕТРЫ
        System.out.println("Constructor has parameters: " + constructor1.getParameterCount());
        System.out.println("Their types: " + Arrays.toString(constructor1.getParameterTypes()));

        // ===> КАК ПОЛУЧИТЬ КОНСТРУКТОР С ПАРАМЕТРАМИ:
        Constructor<?> constructor2 = employeeClass.getConstructor(int.class, String.class,
                String.class); // УКАЗАТЬ ПАРАМЕТРЫ
        System.out.println("Constructor has parameters: " + constructor2.getParameterCount());
        System.out.println("Their types: " + Arrays.toString(constructor2.getParameterTypes()));

        // ===> КАК ПОЛУЧИТЬ ВСЕ КОНСТРУКТОРЫ:
        Constructor[] constructors = employeeClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor " + constructor.getName() + " has " + constructor.getParameterCount()
                    + " parameters, their types are: " + Arrays.toString(constructor.getParameterTypes()));
        }
        System.out.println();
    }
}
