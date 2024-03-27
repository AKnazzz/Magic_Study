package org.workwork;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Андрей\\dev\\magic\\Magic\\src\\main\\java\\org\\workwork\\data.txt"))) {
            List<Integer> maxLength = reader.lines()
                    .map(s -> {
                        String x1 = s.substring(17, 20);
                        String x2 = s.substring(30, 32);
                        Integer X12 = (int) Math.pow(Integer.valueOf(x2) - Integer.valueOf(x1), 2);

                        String y1 = s.substring(23, 25);
                        String y2 = s.substring(35, 37);
                        Integer y12 = (int) Math.pow(Integer.valueOf(y2) - Integer.valueOf(y1), 2);
                        Integer XY12 = (int) Math.sqrt(X12 + y12);

                        return XY12;
                    })
                    .collect(Collectors.toList());

            System.out.println("MAX - " + maxLength.stream()
                    .max(Double::compare)
                    .get());

            maxLength.forEach(s -> System.out.printf("%.2f%n", s));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
