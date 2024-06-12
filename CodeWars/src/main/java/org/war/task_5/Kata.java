package org.war.task_5;

/**
 * Can you find the needle in the haystack?
 * <p>
 * Write a function findNeedle() that takes an array full of junk but containing one "needle"
 * <p>
 * After your function finds the needle it should return a message (as a string) that says:
 * <p>
 * "found the needle at position " plus the index it found the needle, so:
 * <p>
 * Example(Input --> Output)
 * <p>
 * ["hay", "junk", "hay", "hay", "moreJunk", "needle", "randomJunk"] --> "found the needle at position 5"
 */
public class Kata {
    public static String findNeedle(Object[] haystack) {
        // Your code here
        String message = null;
        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] != null && haystack[i].equals("needle")) {
                message = "found the needle at position " + i;
            }
        }
        return message;
    }
}

//  return "found the needle at position " + Arrays.asList(haystack).indexOf("needle");