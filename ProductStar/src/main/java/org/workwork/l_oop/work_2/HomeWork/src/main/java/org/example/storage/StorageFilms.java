package org.example.storage;

import org.example.model.Films;

import java.util.ArrayList;
import java.util.List;

public class StorageFilms {

    private static List<Films> films = new ArrayList<>();
    public static List<Films> getFilms(){
        return films;
    }

}
