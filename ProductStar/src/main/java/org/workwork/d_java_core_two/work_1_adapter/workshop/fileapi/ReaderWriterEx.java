package org.workwork.d_java_core_two.work_1_adapter.workshop.fileapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ReaderWriterEx {
    public static void main(String[] args) throws IOException {
        //создадим список для хранения строк
        List<String> list = new ArrayList<>();

        //открываем файл
        File file = new File("documentIO.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        //пока файл не пуст - читаем из него
        while (reader.ready()) {
            list.add(reader.readLine());
        }
        reader.close();

        System.out.println(list);

        File file2 = new File("documentIO.txt");
        List list2 = Files.readAllLines(file2.toPath(), Charset.defaultCharset());
        System.out.println(list2);
    }

}
