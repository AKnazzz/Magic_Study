package org.let.task_faang_3;

/**
 * Задача — Объединяем отсортированные связанные списки
 * <p>
 * Даны головы двух отсортированных связанных списков list1 и list2.
 * <p>
 * Объедините два списка в один отсортированный список. Список должен быть создан путем объединения узлов первых двух списков.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class MergeSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Создаем фиктивный узел для упрощения работы с головой нового списка
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Указатели для обоих списков
        ListNode p1 = list1;
        ListNode p2 = list2;

        // Пока оба списка не пусты
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                current.next = p1; // Присоединяем узел из первого списка
                p1 = p1.next;      // Переходим к следующему узлу в первом списке
            } else {
                current.next = p2; // Присоединяем узел из второго списка
                p2 = p2.next;      // Переходим к следующему узлу во втором списке
            }
            current = current.next; // Перемещаем указатель текущего узла
        }

        // Присоединяем оставшиеся узлы, если есть
        if (p1 != null) {
            current.next = p1;
        } else if (p2 != null) {
            current.next = p2;
        }

        // Возвращаем следующий узел после фиктивного (это будет голова нового списка)
        return dummy.next;
    }

    public static void main(String[] args) {
        // Пример использования
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        MergeSortedLists merger = new MergeSortedLists();
        ListNode mergedList = merger.mergeTwoLists(list1, list2);

        // Выводим объединенный список
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}

/*

### Объяснение кода:
1. **Класс ListNode**: Это класс для представления узла связанного списка, содержащий значение и ссылку на следующий узел.

2. **Метод mergeTwoLists**:
   - Создается фиктивный узел dummy, который упрощает добавление новых узлов в результирующий список.
   - Используются два указателя p1 и p2, чтобы пройти по обоим спискам.
   - В цикле сравниваются значения узлов из обоих списков, и меньший узел добавляется в результирующий список.
   - После завершения цикла оставшиеся узлы одного из списков добавляются в конец результирующего списка.

3. **Метод main**: Пример использования метода с созданием двух отсортированных списков и выводом результата.

Этот код эффективно объединяет два отсортированных связанных списка за линейное время O(n + m), где n и m — длины двух списков.
 */