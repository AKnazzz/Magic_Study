package org.tinkoff.task_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * В предыдущей задаче была рассмотрена система исполнения процессов «T-Saurus».
 * В этой задаче вам предстоит реализовать core-функционал этой системы.
 * Вместо минимального времени, за которое могут быть выполнены все процессы, вам необходимо перечислить их порядок, при котором достигается это время.
 *
 * Для этого вам необходимо разбить все процессы на непересекающиеся множества процессов (пронумеруем их от 1 до k) так,
 * чтобы сначала исполнитель «T-Saurus» параллельно выполнил все процессы первого множества, затем второго множества и т.д., и исполнение процессов удовлетворяло условию из предыдущей задачи.
 * Т. е. в i-ом множестве процессов должны присутствовать только те процессы, для которых все необходимые для их исполнения процессы включены в множествах с меньшими номерами j:1 <= j < i.
 * Напоминаем, что функционал системы «T-Saurus» состоит в том, что при последовательном исполнении предыдущих множеств процессов, все процессы в очередном множестве смогут исполниться.
 *
 * Входные данные совпадают с входными данными из предыдущей задачи. Обратите внимание на то, как должно выводиться каждое множество — все процессы в рамках множества должны быть отсортированы.

 Формат входных данных:

 В первой строке дано число n (1 <= n <= 100000) — количество процессов.
 Далее дано n строк. В i-й строке первым числом идёт ai — количество необходимых i-му процессу процессов.
 Далее идет ai чисел через пробел — их номера.

 Формат выходных данных:

 В единственной строке выведите число k — количество множеств, на которое необходимо разбить все процессы.
 В следующих k строках выведите описание этих множеств:
 первым числом укажите размер множества ki, а далее через пробел ki чисел в порядке возрастания — номера процессов очередного множества.

 */

/*
Для решения задачи о разделении процессов на непересекающиеся множества с учетом их зависимостей,
мы можем использовать алгоритм топологической сортировки и подход с уровнями. Мы будем представлять процессы и их зависимости в виде направленного графа,
где каждая вершина соответствует процессу, а направленное ребро указывает на зависимость.

### Подход к решению:

1. **Строим граф зависимостей**: Создаем список зависимостей для каждого процесса.
2. **Считаем входные степени**: Для каждого процесса подсчитываем количество процессов, от которых он зависит.
3. **Используем очередь**: Сначала добавляем в очередь все процессы без зависимостей.
4. **Топологическая сортировка с уровнями**: При извлечении процесса из очереди мы определяем его уровень (или множество) и добавляем его в соответствующее множество. Если у процесса есть зависимые процессы, мы уменьшаем их входные степени и добавляем в очередь, если все их зависимости завершены.
5. **Сортировка и вывод результатов**: После завершения обработки всех процессов мы сортируем каждое множество и выводим их.

 */

public class TSaurus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение количества процессов
        int n = scanner.nextInt();

        // Список зависимостей и входных степеней
        List<List<Integer>> dependencies = new ArrayList<>();
        int[] inDegree = new int[n + 1];

        // Инициализация списка зависимостей
        for (int i = 0; i <= n; i++) {
            dependencies.add(new ArrayList<>());
        }

        // Чтение зависимостей
        for (int i = 1; i <= n; i++) {
            int ai = scanner.nextInt();
            for (int j = 0; j < ai; j++) {
                int dependency = scanner.nextInt();
                dependencies.get(dependency).add(i); // dependency -> i
                inDegree[i]++; // Увеличиваем входную степень для i
            }
        }

        // Очередь для процессов без зависимостей
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        // Добавляем процессы без зависимостей в очередь
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Процесс топологической сортировки с уровнями
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int currentProcess = queue.poll();
                currentLevel.add(currentProcess);

                for (int dependent : dependencies.get(currentProcess)) {
                    inDegree[dependent]--; // Уменьшаем входную степень для зависимого процесса

                    // Если все зависимости завершены, добавляем в очередь
                    if (inDegree[dependent] == 0) {
                        queue.offer(dependent);
                    }
                }
            }

            // Сортируем текущее множество и добавляем в результат
            Collections.sort(currentLevel);
            result.add(currentLevel);
        }

        // Вывод количества множеств
        System.out.println(result.size());
        for (List<Integer> level : result) {
            System.out.print(level.size() + " ");
            for (int process : level) {
                System.out.print(process + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

//### Объяснение кода:
//
//1. **Структуры данных**:
//   - dependencies: список, где для каждого процесса хранятся его зависимые процессы.
//   - inDegree: массив, который хранит количество зависимостей для каждого процесса.
//
//2. **Чтение входных данных**:
//   - Мы считываем количество процессов и их зависимости, заполняя соответствующие структуры данных.
//
//3. **Инициализация очереди**:
//   - Все процессы без зависимостей добавляются в очередь.
//
//4. **Топологическая сортировка с уровнями**:
//   - Извлекаем процессы из очереди по уровням, добавляя их в текущее множество. Когда все зависимости завершены, добавляем зависимые процессы в очередь.
//
//5. **Вывод результата**:
//   - В конце мы выводим количество множеств и содержимое каждого множества.
//
//### Сложность алгоритма:
//- **Временная сложность**: \\( O(n + m) \\), где \\( n \\) — количество процессов, \\( m \\) — количество зависимостей.
//- **Пространственная сложность**: \\( O(n + m) \\) для хранения графа и входных степеней.