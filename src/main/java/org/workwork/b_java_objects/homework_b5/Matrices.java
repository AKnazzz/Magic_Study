package org.workwork.b_java_objects.homework_b5;

import java.util.Arrays;

public class Matrices {
    static <T> T todo() {
        throw new UnsupportedOperationException("Метод не реализован");
    }

    /**
     * Вектор длины n
     */
    public static class Vector {
        private final int[] items;

        /**
         * Создает нулевой вектор длины n
         */
        public Vector(int n) {
            this.items = new int[n];
        }


        public Vector(int[] items) {
            this.items = items;
        }


        public Vector add(Vector other) {
            if (items.length != other.items.length) {
                throw new IllegalArgumentException(
                        "Длины векторов должны совпадать для сложения.");
            }

            int[] result = new int[items.length];
            for (int i = 0; i < items.length; i++) {
                result[i] = items[i] + other.items[i];
            }
            return new Vector(result);
        }


        public Vector subtract(Vector other) {
            if (items.length != other.items.length) {
                throw new IllegalArgumentException(
                        "Длины векторов должны совпадать для вычитания.");
            }

            int[] result = new int[items.length];
            for (int i = 0; i < items.length; i++) {
                result[i] = items[i] - other.items[i];
            }
            return new Vector(result);
        }


        public int dotProduct(Vector other) {
            if (items.length != other.items.length) {
                throw new IllegalArgumentException(
                        "Длины векторов должны совпадать для скалярного произведения.");
            }

            int result = 0;
            for (int i = 0; i < items.length; i++) {
                result += items[i] * other.items[i];
            }
            return result;
        }


        public Vector scalarMultiply(int scalar) {
            int[] result = new int[items.length];
            for (int i = 0; i < items.length; i++) {
                result[i] = items[i] * scalar;
            }
            return new Vector(result);
        }

        /**
         * Вычисляет длину (норму) данного вектора.
         */
        public double length() {
            double sum = 0;
            for (int item : items) {
                sum += item * item;
            }
            return Math.sqrt(sum);
        }

        @Override
        public String toString() {
            return Arrays.toString(items);
        }
    }


    public static class Matrix {
        private final int nRows;
        private final int nCols;
        private final int[][] rows;


        public Matrix(int nRows, int nCols) {
            this.nRows = nRows;
            this.nCols = nCols;
            this.rows = new int[nRows][nCols];
        }


        @Override
        public String toString() {
            int[] colWidths = new int[nCols];
            for (int col = 0; col < nCols; col++) {
                int maxWidth = 0;
                for (int row = 0; row < nRows; row++) {
                    int width = Integer.toString(rows[row][col]).length();
                    maxWidth = Math.max(maxWidth, width);
                }
                colWidths[col] = maxWidth;
            }

            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < nRows; row++) {
                for (int col = 0; col < nCols; col++) {
                    String cell = String.format("%" + colWidths[col] + "d", rows[row][col]);
                    sb.append(cell);
                    if (col < nCols - 1) {
                        sb.append(" ");
                    }
                }
                if (row < nRows - 1) {
                    sb.append("\n");
                }
            }
            return sb.toString();
        }

