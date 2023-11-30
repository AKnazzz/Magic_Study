package org.hogwarts.oop.object_class.employee;

public class Employee {
    int id;
    public String surname;
    int age;
    private double salary;
    String department;

    public Employee(int id, String surname, int age, double salary, String department) {
        this.id = id;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public Employee(int id) {
        this.id = id;
    }

    Employee(String surname) {
        this.surname = surname;
    }

    private Employee(double salary) {
        this.salary = salary;
    }

    double salaryX2 (){
        System.out.println("Salary before: " + salary);
        salary *=2;
        System.out.println("After add salary is: " + salary);
        return salary;
    }

    public void getId() {
        System.out.println("ID = " + id);
    }

    public void getSurname(){
        System.out.println("SURNAME = " + surname);
    }

    public void getSalary(){
        System.out.println("SALARY = " + salary);
    }
}

class EmployeeTest{
    public static void main(String[] args) {

        Employee emp1 = new Employee(1, "Bobin", 43, 35000.5, "Cleaner");
        Employee emp2 = new Employee(2, "Gagin", 54, 40000.2, "Driver");

        emp1.salaryX2();
        emp2.salaryX2();


    }
}