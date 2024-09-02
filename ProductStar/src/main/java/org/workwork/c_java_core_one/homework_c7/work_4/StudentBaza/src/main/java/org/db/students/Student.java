package org.db.students;
// Методы класса позволяют устанавливать и получать значения этих полей.
// Класс Student представляет собой объект студента с полями для хранения имени и фамилии.

public class Student {

    // Фамилия студента
    private String surname;
    // Имя студента
    private String name;
    // Курс, на котором учится студент
    private String course;
    // Город проживания студента
    private String city;
    // Возраст студента
    private Integer age;

    // Метод для получения фамилии студента
    public String getSurname() {
        return surname;
    }

    // Метод для установки фамилии студента
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Метод для получения имени студента
    public String getName() {
        return name;
    }

    // Метод для установки имени студента
    public void setName(String name) {
        this.name = name;
    }

    // Метод для получения курса студента
    public String getCourse() {
        return course;
    }

    // Метод для установки курса студента
    public void setCourse(String course) {
        this.course = course;
    }

    // Метод для получения города проживания студента
    public String getCity() {
        return city;
    }

    // Метод для установки города проживания студента
    public void setCity(String city) {
        this.city = city;
    }

    // Метод для получения возраста студента
    public Integer getAge() {
        return age;
    }

    // Метод для установки возраста студента
    public void setAge(Integer age) {
        this.age = age;
    }

    // Оптимизированный метод toString для красивого вывода информации о студенте
    @Override
    public String toString() {
        return String.format(
                "Информация о студенте:\n" +
                        "-----------------------------\n" +
                        "Фамилия: %s\n" +
                        "Имя: %s\n" +
                        "Курс: %s\n" +
                        "Город: %s\n" +
                        "Возраст: %d\n",
                surname, name, course, city, age
        );
    }
}
