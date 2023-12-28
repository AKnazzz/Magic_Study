package org.workwork.a_java_base.homework_a5;

public class SkobochkiTest {
    public static void main(String[] args) {

        String s = "()";
        String t = "(()";


        Skobochki skobochki = new Skobochki();
        System.out.println(skobochki.isValid(s));
        System.out.println(skobochki.isValid(t));
    }
}
