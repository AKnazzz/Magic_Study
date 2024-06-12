package org.hogwarts.algoritm.binary;

public class Practicum {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 8, 12, 13, 20, 22, 24, 30, 32};

        System.out.println("Индекс искомого элемента: " + findBinary(array, 30));
    }

    public static int findBinary(int[] array, int elem) {
        int index = -1;

        // задаём границы области поиска
        int low = 0;
        int high = array.length - 1;

        // поиск продолжается до тех пор, пока границы заданы правильно:
        // левая граница левее или совпадает с правой и наоборот
        while (low <= high) {

            // вычисляем середину
            int mid = low + ((high - low) / 2);

            // если элемент в середине меньше искомого — передвигаем левую границу вправо от середины
            if (array[mid] < elem) {
                low = mid + 1;

                // если больше искомого — передвигаем правую границу влево от середины
            } else if (array[mid] > elem) {
                high = mid - 1;

                // если элемент в середине совпадает с искомым, поиск завершается
            } else if (array[mid] == elem) {
                index = mid;
                break;
            }
        }
        return index;
    }
}
