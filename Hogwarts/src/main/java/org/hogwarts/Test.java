package org.hogwarts;

public class Test {

    private static Test instance;

    private Test() { // приватный конструктор
    }

    public static Test getInstance() {
        if (instance == null) {
            instance = new Test();
        }
        return instance; // возвращает экземпляр класса
    }

    public long getCurrentTime() {
        return System.currentTimeMillis();
    }
}
