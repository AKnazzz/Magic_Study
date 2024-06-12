package org.hogwarts.reflection.examples;

import java.lang.reflect.Field;

public class Ex3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {


        // НАРУШАЕМ ИНКАПСУЛЯЦИЮ
        // получаем доступ к Private полю
        Employee employee = new Employee(10, "Roma", "IT");
        Class<?> employeeClass = employee.getClass();
        Field field = employeeClass.getDeclaredField("salary");
        field.setAccessible(true);// получаем доступ к private полю
        double salaryValue = (Double) field.get(employee);
        System.out.println(salaryValue);

        System.out.println("Изменяем значение приватного поля: ");
        field.set(employee, 1500);
        System.out.println(employee);

    }
}
