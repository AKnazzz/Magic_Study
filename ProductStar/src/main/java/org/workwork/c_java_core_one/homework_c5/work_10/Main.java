package org.workwork.c_java_core_one.homework_c5.work_10;

import java.util.*;

class ResultsBoard {
    private TreeMap<Float, String> resultsMap;

    public ResultsBoard() {
// Используем TreeMap для хранения оценок и соответствующих имён, автоматически сортирующий по ключам (оценкам)
        resultsMap = new TreeMap<>();
    }

    public void addStudent(String name, Float score) {
// Добавление новой записи - имя студента и его оценка
        resultsMap.put(score, name);
    }

    public List<String> top3() {
        List<String> top3List = new ArrayList<>();

// Инициализация TreeSet с компаратором задом наперёд для сортировки в обратном порядке
        TreeSet<Float> sortedScores = new TreeSet<>(Collections.reverseOrder());
        sortedScores.addAll(resultsMap.keySet());

        for (Float score : sortedScores) {
            if (top3List.size() == 3) {
                break;
            }
            top3List.add(resultsMap.get(score));
        }

        return top3List;
    }
}

public class Main {
    public static void main(String[] args) {
        ResultsBoard rb = new ResultsBoard();

        rb.addStudent("Ivan", 3.0f);
        rb.addStudent("Maria", 4.0f);
        System.out.println(rb.top3()); 		// -> [Maria, Ivan]
        rb.addStudent("Vlad", 5.0f);
        System.out.println(rb.top3()); 		// -> [Vlad, Maria, Ivan]
        rb.addStudent("Anton", 4.5f);
        System.out.println(rb.top3()); 		// -> [Vlad, Anton, Maria]
        rb.addStudent("Daria", 1.5f);
        System.out.println(rb.top3()); 		// -> [Vlad, Anton, Maria]
        rb.addStudent("Vasiliy", 5.0f);
        System.out.println(rb.top3()); 		// -> [Vlad, Vasiliy, Anton] или [Vasiliy, Vlad, Anton]


//
//        List<String> topStudents = rb.top3();
//        System.out.println("Список топ-3 успешных студентов:");
//        for (String student : topStudents) {
//            System.out.println(student);
//        }
    }
}