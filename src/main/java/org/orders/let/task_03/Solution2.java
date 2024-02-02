package org.orders.let.task_03;

import java.util.LinkedList;

public class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>(); //  создание очереди q, которая будет использоваться для обхода дерева.

        if (root != null) { // Проверка на случай, если дерево не пустое. Если это так, то корневой узел добавляется в очередь.
            q.add(root);
        }

        while (!q.isEmpty()) { // цикл выполняется до тех пор, пока очередь не пуста.
            TreeNode temp = q.poll(); // извлечение первого элемента из очереди и сохранение его в переменной temp.

            if (temp.left != null) { // Проверка наличия левого и правого потомков у текущего узла temp. Если они есть, то они добавляются в очередь.
                q.add(temp.left);
            }

            if (temp.right != null) {
                q.add(temp.right);
            }

            TreeNode curr = temp.left; // Создание временной переменной curr, которой присваивается значение левого потомка текущего узла temp.
            temp.left = temp.right;
            temp.right = curr;
        }

        return root;
    }
}


