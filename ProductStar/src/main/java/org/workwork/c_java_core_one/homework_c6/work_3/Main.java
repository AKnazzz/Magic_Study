package org.workwork.c_java_core_one.homework_c6.work_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Main {
    private static final Pattern pattern = Pattern.compile("^\\(x:(-?\\d+),y:(-?\\d+)\\)-\\(x:(-?\\d+),y:(-?\\d+)\\)");
    // (x:1,y:5)-(x:2,y:6)
    public static void main(String[] args) throws IncorrectFormat, FileNotFoundException {

        Function<String, Double> calculateDistance = str -> {
            try {
                Matcher matcher = pattern.matcher(str);
                if (matcher.find()) {
                    //System.out.println(m.group(0));
                    int x1 = Integer.parseInt(matcher.group(1));
                    int y1 = Integer.parseInt(matcher.group(2));
                    int x2 = Integer.parseInt(matcher.group(3));
                    int y2 = Integer.parseInt(matcher.group(4));
                    Double distance = (Double) sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
                    //System.out.println(distance.toString());
                    return distance;
                } else {
                    throw new IncorrectFormat("Неверный формат строки: " + str);
                }
            } catch (IncorrectFormat e) {
                throw new RuntimeException(e);
            }
        };

        Optional<Double> maxDistance = new BufferedReader( new FileReader("C:\\Users\\Андрей\\dev\\magic\\Magic\\ProductStar\\src\\main\\java\\org\\workwork\\c_java_core_one\\homework_c6\\work_3\\data.txt")).lines()
                .map(calculateDistance)
                .max(Double::compare) ;
        System.out.println( maxDistance.orElseGet(()-> 0.0));
    }
}