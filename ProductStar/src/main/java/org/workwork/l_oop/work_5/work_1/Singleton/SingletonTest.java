package org.workwork.l_oop.work_5.work_1.Singleton;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println("Are both instances equal? " + (instance1 == instance2));

        instance1.doSomething();
    }
}
