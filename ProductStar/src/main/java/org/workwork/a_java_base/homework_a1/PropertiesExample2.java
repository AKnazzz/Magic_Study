package org.workwork.a_java_base.homework_a1;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class PropertiesExample2 {
    public static void main(String[] args) {
        String name = System.getProperty("name");
        int random = 3012340;
        String encoded = Base64.getEncoder().encodeToString(("" + random).getBytes(StandardCharsets.UTF_8));
        System.out.println(name + " " + encoded);
    }
}