package org.example.service;

import org.example.api.Scann;
import java.util.Scanner;

public class ScanFromCmd implements Scann {
    public String scanFromCmd(){
        return scann();
    }

    @Override
    public String scann() {
        String x = scanner.nextLine();
        return x;
    }
}
