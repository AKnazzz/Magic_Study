package org.workwork.c_java_core_one.homework_c7.workshop;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StudentSurnameStorage {

    private TreeMap<String, Set<Long>> surnamesTreeMap = new TreeMap<>();

    /**
     * @return уникальные ID студентов чьи фамилии меньше или равны переданной
     */
    public Set<Long> getStudentBySurnamesLessOrEqualThan(String surname) {
        Set<Long> res = surnamesTreeMap.headMap(surname, true)
                .values()
                .stream()
                .flatMap(longs -> longs.stream())
                .collect(Collectors.toSet());
        return res;
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

