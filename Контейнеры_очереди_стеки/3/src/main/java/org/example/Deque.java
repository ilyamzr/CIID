package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class Deque<I> {

    private static final Logger logger = Logger.getLogger(Deque.class.getName());

    private Node head;
    private Node tail;
    private int size;

    private class Node{
        I item;
        Node next;
        Node prev;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void pushLeft(I item)
    {
        Node oldHead = head;
        head = new Node();
        head.next = oldHead;
        head.item = item;
        head.prev = null;
        if (!isEmpty())
        {
            oldHead.prev = head;
        }
        else head.next = null;
        size++;
    }
    public void pushRight(I item)
    {
        Node oldTail = tail;
        tail = new Node();
        tail.prev = oldTail;
        tail.next = null;
        tail.item = item;
        if(!isEmpty())
        {
            oldTail.next = tail;
        }
        else tail.prev = null;
        size++;
    }

    public I popLeft()
    {
        if (!isEmpty())
        {
            I item = head.item;
            head = head.next;
            head.prev = null;
            size--;
            return item;
        }
        else return null;
    }
    public I popRight()
    {
        if (!isEmpty())
        {
            I item = tail.item;
            tail = tail.prev;
            tail.next = null;
            size--;
            return item;
        }
        else return null;
    }

    public void printDeque() {
        Node current = head;
        while (current != null) {
            logger.info(current.item + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            logger.info("1) Вставить в начало\n2) Вставить в конец\n3) Удалить из начала\n4) Удалить из конца\n5) Закончить");
            int choice = Integer.parseInt(scanner.nextLine());
            int item;
            switch (choice) {
                case 1:
                    logger.info("Введите число: ");
                    item = Integer.parseInt(scanner.nextLine());
                    deque.pushLeft(item);
                    break;
                case 2:
                    logger.info("Введите число: ");
                    item = Integer.parseInt(scanner.nextLine());
                    deque.pushRight(item);
                    break;
                case 3:
                    item = deque.popLeft();
                    logger.log(Level.INFO, String.format("Удален элемент: %d", item));
                    break;
                case 4:
                    item = deque.popRight();
                    logger.log(Level.INFO, String.format("Удален элемент: %d", item));
                    break;
                case 5:
                    logger.info("Выход...");
                    scanner.close();
                    return;
                default:
                    logger.info("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
            logger.info("Текущее состояние дека: ");
            deque.printDeque();
        }
    }
}

