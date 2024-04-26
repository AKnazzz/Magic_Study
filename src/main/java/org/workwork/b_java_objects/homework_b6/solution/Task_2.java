package org.workwork.b_java_objects.homework_b6.solution;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * напиши регулярное выражение для проверки телефона в международном формате
 */

public class Task_2 {
    public static void main(String[] args) {
        String phoneNumber = "+1234567890";
        boolean isValid = validateInternationalPhoneNumber(phoneNumber);

        if (isValid) {
            System.out.println("Телефонный номер " + phoneNumber + " является действительным в международном формате.");
        } else {
            System.out.println("Телефонный номер " + phoneNumber + " не является действительным в международном формате.");
        }
    }

    public static boolean validateInternationalPhoneNumber(String phoneNumber) {
        String regex = "^\\+[1-9]\\d{1,14}$"; // Регулярное выражение для международного телефонного номера
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
}
