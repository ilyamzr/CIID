package org.example;

import java.util.Random;

public class LinearProbingHashST {
    private final int[] table;
    private final int capacity;

    public LinearProbingHashST(int capacity) {
        this.capacity = capacity;
        this.table = new int[capacity];
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void insert(int key) {
        int index = hash(key);
        while (table[index] != 0) {
            index = (index + 1) % capacity;
        }
        table[index] = key;
    }

    public double calculateAverageCost() {
        int totalCost = 0;
        int count = 0;

        for (int i = 0; i < capacity; i++) {
            if (table[i] != 0) {
                int currentCost = 0;
                int index = i;

                while (index < capacity && table[index] != 0) {
                    currentCost++;
                    index++;
                }
                totalCost += currentCost;
                count++;
            }
        }
        if (count > 0)
        {
            return (double) totalCost / count;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] values = {1000, 10000, 100000, 1000000};
        Random random = new Random();

        for (int N : values) {
            LinearProbingHashST hashTable = new LinearProbingHashST(N);
            for (int i = 0; i < N / 2; i++) {
                int key = random.nextInt(N * 10);
                hashTable.insert(key);
            }
            double averageCost = hashTable.calculateAverageCost();
            System.out.printf("Размер: %d, Средняя стоимость промаха: %.2f%n", N, averageCost);
        }
    }
}