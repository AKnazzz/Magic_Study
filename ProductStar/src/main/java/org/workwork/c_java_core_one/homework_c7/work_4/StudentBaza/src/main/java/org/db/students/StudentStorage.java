package org.db.students;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// Класс StudentStorage отвечает за хранение и управление информацией о студентах.
public class StudentStorage {
    // Коллекция для хранения студентов, где ключом является уникальный идентификатор студента, а значением - объект Student
    private Map<Long, Student> studentStorageMap = new HashMap<>();
    // Переменная для хранения текущего уникального идентификатора студента
    private Long currentId = 0L;
    // Экземпляр класса StudentSurnameStorage для управления фамилиями студентов
    private StudentSurnameStorage studentSurnameStorage = new StudentSurnameStorage();

    // Метод для создания нового студента
    public Long createStudent(Student student) {
        Long nextId = getNextId();
        studentStorageMap.put(nextId, student);
        studentSurnameStorage.studentCreated(nextId, student.getSurname());
        return nextId;
    }

    // Метод для обновления информации о существующем студенте по его идентификатору
    public boolean updateStudent(Long id, Student student) {
        if (!studentStorageMap.containsKey(id)) {
            return false;
        } else {
            String newSurname = student.getSurname();
            String oldSurname = studentStorageMap.get(id).getSurname();
            studentSurnameStorage.studentUpdated(id, oldSurname, newSurname);
            studentStorageMap.put(id, student);
            return true;
        }
    }

    // Метод для удаления студента по его идентификатору
    public boolean deleteStudent(Long id) {
        Student removed = studentStorageMap.remove(id);
        if (removed != null) {
            String surname = removed.getSurname();
            studentSurnameStorage.studentDeleted(id, surname);
        }
        return removed != null;
    }

    // Метод для поиска студентов в зависимости от введенной фамилии или диапазона фамилий
    public void searchExact(String surname) {
        Set<Long> students = studentSurnameStorage.getStudentByExactSurname(surname);
        if (students.isEmpty()) {
            System.out.println("Студенты с фамилией " + surname + " не найдены.");
        } else {
            for (Long studentId : students) {
                Student student = studentStorageMap.get(studentId);
                System.out.println(student);
            }
        }
    }

    // Метод для поиска студентов в диапазоне фамилий
    public void searchInRange(String surnameStart, String surnameEnd) {
        Set<Long> students = studentSurnameStorage.getStudentsInRange(surnameStart, surnameEnd);
        if (students.isEmpty()) {
            System.out.println("Студенты в диапазоне фамилий " + surnameStart + " - " + surnameEnd + " не найдены.");
        } else {
            for (Long studentId : students) {
                Student student = studentStorageMap.get(studentId);
                System.out.println(student);
            }
        }
    }

    // Метод для генерации следующего уникального идентификатора для нового студента
    public Long getNextId() {
        currentId = currentId + 1;
        return currentId;
    }

    // Метод для вывода на экран всех студентов
    public void printAll() {
        System.out.println(studentStorageMap);
    }

    // Метод для вывода на экран данных в виде карты, где ключ - строка, а значение - число
    public void printMap(Map<String, Long> data) {
        data.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + " - " + e.getValue());
        });
    }

    // Метод для получения количества студентов по каждому курсу
    public Map<String, Long> getCountByCourse() {
        Map<String, Long> res = studentStorageMap.values().stream()
                .collect(Collectors.toMap(
                        student -> student.getCourse(),
                        student -> 1L,
                        (count1, count2) -> count1 + count2
                ));
        return res;
    }

    // Метод для получения количества студентов по каждому городу
    public Map<String, Long> getCountByCity() {
        return studentStorageMap.values().stream()
                .collect(Collectors.groupingBy(Student::getCity, Collectors.counting()));
    }
}
