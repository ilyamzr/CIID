package org.example;

import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Deque<I> {

    private static final Logger log = Logger.getLogger(Deque.class.getName());

    private Node head;
    private Node tail;
    private int N;

    private class Node{
        I item;
        Node next;
        Node prev;
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
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
        N++;
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
        N++;
    }

    public I popLeft()
    {
        if (!isEmpty())
        {
            I item = head.item;
            head = head.next;
            head.prev = null;
            N--;
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
            N--;
            return item;
        }
        else return null;
    }

    public static void main(String[] args) {

    }
}