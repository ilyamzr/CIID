package org.example;

import java.util.LinkedList;
import java.util.Random;

class HashTable {
    private final LinkedList<Integer>[] table;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void insert(int key) {
        int index = hash(key);
        table[index].add(key);
    }

    private int hash(int key) {
        return Math.abs(key) % table.length;
    }

    public int[] getMinMaxLengths() {
        int minLength = Integer.MAX_VALUE;
        int maxLength = 0;

        for (LinkedList<Integer> list : table) {
            int length = list.size();
            if (length > 0) {
                if (length < minLength) {
                    minLength = length;
                }
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }

        return new int[]{minLength, maxLength};
    }

    public static void main(String[] args) {
        int[] values = {1000, 10000, 100000, 1000000};
        Random r = new Random();

        for (int N : values) {
            HashTable hashTable = new HashTable(N / 100);

            for (int i = 0; i < N; i++) {
                hashTable.insert((r.nextInt() * Integer.MAX_VALUE));
            }

            int[] minMaxLengths = hashTable.getMinMaxLengths();
            System.out.println("N = " + N + ": Мин. длина = " + minMaxLengths[0] + ", Макс. длина = " + minMaxLengths[1]);
        }
    }
}

