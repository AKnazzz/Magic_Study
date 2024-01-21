package org.workwork.b_java_objects.homework_b6.solution;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Напишите регулярное выражение для проверки ip адреса формата IPv4 на валидность.
 * <p>
 * import java.util.regex.Matcher;
 * import java.util.regex.Pattern;
 */
public class Task2 {
    public static void main(String[] args) {
        String[] samples = {"0.0.0.0", "08.76.222.1", "192.168.0.1"};

        String reg =
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

        Pattern p = Pattern.compile(reg);

        for (String s : samples) {
            Matcher m = p.matcher(s);
            System.out.println(m.matches());
        }
    }
}
