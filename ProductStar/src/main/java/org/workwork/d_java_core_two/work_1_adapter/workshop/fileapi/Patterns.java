package org.workwork.d_java_core_two.work_1_adapter.workshop.fileapi;

import java.io.*;

public class Patterns {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("NewFile.txt"));

        outputStreamWriter.write("113452233");
        outputStreamWriter.close();
    }
}
