package org.example;

import java.util.Arrays;

public class CuckooHashTable {
    private static final int DEFAULT_CAPACITY = 10;
    private String[] table1;
    private String[] table2;
    private int size1;
    private int size2;

    public CuckooHashTable() {
        table1 = new String[DEFAULT_CAPACITY];
        table2 = new String[DEFAULT_CAPACITY];
        size1 = 0;
        size2 = 0;
    }

    private int hash1(String key) {
        return key.hashCode() % table1.length;
    }

    private int hash2(String key) {
        return key.hashCode() % table2.length;
    }

    public void insert(String key) {
        if (size1 + size2 >= table1.length) {
            resize();
        }
        insertKey(key, 1);
    }

    private void insertKey(String key, int table) {
        if (table == 1) {
            int index = hash1(key);
            if (table1[index] == null) {
                table1[index] = key;
                size1++;
            } else {
                String temp = table1[index];
                table1[index] = key;
                insertKey(temp, 2);
            }
        } else {
            int index = hash2(key);
            if (table2[index] == null) {
                table2[index] = key;
                size2++;
            } else {
                String temp = table2[index];
                table2[index] = key;
                insertKey(temp, 1);
            }
        }
    }

    private void resize() {
        String[] oldTable1 = table1;
        String[] oldTable2 = table2;
        table1 = new String[oldTable1.length * 2];
        table2 = new String[oldTable2.length * 2];
        size1 = 0;
        size2 = 0;

        for (String key : oldTable1) {
            if (key != null) {
                insert(key);
            }
        }
        for (String key : oldTable2) {
            if (key != null) {
                insert(key);
            }
        }
    }

    public boolean contains(String key) {
        return containsInTable(key, 1) || containsInTable(key, 2);
    }

    private boolean containsInTable(String key, int table) {
        if (table == 1) {
            int index = hash1(key);
            return table1[index] != null && table1[index].equals(key);
        } else {
            int index = hash2(key);
            return table2[index] != null && table2[index].equals(key);
        }
    }

    public void printTables() {
        System.out.println("Table 1: " + Arrays.toString(table1));
        System.out.println("Table 2: " + Arrays.toString(table2));
    }

    public static void main(String[] args) {
        CuckooHashTable cuckooHashTable = new CuckooHashTable();
        cuckooHashTable.insert("one");
        cuckooHashTable.insert("two");
        cuckooHashTable.insert("three");
        cuckooHashTable.insert("four");

        cuckooHashTable.printTables();

        System.out.println("Contains 'one': " + cuckooHashTable.contains("one"));
        System.out.println("Contains 'five': " + cuckooHashTable.contains("five"));
    }
}