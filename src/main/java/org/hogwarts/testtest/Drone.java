package org.hogwarts.testtest;

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