        public Matrix add(Matrix other) {
            if (nRows != other.nRows || nCols != other.nCols) {
                throw new IllegalArgumentException(
                        "Размеры матриц не совпадают для операции сложения.");
            }

            Matrix result = new Matrix(nRows, nCols);
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nCols; j++) {
                    result.rows[i][j] = this.rows[i][j] + other.rows[i][j];
                }
            }
            return result;
        }

        public Matrix subtract(Matrix other) {
            if (nRows != other.nRows || nCols != other.nCols) {
                throw new IllegalArgumentException(
                        "Размеры матриц не совпадают для операции вычитания.");
            }

            Matrix result = new Matrix(nRows, nCols);
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nCols; j++) {
                    result.rows[i][j] = this.rows[i][j] - other.rows[i][j];
                }
            }
            return result;
        }

        public Matrix multiply(Matrix other) {
            if (nCols != other.nRows) {
                throw new IllegalArgumentException(
                        "Количество столбцов первой матрицы должно быть равно " +
                                "количеству строк второй матрицы для операции умножения.");
            }

            Matrix result = new Matrix(nRows, other.nCols);
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < other.nCols; j++) {
                    for (int k = 0; k < nCols; k++) {
                        result.rows[i][j] += this.rows[i][k] * other.rows[k][j];
                    }
                }
            }
            return result;
        }


        public Matrix scalarMultiply(int scalar) {
            Matrix result = new Matrix(nRows, nCols);
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nCols; j++) {
                    result.rows[i][j] = this.rows[i][j] * scalar;
                }
            }
            return result;
        }

        public Matrix transpose() {
            Matrix result = new Matrix(nCols, nRows);
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nCols; j++) {
                    result.rows[j][i] = this.rows[i][j];
                }
            }
            return result;
        }

        public int determinant() {
            if (nRows != nCols) {
                throw new IllegalArgumentException(
                        "Матрица должна быть квадратной для вычисления определителя.");
            }

            return determinant(this.rows);
        }

        private static int determinant(int[][] matrix) {
            // Базовый случай для матрицы 1x1
            if (matrix.length == 1) {
                return matrix[0][0];
            }

            // Базовый случай для матрицы 2x2
            if (matrix.length == 2) {
                return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
            }

            int result = 0;
            // Итерация по элементам первой строки матрицы
            for (int i = 0; i < matrix.length; i++) {
                // Создание матрицы для поддетерминанта
                int[][] smallerMatrix = new int[matrix.length - 1][matrix.length - 1];
                for (int row = 1; row < matrix.length; row++) {
                    int colIndex = 0;
                    for (int col = 0; col < matrix.length; col++) {
                        // Пропуск столбца i, т.к. его элементы участвуют в разложении
                        if (col != i) {
                            smallerMatrix[row - 1][colIndex] = matrix[row][col];
                            colIndex++;
                        }
                    }
                }

                // Вычисление поддетерминанта рекурсивным вызовом
                int subDeterminant = determinant(smallerMatrix);

                // Определение знака для элемента i разложения
                int sign = (i % 2 == 0) ? 1 : -1;

                // Обновление результата с учетом элемента i разложения, его знака и поддетерминанта
                result += sign * matrix[0][i] * subDeterminant;
            }
            return result;
        }

    }

    public static void main(String[] args) {
        // Пример создания нулевого вектора длины 3
        Vector zeroVector = new Vector(3);
        System.out.println("Нулевой вектор длины 3: " + zeroVector);

        // Пример создания вектора с заданными элементами
        int[] items = {1, 2, 3};
        Vector vectorA = new Vector(items);
        System.out.println("Вектор A: " + vectorA);

        // Пример сложения двух векторов
        int[] itemsB = {4, 5, 6};
        Vector vectorB = new Vector(itemsB);
        System.out.println("Вектор B: " + vectorB);
        Vector sumVector = vectorA.add(vectorB);
        System.out.println("Сумма векторов A и B: " + sumVector);

        // Пример вычитания двух векторов
        Vector diffVector = vectorA.subtract(vectorB);
        System.out.println("Разность векторов A и B: " + diffVector);

        // Пример скалярного произведения двух векторов
        int dotProduct = vectorA.dotProduct(vectorB);
        System.out.println("Скалярное произведение векторов A и B: " + dotProduct);

        // Пример умножения вектора на скаляр
        int scalar = 2;
        Vector scalarProduct = vectorA.scalarMultiply(scalar);
        System.out.println("Умножение вектора A на скаляр 2: " + scalarProduct);

        // Пример вычисления длины (нормы) вектора
        double length = vectorA.length();
        System.out.println("Длина (норма) вектора A: " + length);

        // Создание матрицы A 2x2
        Matrix A = new Matrix(2, 2);
        A.rows[0] = new int[]{1, 2};
        A.rows[1] = new int[]{3, 4};
        System.out.println("Matrix A:");
        System.out.println(A.toString());

        // Создание матрицы B 2x2
        Matrix B = new Matrix(2, 2);
        B.rows[0] = new int[]{2, 0};
        B.rows[1] = new int[]{1, 2};
        System.out.println("Matrix B:");
        System.out.println(B.toString());

        // Сложение матриц A и B
        Matrix C = A.add(B);
        System.out.println("Matrix A + B:");
        System.out.println(C.toString());

        // Вычитание матриц B из A
        Matrix D = A.subtract(B);
        System.out.println("Matrix A - B:");
        System.out.println(D.toString());

        // Умножение матриц A и B
        Matrix E = A.multiply(B);
        System.out.println("Matrix A * B:");
        System.out.println(E.toString());

        // Умножение матрицы A на скаляр
        int scalar3 = 3;
        Matrix F = A.scalarMultiply(scalar3);
        System.out.println("Matrix A * " + scalar3 + ":");
        System.out.println(F.toString());

        // Транспонирование матрицы A
        Matrix G = A.transpose();
        System.out.println("Matrix A Transpose:");
        System.out.println(G.toString());

        // Создание квадратной матрицы 3x3
        Matrix H = new Matrix(3, 3);
        H.rows[0] = new int[]{4, 3, 2};
        H.rows[1] = new int[]{1, 3, 1};
        H.rows[2] = new int[]{2, 1, 4};
        System.out.println("Matrix H:");
        System.out.println(H.toString());

        // Вычисление определителя матрицы H
        int det = H.determinant();
        System.out.println("Determinant of Matrix H:");
        System.out.println(det);

    }
}