package org.hogwarts.comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee emp1 = new Employee(100, "Zaur", "Tregulov", 12345);
        Employee emp2 = new Employee(15, "Ivan", "Petrov", 6542);
        Employee emp3 = new Employee(123, "Ivan", "Sidorov", 8542);

        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        System.out.println("До сортировки \n" + list);

        Collections.sort(list);
        System.out.println("После сортировки \n" + list);
    }

}

class Employee implements Comparable<Employee> {
    Integer id;
    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public int compareTo(
            Employee anotherEmp) { // сравниваем ткущий объект с тем объектом в параметре метода и вернётся какое-то число,
//        // если текущий объект больше = будет положительное, если меньше = отрицательное, если равны то ноль
//        if (this.id == anotherEmp.id) {
//            return 0;
//        } else if (this.id < anotherEmp.id) {             //  =>  Вариант 1
//            return -1;
//        } else {
//            return 1;
//        }

        //   return this.id - anotherEmp.id;               //    => Вариант 2
        //   return this.id.compareTo(anotherEmp.id);        //    => Вариант 3 для Integer или Spring
        //    return this.name.compareTo(anotherEmp.name);    // по String

        int res = this.name.compareTo(anotherEmp.name);
        if (res == 0) {
            res = this.surname.compareTo(anotherEmp.surname);
        }
        return res;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
