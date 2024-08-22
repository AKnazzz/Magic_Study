package org.let.internship;

public class Task1 {


    /**
     * Напишите реализацию метода, который делает первую букву каждого слова большой остальные маленькими
     * (гляньте в тесты если не понятно описание выше!)
     * =)
     */
    public String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str; // Возвращаем пустую строку или null, если входная строка пустая
        }

        String[] words = str.split(" "); // Разделяем строку на слова
        StringBuilder capitalizedString = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) { // Проверяем, что слово не пустое
                String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                capitalizedString.append(capitalizedWord).append(" "); // Добавляем слово в результирующую строку
            }
        }

        return capitalizedString.toString().trim(); // Убираем лишний пробел в конце
    }
}
