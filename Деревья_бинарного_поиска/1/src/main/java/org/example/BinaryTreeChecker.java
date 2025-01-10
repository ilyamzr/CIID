package org.example;

public class BinaryTreeChecker {

    private static class Node {
        int value;
        int count;
        Node left;
        Node right;

        public Node(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static boolean isBinaryTree(Node root) {
        return checkBinaryTree(root) != -1;
    }

    private static int checkBinaryTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftCount = checkBinaryTree(root.left);
        if (leftCount == -1) return -1;

        int rightCount = checkBinaryTree(root.right);
        if (rightCount == -1) return -1;

        int totalCount = 1 + leftCount + rightCount;

        if (totalCount != root.count) {
            return -1;
        }

        return totalCount;
    }

    public static void main(String[] args) {
        Node root = new Node(5, 6);
        root.left = new Node(10, 3);
        root.right = new Node(15, 2);
        root.left.left = new Node(2, 1);
        root.left.right  = new Node(5, 1);
        root.right.left = null;
        root.right.right  = new Node(1, 1);

        if (isBinaryTree(root)) {
            System.out.println("Дерево корректно");
        } else {
            System.out.println("Дерево некорректно");
        }
    }
}