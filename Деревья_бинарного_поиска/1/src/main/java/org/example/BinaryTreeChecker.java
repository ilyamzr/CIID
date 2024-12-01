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

    public static boolean isBinaryTree(Node root){
        if(root == null) return true;
        else
        {
            int count = countNodes(root);
            return count == root.count && isBinaryTree(root.left) && isBinaryTree(root.right);
        }
    }

    public static int countNodes(Node root){
        if (root == null) return 0;
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(5, 6);
        root.left = new Node(10, 3);
        root.right = new Node(15, 2);
        root.left.left = new Node(2, 1);
        root.left.right  = new Node(5, 1);
        root.right.left = null;
        root.right.right  = new Node(1, 1);

        if (isBinaryTree(root)) System.out.println("Дерево корректно");
        else System.out.println("Дерево некорректно");
    }
}