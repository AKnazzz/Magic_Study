package org.example.drow;

import org.example.api.DrawMeny;
import org.example.api.SearchNumber;
import org.example.service.AdminSearch;
import org.example.service.InletSearch;
import org.example.service.ScanFromCmd;

public class DrawMenyAdmin implements DrawMeny {

    @Override
    public void drawMeny() {
        System.out.println("\nМеню\n" +
                "1.Фильмы\n" +
                "2.Пользователи\n" +
                "3.Выход\n");

    }
   public void drawMenyAdmin(){
        drawMeny();
        new AdminSearch().adminSearch();
    }

}
