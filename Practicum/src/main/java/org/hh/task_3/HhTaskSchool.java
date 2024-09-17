package org.hh.task_3;

/**
 * Дана матрица размером M x N, содержащая большие латинские буквы и строка word, также состоящая из больших латинских букв.
 * <p>
 * Слово может быть составлено из последовательности смежных ячеек с соответствующими буквами, где смежные ячейки являются соседними по горизонтали или вертикали.
 * Одна и та же ячейка с буквой не может быть использована более одного раза.
 * <p>
 * Например:
 * matrix = [
 * ['A', 'F', 'R', 'D', 'H'],
 * ['O', 'L', 'M', 'O', 'E'],
 * ['L', 'M', 'Q', 'L', 'L']
 * ]
 * word = 'HELLO'
 * <p>
 * Задача: Вернуть true, если слово word существует в матрице.
 * Для примера выше вывод будет true , т.к. слово HELLO есть в матрице.
 * <p>
 * Писать код, читающий поток ввода/вывода не надо. Представьте, что у вас есть функция: isWordPresentInMatrix(matrix, word)
 */

public class HhTaskSchool {

    public static void main(String[] args) {
        HhTaskSchool taskSchool = new HhTaskSchool();

        char[][] matrix = {
                {'A', 'F', 'R', 'D', 'H'},
                {'O', 'L', 'M', 'O', 'E'},
                {'L', 'M', 'Q', 'L', 'L'}
        };
        String word = "HELLO";

        System.out.println("Слово: " + word + " найдено в матице ? : " + taskSchool.exist(matrix, word));
    }

    private boolean search(char[][] matrix, String word, int x, int y, int indexInWord) {

        if (indexInWord == word.length()) return true; // если символ последни - то true

        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] != word.charAt(indexInWord))
            return false; // отмекаем некорректные значения


        char symbol = matrix[x][y];
        matrix[x][y] = '*'; // Помечаем что проверили


        boolean found = search(matrix, word, x + 1, y, indexInWord + 1) || // вниз
                search(matrix, word, x - 1, y, indexInWord + 1) || // вверх
                search(matrix, word, x, y + 1, indexInWord + 1) || // вправо
                search(matrix, word, x, y - 1, indexInWord + 1);   // влево


        matrix[x][y] = symbol; // загружаем значение

        return found;
    }


    public boolean exist(char[][] matrix, String word) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (search(matrix, word, i, j, 0)) {

                    return true;
                }
            }
        }

        return false;
    }
}


