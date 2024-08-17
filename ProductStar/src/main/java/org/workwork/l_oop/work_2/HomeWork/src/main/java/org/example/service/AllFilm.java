package org.example.service;

import org.example.storage.StorageFilms;

public class AllFilm {

    public void allFilm(){
        for (int i = 0; i < StorageFilms.getFilms().size(); i++){
            System.out.println(StorageFilms.getFilms().get(i)+"\n");
        }
    }
}
