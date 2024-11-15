package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoveToFront {

    private static final Logger logger = Logger.getLogger(MoveToFront.class.getName());

    private Node head;
    private int size;

    private static class Node {
        char item;
        Node next;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean hasMet(char character) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.item == character) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    public void createNewHead(char character) {
        Node oldHead = head;
        head = new Node();
        head.item = character;
        head.next = oldHead;
        size++;
    }

    public void moveToFront(char character) {
        if (isEmpty()) {
            createNewHead(character);
        } else {
            if (!hasMet(character)) {
                createNewHead(character);
            } else {
                Node currentNode = head;
                Node previousNode = null;
                while (currentNode != null && currentNode.item != character) {
                    previousNode = currentNode;
                    currentNode = currentNode.next;
                }
                if (currentNode != null && previousNode != null) {
                    previousNode.next = currentNode.next;
                    size--;
                }
                createNewHead(character);
            }
        }
    }

    public void printList() {
        Node currentNode = head;
        logger.info("Current list: ");
        while (currentNode != null) {
            logger.log(Level.INFO, "{0}", currentNode.item);
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logger.info("Введите символы: ");
        String input;
        MoveToFront list = new MoveToFront();
        while (true) {
            input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            } else if (input.length() == 1) {
                char character = input.charAt(0);
                list.moveToFront(character);
                list.printList();
            } else {
                logger.warning("Пожалуйста, введите один символ.");
            }
        }
    }
}