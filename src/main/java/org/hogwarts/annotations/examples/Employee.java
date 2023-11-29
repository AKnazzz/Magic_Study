package org.hogwarts.annotations.examples;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void increaseSalary() {
        salary *= 2;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}


// ===> Аннотация @Target указывает, для каких элементов программы (переменных, методов, классов и т.д.)
//      может быть использована данная аннотация.

// ===> Компилятор воспринимает аннотацию @Target как метаданные, которые могут использоваться
//      для проверки корректности кода и оптимизации его работы.

// ===> Ставить аннотацию @Target обязательно, если нужно указать, для каких элементов программы
//      может быть использована данная аннотация. В противном случае, компилятор может не распознать данную аннотацию и не использовать ее при проверке кода.
@Target(ElementType.METHOD)
@interface MyAnnotation{

}