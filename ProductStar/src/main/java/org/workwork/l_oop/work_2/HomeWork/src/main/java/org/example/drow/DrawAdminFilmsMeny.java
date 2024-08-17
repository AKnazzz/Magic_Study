package org.example.drow;

import org.example.api.DrawMeny;
import org.example.api.SearchNumber;
import org.example.service.AdminFilmSearch;

public class DrawAdminFilmsMeny implements DrawMeny {
    @Override
    public void drawMeny() {
        System.out.println("Меню\n" +
                "1.Добавить Фильм\n" +
                "2.Удалить Фильм\n" +
                "3.Все фильмы\n" +
                "4.Назад\n");
        new AdminFilmSearch().adminFilmSearch();
    }

}
