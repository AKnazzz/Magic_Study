package org.hogwarts.reflection.examples;

public class Ex1 {
    public static void main(String[] args) throws ClassNotFoundException {

        //
        // 1 ВАРИАНТ создания Class class ===> используется путь (с пакетом)
        //    + не забыть добавить исключение
        Class employeeClass = Class.forName("org.hogwarts.reflection.examples.Employee");

        // 2 ВАРИАНТ создания

        Class employeeClass2 = Employee.class;

        // 3 ВАРИАНТ
        Employee emp = new Employee();
        Class employeeClass3 = emp.getClass();

    }
}
