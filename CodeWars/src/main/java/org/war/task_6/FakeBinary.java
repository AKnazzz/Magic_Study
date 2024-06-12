package org.war.task_6;

/**
 * Given a string of digits, you should replace any digit below 5 with '0' and any digit 5 and above with '1'. Return the resulting string.
 * <p>
 * Note: input will never be an empty string
 */
public class FakeBinary {
    public static String fakeBin(String numberString) {
        StringBuilder result = new StringBuilder();
        for (char c : numberString.toCharArray()) {
            if (Character.getNumericValue(c) < 5) {
                result.append('0');
            } else {
                result.append('1');
            }
        }
        return result.toString();
    }
}

// return numberString.replaceAll("[0-4]", "0").replaceAll("[5-9]", "1");