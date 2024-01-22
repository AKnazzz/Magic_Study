package org.workwork.test;

public class MainTest {
    public static void main(String[] args) {
        Walkable a = new Human();
        Animal b = new Human();
        Walkable c = new Animal();
        Human d = new Human();

        //a.talks;
        b.walk();
        c.walk();
        d.walk();
        d.talk();

        int i = 3;
        i = i--;
        --i;
        System.out.println(i++);

        String first = "Hello";
        String second = new String(first);
        if ("Hello".equals(second)) System.out.println("1");
        if (first == second) System.out.println("2");
        if ("Hello" == first) System.out.println("3");
        if ("Hello" == second) System.out.println("4");
        if (first.equals(second)) System.out.println("5");
    }
}
