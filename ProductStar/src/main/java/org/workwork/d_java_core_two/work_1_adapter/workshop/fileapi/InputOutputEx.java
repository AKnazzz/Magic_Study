package org.workwork.d_java_core_two.work_1_adapter.workshop.fileapi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputOutputEx {
    public static void main(String[] args) throws IOException {

        //создаём поток чтения байт из файла
        FileInputStream inputStream = new FileInputStream("dataIO.txt"); // для чтения

        //создаём поток записи байт в файл
        FileOutputStream outputStream = new FileOutputStream("resultIO.txt"); // для записи

        byte[] buffer = new byte[1000];
        while (inputStream.available() > 0){ // пока есть непрочитанные байты
            // прочитать очередной блок байт в переменную buffer и реальное кол-во в count
            int count = inputStream.read(buffer);
            //записать блок во второй поток
            outputStream.write(buffer,0,count);
        }

        inputStream.close();
        outputStream.close();

    }
}
