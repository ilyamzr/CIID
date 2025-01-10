package org.example;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesChecker {

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean checkDuplicates(Node root, List<Integer> keys) {
        if(root == null) return true;
        if (keys.contains(root.value)) return false;
        else
        {
            keys.add(root.value);
            return checkDuplicates(root.left,keys) && checkDuplicates(root.right,keys);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right  = new Node(5);
        root.right.left = null;
        root.right.right  = new Node(1);

        ArrayList<Integer> keys = new ArrayList<>();

        if (checkDuplicates(root,keys)) System.out.println("Дупликатов нет");
        else System.out.println("Дупликаты есть");
    }
}