package org.example;

public class Deque<I> implements AbstractDeque<I> {

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
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
        DequeManager manager = new DequeManager(deque);
        manager.manageDeque();
    }
}