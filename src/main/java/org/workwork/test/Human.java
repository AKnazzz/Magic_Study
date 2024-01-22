package org.workwork.test;

public class Human extends Animal{
    @Override
    public void walk() {
        System.out.println("walk on 2 feet");
    }

    public void talk(){
        System.out.println("talks");
    }
}
