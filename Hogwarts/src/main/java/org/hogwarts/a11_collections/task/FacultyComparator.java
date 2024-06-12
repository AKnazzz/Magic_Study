package org.hogwarts.a11_collections.task;

import java.util.Comparator;

public class FacultyComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return student2.getFaculty().compareTo(student1.getFaculty());
    }
}