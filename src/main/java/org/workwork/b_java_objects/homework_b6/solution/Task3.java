package org.workwork.b_java_objects.homework_b6.solution;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Напишите регулярное выражение для обнаружения повторяющихся символов.
 * <p>
 * public static void main(String[] args) {
 * <p>
 * String[] samples = {"dgbvawq", "m,kl;po", "cbcbcbc", "z_qwertyuiop_z"}; // false, false, true, true
 * <p>
 * String reg = "(.)
 */

public class Task3 {
    public static void main(String[] args) {

        String[] samples = {"dgbvawq", "m,kl;po", "cbcbcbc", "z_qwertyuiop_z"}; // false, false, true, true

        String reg = "(.).*\\1";

        Pattern p = Pattern.compile(reg);

        for (String s : samples) {
            Matcher m = p.matcher(s);
            System.out.println(m.matches());
        }

    }
}
