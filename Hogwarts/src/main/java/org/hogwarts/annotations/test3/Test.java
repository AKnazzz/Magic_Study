package org.hogwarts.annotations.test3;

@MyAnnotation
public class Test {
    @MyAnnotation
    private String name;

    @MyAnnotation
    public Test(String name) {
        this.name = name;
    }

    @MyAnnotation
    public static void main(String[] args) {

    }

    @MyAnnotation
    public void test(@MyAnnotation int value) {
        @MyAnnotation String localVar = "Hello";
    }
}
