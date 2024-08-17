package org.example.drow;

import org.example.api.DrawMeny;
import org.example.service.InletSearch;
import org.example.service.ScanFromCmd;

public class DrawMenyInlet implements DrawMeny {
    InletSearch search = new InletSearch();
    @Override
    public void drawMeny() {
        System.out.println("\nВойт в систему\n" +
                "1.Войти\n" +
                "2.Регестрация\n" +
                "3.Выход");
        search.inletSearch();

    }

}