package org.hogwarts.annotations.examples;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// ===> Ставить аннотацию @Target обязательно, если нужно указать, для каких элементов программы
//      может быть использована данная аннотация. В противном случае, компилятор может не распознать данную аннотацию
//      и не использовать ее при проверке кода.
@Target(ElementType.METHOD) // ===> аннотация приминима к методу
@Retention(RetentionPolicy.RUNTIME)
@interface ExMyAnnotation {

}


// ===> Аннотация @Target указывает, для каких элементов программы (переменных, методов, классов и т.д.)
//      может быть использована данная аннотация.

// ===> Компилятор воспринимает аннотацию @Target как метаданные, которые могут использоваться
//      для проверки корректности кода и оптимизации его работы.

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {

}

// ===> Аннотация @Retention указывает, как долго должна сохраняться данная аннотация. Она может быть сохранена в исходном коде,
//      скомпилированном байт-коде или доступна во время выполнения программы.
//=>            SOURCE - Аннотация видна в соурс коде, обрабатывается компилятором и уже в byte коде не видна;
//=> (default)  CLASS - видна в byte коде, отбрасывается JVM во время выполнения программы;
//=>            RUNTIME - видна во время выполнения программы;

// ===> Компилятор воспринимает аннотацию @Retention как метаданные, которые могут использоваться для проверки корректности кода
//      и оптимизации его работы.

// ===> Ставить аннотацию @Retention не всегда обязательно, но если нужно сохранить данную аннотацию в байт-коде или сделать
//      ее доступной во время выполнения программы, то необходимо указать соответствующий уровень сохранения.

@MyAnnotation
public class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @MyAnnotation
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

