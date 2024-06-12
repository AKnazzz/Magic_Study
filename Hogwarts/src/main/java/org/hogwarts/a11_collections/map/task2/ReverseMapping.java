package org.hogwarts.a11_collections.map.task2;

import java.util.HashMap;

/**
 * Вам дана HashMap, которая содержит отображение столиц на страны.
 * Создайте новый HashMap с названием countryCapitalMap, который будет содержать отображение стран на столицы.
 * То есть такой же, но наоборот!
 */

public class ReverseMapping {
    public static void main(String[] args) {
        HashMap<String, String> capitalCountryMap = new HashMap<>();
        capitalCountryMap.put("Paris", "France");
        capitalCountryMap.put("Berlin", "Germany");
        capitalCountryMap.put("Rome", "Italy");

        HashMap<String, String> countryCapitalMap = new HashMap<>();

        for (String capital : capitalCountryMap.keySet()) {
            String country = capitalCountryMap.get(capital);
            countryCapitalMap.put(country, capital);
        }

        // Вывод для проверки
        for (String country : countryCapitalMap.keySet()) {
            String capital = countryCapitalMap.get(country);
            System.out.println("Страна: " + country + ", Столица: " + capital);
        }
    }
}

