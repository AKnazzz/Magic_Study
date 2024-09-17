package org.hh.task_4;

/**
 * Дано бинарное дерево. Найдите наименьшего общего предка (LCA) для двух заданных значений в дереве.
 * <p>
 * <p>
 * 1
 * / \
 * 2   3
 * / \ /
 * 4  5 6
 * <p>
 * x=6, y=3 -> Ответ: 3
 */


public class Node {
    int value;
    Node left;
    Node right;

    Node(int x) {
        value = x;
    }

    public Node lowestNode(int a, int b, Node root) {

        if (root == null) return null;
        if (root.value == a || root.value == b) return root;

        Node left = lowestNode(a, b, root.left);
        Node right = lowestNode(a, b, root.right);

        if (left != null && right != null) return root;

        return left != null ? left : right;
    }

}
