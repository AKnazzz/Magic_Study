package org.hogwarts.regEx.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskRegEx5 {
    public static void main(String[] args) {
        String cardsNumbers
                = "12345678912345678932145;12345678912345678932145;12345678912345678932145;12345678912345678932145";

        Pattern pattern = Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{2})(\\d{2})(\\d{3})"); // = d{23}
        Matcher matcher = pattern.matcher(cardsNumbers);

        String myNewString = matcher.replaceAll(" $5/$6 $1 $2 $3 $4 ($7)");

        System.out.println(myNewString);

    }
}
