package org.hogwarts.a6_oop.hogwarts61.beast;

public class Student {
    private String name;
    private String faculty;
    private int age;
    private String[] specialSkills = new String[3];

    public Student(String name, String faculty, int age, String[] specialSkills) {
        this.name = name;
        this.faculty = faculty;
        this.age = age;
        if (specialSkills.length <= 3) {
            System.arraycopy(specialSkills, 0, this.specialSkills, 0, specialSkills.length);
        } else {
            System.arraycopy(specialSkills, 0, this.specialSkills, 0, 3);
        }
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getAge() {
        return age;
    }

    public String[] getSpecialSkills() {
        return specialSkills;
    }
}