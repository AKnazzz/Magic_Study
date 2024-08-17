package org.example.model;

public class Films {
    private String name;
    private String director;
    private int year;
    private float rating;
    private float time;

    public Films(String name, String director, int year, float rating, float time) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.time = time;
    }

    public Films(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Films{" +
                "name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", time=" + time +
                '}';
    }
}
