package org.example;

import java.util.LinkedList;
import java.util.Random;

public class LinearProbingHashST {
    private LinkedList<Integer>[] table;
    private int capacity;

    public LinearProbingHashST(int capacity) {
        this.capacity = capacity / 100;
        this.table = new LinkedList[this.capacity];
        for (int i = 0; i < this.capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void insert(int key) {
        int index = hash(key);
        table[index].add(key);
    }

    public int[] calculateChainLengths() {
        int maxLength = 0;
        int minLength = Integer.MAX_VALUE;

        for (LinkedList<Integer> chain : table) {
            int length = chain.size();
            if (length > 0) {
                maxLength = Math.max(maxLength, length);
                minLength = Math.min(minLength, length);
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return new int[] {0, maxLength};
        }

        return new int[]{minLength, maxLength};
    }

    public static void main(String[] args) {
        int N_values[] = {1000, 10000, 100000, 1000000};
        Random random = new Random();

        for (int N : N_values) {
            LinearProbingHashST hashTable = new LinearProbingHashST(N);
            for (int i = 0; i < N; i++) {
                int key = random.nextInt(N * 10);
                hashTable.insert(key);
            }
            int[] chainLengths = hashTable.calculateChainLengths();
            System.out.printf("Размер: %d, Длина самого короткого стека: %d, Длина самого длинного стека: %d%n", N, chainLengths[0], chainLengths[1]);
        }
    }
}