package org.workwork.readfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/app.properties"));
            String myString = prop.getProperty("myString");
            String myString2 = prop.getProperty("myString2");
            System.out.println(myString); // Вывод строки из файла свойств
            System.out.println(myString2); // Вывод строки из файла свойств
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static String readFile(String filePath) {
//        StringBuilder contentBuilder = new StringBuilder();
//
//        try (InputStream inputStream = TargetCPU.class.getClassLoader().getResourceAsStream(filePath)) {
//            if (inputStream != null) {
//                try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
//                    String line;
//                    while ((line = reader.readLine()) != null) {
//                        contentBuilder.append(line);
//                        contentBuilder.append(System.lineSeparator());
//                    }
//                }
//            } else {
//                System.out.println("Файл не найден");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return contentBuilder.toString();
//    }
}

