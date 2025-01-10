package org.example;

public class ResizingDequeArray<I> implements AbstractDeque<I> {

    private I[] array;
    private int head;
    private int tail;
    private int size;

    @SuppressWarnings("unchecked")
    public ResizingDequeArray() {
        array = (I[]) new Object[2];
        head = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void pushLeft(I item) {
        if (size == array.length) {
            resize(2 * array.length);
        }
        System.out.print("/" + head + " " + array.length + " " + (head - 1 + array.length) % array.length + "/");
        head = (head - 1 + array.length) % array.length;
        array[head] = item;
        size++;
    }

    @Override
    public void pushRight(I item) {
        if (size == array.length) {
            resize(2 * array.length);
        }
        array[tail] = item;
        tail = (tail + 1) % array.length;
        size++;
    }

    @Override
    public I popLeft() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        I item = array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        size--;

        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        return item;
    }

    @Override
    public I popRight() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        tail = (tail - 1 + array.length) % array.length;
        I item = array[tail];
        array[tail] = null;
        size--;

        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        return item;
    }

    private void resize(int capacity) {
        @SuppressWarnings("unchecked")
        I[] newArray = (I[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(head + i) % array.length];
        }
        array = newArray;
        head = 0;
        tail = size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[(head + i) % array.length] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ResizingDequeArray<Integer> deque = new ResizingDequeArray<>();
        DequeManager manager = new DequeManager(deque);
        manager.manageDeque();
    }
}