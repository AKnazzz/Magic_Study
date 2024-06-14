package org.workwork.c_java_core_one.homework_c6.work_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class VectorCheck {

    double length = 0.0;

    public static double calcLength(String line) {
        double[] pos = Pattern.compile("\\d+")
                .matcher(line)
                .results()
                .mapToDouble(matchResult -> Double.parseDouble(matchResult.group()))
                .toArray();
        if (pos.length == 4) {
            return Math.sqrt(((pos[2] - pos[0]) * (pos[2] - pos[0])) + ((pos[3] - pos[1]) * (pos[3] - pos[1])));
        } else return 0.0;
    }

    public void getMaxVectorFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/main/java/org/workwork/d_java_core_one/homework_d6/work_2/" + filename + ".txt"))) {
            double v = reader.lines()
                    .mapToDouble(VectorCheck::calcLength)
                    .max()
                    .orElse(0.0);
            System.out.println(v);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
