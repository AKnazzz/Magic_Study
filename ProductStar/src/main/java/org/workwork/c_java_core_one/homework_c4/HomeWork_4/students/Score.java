package org.workwork.c_java_core_one.homework_c4.HomeWork_4.students;

// Фамиилия и имя студента объединены в объект Student (фамилия добавлена по соглпсоаванию с ментором)
public record Score(Student student, String subject, int score) {
}
