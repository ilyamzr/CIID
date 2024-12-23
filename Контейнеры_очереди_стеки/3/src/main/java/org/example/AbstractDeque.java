package org.example;

public interface AbstractDeque<I> {
    void pushLeft(I item);
    void pushRight(I item);
    I popLeft();
    I popRight();
    boolean isEmpty();
    void printDeque();
}