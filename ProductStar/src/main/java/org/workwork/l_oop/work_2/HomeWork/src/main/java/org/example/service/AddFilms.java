package org.example.service;

import org.example.api.Scann;
import org.example.drow.DrawAdminFilmsMeny;
import org.example.model.Films;
import org.example.storage.StorageFilms;

public class AddFilms implements Scann {

    public void addFilms(){
        System.out.println(scann());
        new DrawAdminFilmsMeny().drawMeny();
    }

    @Override
    public String scann() {

        System.out.print("Название фильма: ");
        String name = scanner.nextLine().trim();
        if (isFilmExists(name)) {
            return "Название фильма уже существует.";
        }

        System.out.print("Фамилия режисера: ");
        String director = scanner.nextLine().trim();

        System.out.print("Год выпуска: ");
        int year = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Рейтинг: ");
        float price = Float.parseFloat(scanner.nextLine().trim());

        System.out.print("Время: ");
        float rating = Float.parseFloat(scanner.nextLine().trim());

        Films films = new Films(name, director, year, price, rating);
        StorageFilms.getFilms().add(films);

        return "Фильм добавлен\n";
    }

    private boolean isFilmExists(String name) {
        for (Films films : StorageFilms.getFilms()) {
            if (films.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public String removeFilmByName() {
        Films filmToRemove = null;
        System.out.print("Введите название фильма которого хотите удалить:");
        String name = scanner.nextLine().trim();

        for (Films films : StorageFilms.getFilms()) {
            if (films.getName().equalsIgnoreCase(name)) {
                filmToRemove = films;
                break;
            }
        }
        if (filmToRemove != null) {
            StorageFilms.getFilms().remove(filmToRemove);
            return "Фильм удален\n";
        } else {
            return "Фильм с таким названием не найден\n";
        }
    }
}
