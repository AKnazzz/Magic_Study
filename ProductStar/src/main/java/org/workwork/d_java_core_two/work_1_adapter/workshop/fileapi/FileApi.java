package org.workwork.d_java_core_two.work_1_adapter.workshop.fileapi;

import java.io.File;
import java.io.IOException;

public class FileApi {
    public static void main(String[] args) {

        File dir = new File("C:\\Users");

        if (dir.isDirectory()) {
            for (File item : dir.listFiles()) {

                if (item.isDirectory()) {
                    System.out.println(item.getName() + " \t folder");
                } else {
                    System.out.println(item.getName() + " \t file");
                }
            }
        }
    }
}

class FileApi2 {
    public static void main(String[] args) throws IOException {

        File myFile = new File("documentIO.txt");
        System.out.println("File name: " + myFile.getName());
        System.out.println("Parent folder: " + myFile.getParent());

        if (myFile.exists()) {
            System.out.println("File exist.");
        } else {
            System.out.println("File not found");
        }

        System.out.println("File size: " + myFile.length());

        if (myFile.canRead()) {
            System.out.println("File can be read");
        } else {
            System.out.println("File can not be read");
        }

        if (myFile.canWrite()) {
            System.out.println("File can be write");
        } else {
            System.out.println("File can not be write");
        }

        // Создадим новый файл
        File newFile = new File("NewFile.txt");
        try {
            boolean created = newFile.createNewFile();
            if (created) {
                System.out.println("File has been created");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(newFile.getAbsolutePath());
        System.out.println(newFile.canRead());
        System.out.println(newFile.canWrite());
        System.out.println(newFile.exists());
        System.out.println(newFile.getName());
        System.out.println(newFile.getParent());
        System.out.println(newFile.getPath());
        System.out.println(newFile.lastModified());
        System.out.println(newFile.isFile());
        System.out.println(newFile.isDirectory());
        System.out.println(newFile.isAbsolute());
    }
}
