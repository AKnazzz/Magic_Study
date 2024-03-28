package org.hogwarts.a8_exceptions.hogwarts81;

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

    public void castSpell(Spell spell) {
        if (age <= 11 && spell.getPower() != 1) {
            throw new SpellCastException(name + " can only use spells with power 1");
        } else if (age <= 12 && spell.getPower() > 2) {
            throw new SpellCastException(name + " can only use spells with power up to 2");
        } else if (age <= 13 && spell.getPower() > 3) {
            throw new SpellCastException(name + " can only use spells with power up to 3");
        } else if (age <= 14 && spell.getPower() > 4) {
            throw new SpellCastException(name + " can only use spells with power up to 4");
        } else if (age <= 15 && spell.getPower() > 5) {
            throw new SpellCastException(name + " can only use spells with power up to 5");
        } else if (age <= 16 && spell.getPower() > 6) {
            throw new SpellCastException(name + " can only use spells with power up to 6");
        }

        System.out.println(name + " used spell: " + spell.getTitle());
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