package org.workwork;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try {
            List<Double> maxLength = new BufferedReader(new FileReader("C:\\Users\\Андрей\\dev\\magic\\Magic\\src\\main\\java\\org\\workwork\\data.txt"))
                    .lines()
                    .map(s->{
                        String x1 = s.substring(17,20);
                        String numberAsStringX = s.toString();
                        String x2 = numberAsStringX.substring(30,32);
                        Double X12 = Math.pow(Double.valueOf(x2) -Double.valueOf(x1),2);

                        String y1 = s.substring(23,25);
                        String numberAsStringY = s.toString();
                        String y2 = numberAsStringY.substring(35,37);
                        Double y12 = Math.pow(Double.valueOf(y2) -Double.valueOf(y1),2);
                        Double XY12 = Math.sqrt(X12 + y12);
                        String XY = String.valueOf(XY12);

                        return Double.parseDouble(XY);
                    }).collect(Collectors.toList());

            maxLength.stream()
                    .max(Double::compare);
            System.out.println(" MAX - " + maxLength.stream()
                    .max(Double::compare));

            maxLength.stream()
                    .forEach(s-> System.out.println(s));


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
