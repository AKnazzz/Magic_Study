package org.workwork.c_java_core_one.homework_c5.work_2;

public class Main {
    public static void main(String[] args) {
        ResultBoard rb = new ResultBoard();
        rb.addStudent("Ivan", 3.0f);
        rb.addStudent("Maria", 4.0f);
        // System.out.println(rb.top3()); 		// -> [Maria, Ivan]
        rb.addStudent("Vlad", 5.0f);
        System.out.println(rb.top3());        // -> [Vlad, Maria, Ivan]
        rb.addStudent("Anton", 4.5f);
        System.out.println(rb.top3());        // -> [Vlad, Anton, Maria]
        rb.addStudent("Daria", 1.5f);
        System.out.println(rb.top3());        // -> [Vlad, Anton, Maria]
        rb.addStudent("Vasiliy", 5.0f);
        System.out.println(rb.top3());        // -> [Vlad, Vasiliy, Anton] или [Vasiliy, Vlad, Anton]

    }
}
