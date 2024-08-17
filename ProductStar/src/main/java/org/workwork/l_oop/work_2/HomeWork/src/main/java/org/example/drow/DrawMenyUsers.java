package org.example.drow;

import org.example.api.DrawMeny;
import org.example.api.SearchNumber;
import org.example.service.InletSearch;
import org.example.service.ScanFromCmd;
import org.example.service.UserSearch;

public class DrawMenyUsers implements DrawMeny {

    @Override
    public void drawMeny() {
        System.out.println("Меню\n" +
                "1.Фильмы\n" +
                "2.Выход\n");
        new UserSearch().userSearch();

    }
}
