package org.hogwarts.regEx.task;

import java.util.regex.Pattern;

public class TaskRegEx2ip {

    void checkIP(String ip){
        String regEx = "((25[0-5]|2[0-4]\\d|[01]?\\d?\\d)(\\.)){3}(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)";
        System.out.println(ip + " is OK? "+ Pattern.matches(regEx,ip));
    }

    public static void main(String[] args) {

        // 0-255.0-255.0-255.0-255

        String ip1 = "255.38.195.99";
        String ip2 = "182.262.91.05";

        TaskRegEx2ip taks = new TaskRegEx2ip();

        taks.checkIP(ip1);
        taks.checkIP(ip2);

    }
}
