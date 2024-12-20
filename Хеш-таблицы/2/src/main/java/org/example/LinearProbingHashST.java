package org.example;

import java.util.LinkedList;

class HashTable {
    private LinkedList<Integer>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }

    public void insert(int key) {
        int index = hash(key);
        table[index].add(key);
        size++;
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
        int N_values[] = {1000, 10000, 100000, 1000000};

        for (int N : N_values) {
            HashTable hashTable = new HashTable(N / 100);

            for (int i = 0; i < N; i++) {
                hashTable.insert((int) (Math.random() * Integer.MAX_VALUE));
            }

            int[] minMaxLengths = hashTable.getMinMaxLengths();
            System.out.println("N = " + N + ": Мин. длина = " + minMaxLengths[0] + ", Макс. длина = " + minMaxLengths[1]);
        }
    }
}

