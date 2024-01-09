package org.workwork.d_java_core_one.homework_d6.work_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {
        try {
            Optional<Segment> max =  new BufferedReader(new FileReader("data.txt")).lines()
                    .map(s -> readString(s))
                    .max(Segment::compareTo);
            if(max.isEmpty()){
                System.out.println("No numbers.");
            } else {
                System.out.println(max.get());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static Segment readString (String str) {
        LinkedList<Double> lines = new LinkedList<>();

        Pattern pattern = Pattern.compile("[0-9\\.]+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            lines.add(Double.valueOf(str.substring(matcher.start(), matcher.end())));
        }
        if (lines.size() != 4){
            throw new IllegalArgumentException("String " + str + " is wrong.");
        }
        return new Segment(lines.get(0), lines.get(2), lines.get(1), lines.get(3));
    }
}
