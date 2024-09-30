package org.workwork.g_spring.homework_g5.hw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MavenCircleTest {
    @Test
    public void createMavenCircle() {
        MavenCircle mavenCircle = new MavenCircle(3);
        System.out.printf("Maven Circle: %s%n", mavenCircle);
        System.out.printf("Circle's area = %f%n", mavenCircle.getArea());
        System.out.printf("Circle's length = %f%n", mavenCircle.getLength());
        assertEquals(3, mavenCircle.getRadius());
    }
}
