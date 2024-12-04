package org.example;

import java.util.Random;


class BinaryTree {
    Node root;
    Random rand = new Random();

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    void insertRoot(int key) {
        root = insert(root, key);
    }

    Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.value) {
            root.left = insert(root.left, key);
        } else if (key > root.value) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    int averageHeight(int size) {
        int totalHeight = 0;
        for (int i = 0; i < 100; i++) {
            BinaryTree tree = new BinaryTree();
            for (int j = 0; j < size; j++) {
                tree.insertRoot(rand.nextInt());
            }
            totalHeight += tree.height(tree.root);
        }
        return totalHeight / 100;
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] testSizes = {10000, 100000, 1000000};

        for (int N : testSizes) {
            int averageHeight = tree.averageHeight(N);
            double expectedHeight = 2.99 * Math.log(N) / Math.log(2);
            System.out.println("N: " + N + ", Средняя высота: " + averageHeight + ", Ожидаемая высота: " + expectedHeight);
        }
    }
}



