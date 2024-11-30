package org.example;

import java.util.Scanner;

public class Deque<I> {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        I item;
        Node next;
        Node prev;
    }

    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void pushLeft(I item) {
        Node newHead = new Node();
        newHead.item = item;
        newHead.next = head;
        newHead.prev = null;

        if (isEmpty()) {
            tail = newHead;
        } else {
            head.prev = newHead;
        }
        head = newHead;
        size++;
    }

    public void pushRight(I item) {
        Node newTail = new Node();
        newTail.item = item;
        newTail.prev = tail;
        newTail.next = null;

        if (isEmpty()) {
            head = newTail;
        } else {
            tail.next = newTail;
        }
        tail = newTail;
        size++;
    }

    public I popLeft() {
        if (isEmpty()) {
            throw new IllegalStateException("Дек пуст");
        }
        I item = head.item;
        head = head.next;

        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return item;
    }

    public I popRight() {
        if (isEmpty()) {
            throw new IllegalStateException("Дек пуст");
        }
        I item = tail.item;
        tail = tail.prev;

        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return item;
    }

    public void printDeque() {
        Node current = head;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1) Вставить в начало\n2) Вставить в конец\n3) Удалить из начала\n4) Удалить из конца\n5) Закончить");
            int choice = Integer.parseInt(scanner.nextLine());
            int item;
            switch (choice) {
                case 1:
                    System.out.print("Введите число: ");
                    item = Integer.parseInt(scanner.nextLine());
                    deque.pushLeft(item);
                    break;
                case 2:
                    System.out.print("Введите число: ");
                    item = Integer.parseInt(scanner.nextLine());
                    deque.pushRight(item);
                    break;
                case 3:
                    try {
                        item = deque.popLeft();
                        System.out.println("Удален элемент: " + item);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        item = deque.popRight();
                        System.out.println("Удален элемент: " + item);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Выход...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
            System.out.println("Текущее состояние дека: ");
            deque.printDeque();
        }
    }
}