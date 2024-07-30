package org.workwork.c_java_core_one.homework_c4.solution;

import java.util.*;

public class ExaminationImpl implements Examination {

    // Хранение последних оценок студентов по предметам
    private final Map<String, Map<String, Score>> scores = new HashMap<>();

    // Хранение студентов с несколькими подачами
    private final Set<String> multipleSubmissionsStudentNames = new HashSet<>();

    // Хранение студентов, сдавших на отлично
    private final List<Score> excellentScores = new ArrayList<>();

    private GradeCache gradeCache = new GradeCache();

    @Override
    public void addScore(Score score) {

        String studentName = score.name();
        String subject = score.subject();

        // Получаем или создаем карту для данного студента
        Map<String, Score> studentScores = scores.computeIfAbsent(studentName, k -> new HashMap<>());

        // Если студент уже сдавал этот предмет, добавляем его в множество многократных сдач
        if (studentScores.containsKey(subject)) {
            multipleSubmissionsStudentNames.add(studentName);
        }

        // Записываем или обновляем последнюю оценку
        studentScores.put(subject, score);

        // Если оценка отличная (например, 90 и выше), добавляем студента в список отличников
        if (score.score() >= 90) {
            excellentScores.add(score);
        }
    }

    @Override
    public Score getScore(String name, String subject) {

        // Получаем оценки студента по имени
        Map<String, Score> studentScores = scores.get(name);

        if (studentScores != null) {
            return studentScores.get(subject);
        }

        return null; // Если оценка не найдена, возвращаем null
    }

    @Override
    public double getAverageForSubject(String subject) {


        // Проверяем, есть ли кэшированная средняя оценка
        if (gradeCache.isCached(subject)) {
            return gradeCache.getAverage(subject);
        }

        // Если кэш отсутствует, вычисляем среднюю оценку
        int totalScore = 0;
        int count = 0;

        for (Map<String, Score> studentScores : scores.values()) {
            Score score = studentScores.get(subject);
            if (score != null) {
                totalScore += score.score();
                count++;
            }
        }
        double average = count > 0 ? (double) totalScore / count : 0.0;

        // Кэшируем среднюю оценку
        gradeCache.setAverage(subject, average);

        return average;
    }


    @Override
    public Set<String> multipleSubmissionsStudentNames() {
        return Collections.unmodifiableSet(multipleSubmissionsStudentNames); // Возвращаем неизменяемый набор
    }

    @Override
    public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject() {

        Set<String> excellentStudents = new LinkedHashSet<>();

        // Сортируем по времени добавления, чтобы получить последних пятерых
        for (int i = excellentScores.size() - 1; i >= 0; i--) {
            String studentName = excellentScores.get(i).name();
            excellentStudents.add(studentName);

            if (excellentStudents.size() == 5) {
                break; // Получили пять студентов, выходим из цикла
            }
        }

        return excellentStudents; // Возвращаем набор студентов с отличными оценками
    }

    @Override
    public Collection<Score> getAllScores() {
        List<Score> allScores = new ArrayList<>();

        for (Map<String, Score> studentScores : scores.values()) {
            allScores.addAll(studentScores.values());
        }
        return allScores; // Возвращаем все оценки
    }
}