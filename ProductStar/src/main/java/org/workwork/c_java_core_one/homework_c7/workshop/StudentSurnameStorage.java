package org.workwork.c_java_core_one.homework_c7.workshop;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StudentSurnameStorage {

    private TreeMap<String, Set<Long>> surnamesTreeMap = new TreeMap<>();

    /**
     * Данный метод возвращает уникальные идентификаторы студентов
     * чьи фамилии меньше или равны переданной.
     * @return set
     */
    public Set<Long> getStudentBySurnameLessOrEqualThan(String surname){
        Set<Long> res = surnamesTreeMap.headMap(surname, true)
                .values()
                .stream()
                .flatMap(longs -> longs.stream())
                .collect(Collectors.toSet());
        return res;
    }

    /**
     * Данный метод возвращает уникальные идентификаторы студентов,
     * чьи фамилии находятся в заданном алфавитном диапазоне (включительно).
     *
     * @param startSurname начальная фамилия диапазона (включительно).
     * @param endSurname конечная фамилия диапазона (включительно).
     * @return set идентификаторов студентов, чьи фамилии находятся в заданном диапазоне.
     */
    public Set<Long> getStudentBySurnameInRange(String startSurname, String endSurname) {

        try {
            return surnamesTreeMap.subMap(startSurname, true, endSurname, true)
                    .values()
                    .stream()
                    .flatMap(Set::stream)
                    .collect(Collectors.toSet());
        } catch (IllegalArgumentException e) {
            // Возвращаем пустой набор, если подмапа не существует
            return new HashSet<>();
        }
    }


    public void studentCreate(Long id, String surname) {
        Set<Long> existingId = surnamesTreeMap.getOrDefault(surname, new HashSet<>());
        existingId.add(id);
        surnamesTreeMap.put(surname, existingId);
    }

    public void studentDeleted(Long id, String surname) {
        surnamesTreeMap.get(surname).remove(id);
    }

    public void studentUpdate(Long id, String oldSurname, String newSurname) {
        studentDeleted(id, oldSurname);
        studentCreate(id, newSurname);
    }


}

