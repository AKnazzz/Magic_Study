package org.workwork.g_spring.homework_g2.work_1.Shirak.src.main.java;

public class Result {

    private String name;
    private String gender;
    private String distance;
    private String time;

    public Result(String name, String gender, String distance, String time) {
        this.name = name;
        this.gender = gender;
        this.distance = distance;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDistance() {
        return distance;
    }

    public String getTime() {
        return time;
    }
}

