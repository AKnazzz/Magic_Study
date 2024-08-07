package org.workwork.c_java_core_one.homework_c7.workshop;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentStorage {

    private Map<Long, Student> studentStorageMap = new HashMap<>();
    private StudentSurnameStorage studentSurnameStorage = new StudentSurnameStorage();
    private Long currentId = 0L;

    /**
     * Создание данных о студенте
     *
     * @param student данные о студенте
     * @return сгенерированный уникальный идентификатор студента
     */

    public Long createStudent(Student student) {
        Long nextId = getNextId();
        studentStorageMap.put(nextId, student);
        studentSurnameStorage.studentCreate(nextId, student.getSurname());
        return nextId;
    }

    /**
     * Обновление данных о студенте
     *
     * @param id      идентификатор студента
     * @param student новые данные о студенте
     * @return true если обновлено, false если студент не найден
     */

    public boolean updateStudent(Long id, Student student) {
        if (!studentStorageMap.containsKey(id)) {
            return false;
        } else {
            String newSurname = student.getSurname();
            String oldSurname = studentStorageMap.get(id).getSurname();
            studentStorageMap.put(id, student);
            studentSurnameStorage.studentUpdate(id, oldSurname, newSurname);
            return true;
        }
    }

    /**
     * Удаление студента по id
     *
     * @param id идентификатор студента
     * @return true если студент успешно удалён, false если студент не найден
     */
    public boolean deleteStudent(Long id) {
        Student removed = studentStorageMap.remove(id);
        if (removed != null) {
            studentSurnameStorage.studentDeleted(id, removed.getSurname());
        }
        return removed != null;
    }

    public void search(String surname) {
        Set<Long> students = studentSurnameStorage.getStudentBySurnamesLessOrEqualThan(surname);
        for (Long studentId : students) {
            Student student = studentStorageMap.get(studentId);
            System.out.println(student);
        }
    }

    public Long getNextId() {
        currentId = currentId + 1;
        return currentId;
    }

    public void printAll() {
        System.out.println(studentStorageMap);
    }

    public void printMap(Map<String, Long> data) {
        data.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + " - " + e.getValue());
        });
    }


    public Map<String, Long> getCountByCourse() {

        /*

        Map<String, Long> res = new HashMap<>();
        for (Student student : studentStorageMap.values()) {
            String key = student.getCourse();
            Long count = res.getOrDefault(key, 0L);
            count++;
            res.put(key, count);
        }
        return res;\

        */

        Map<String, Long> res = studentStorageMap.values().stream()
                .collect(Collectors.toMap(
                        student -> student.getCourse(),
                        student -> 1L,
                        (count1, count2) -> count1 + count2));
        return res;
    }

}