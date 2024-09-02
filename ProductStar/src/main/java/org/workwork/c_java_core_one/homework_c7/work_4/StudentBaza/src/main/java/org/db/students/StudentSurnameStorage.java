package org.db.students;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.Set;
import java.util.stream.Collectors;

// Класс StudentSurnameStorage отвечает за управление фамилиями студентов и их связями с идентификаторами студентов.
public class StudentSurnameStorage {
    // Коллекция TreeMap для хранения связей между фамилиями студентов и их уникальными идентификаторами
    private TreeMap<String, Set<Long>> surnamesTreeMap = new TreeMap<>();

    // Метод для получения набора идентификаторов студентов по точной фамилии
    public Set<Long> getStudentByExactSurname(String surname) {
        return surnamesTreeMap.getOrDefault(surname, new HashSet<>());
    }

    // Метод для получения набора идентификаторов студентов в диапазоне фамилий
    public Set<Long> getStudentsInRange(String surnameStart, String surnameEnd) {
        return surnamesTreeMap.subMap(surnameStart, true, surnameEnd, true)
                .values()
                .stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    // Метод для добавления нового студента с указанной фамилией в коллекцию
    public void studentCreated(Long id, String surname) {
        Set<Long> existingIds = surnamesTreeMap.getOrDefault(surname, new HashSet<>());
        existingIds.add(id);
        surnamesTreeMap.put(surname, existingIds);
    }

    // Метод для удаления студента по его идентификатору и фамилии из коллекции
    public void studentDeleted(Long id, String surname) {
        surnamesTreeMap.get(surname).remove(id);
    }

    // Метод для обновления информации о студенте, когда его фамилия изменяется
    public void studentUpdated(Long id, String oldSurname, String newSurname) {
        studentDeleted(id, oldSurname);
        studentCreated(id, newSurname);
    }
}
