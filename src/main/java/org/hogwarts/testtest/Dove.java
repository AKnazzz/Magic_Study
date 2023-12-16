package org.hogwarts.testtest;

public class Dove implements MailClient{
    @Override
    public void send(String from, String to, String text) {
        System.out.println("asdasdasd");
    }

    @Override
    public void recieve() {
        System.out.println("12312");
    }
}

    Напиши ответ студенту, приободри его и посоветуй не сдаваться , мотивируй его учиться  Как бы вы ответили на вопросы,
        указанные ниже, студенту?  Как бы вы ответили на вопросы, указанные ниже, студенту?
        Ваша задача — донести смысл так, чтобы ваши объяснения смог понять новичок.

        Вопрос студента:
Объясните, пожалуйста, почему у меня не получается создать объект на основе этих двух классов? Не понимаю :(

        1. MailClient drone = new MailClient ();
        2. Dove gulya = new Drone();

В программе есть интерфейс MailClient, который описывает функционал отправки и получения писем:

public interface MailClient {
    void send(String from, String to, String text);
    void recieve();
}
public class Drone implements MailClient{
    @Override
    public void send(String from, String to, String text) {
        System.out.println("3333");
    }

    @Override
    public void recieve() {
        System.out.println("222");
    }
}
public class Dove implements MailClient{
    @Override
    public void send(String from, String to, String text) {
        System.out.println("asdasdasd");
    }

    @Override
    public void recieve() {
        System.out.println("12312");
    }
}
