package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Vector {

    private final List<Integer> elements;

    public Vector(List<Integer> elements) {
        this.elements = new ArrayList<>(elements);
    }

    public static void insertSort(List<Vector> vectors) {
        int size = vectors.size();
        for (int i = 1; i < size; i++) {
            Vector key = vectors.get(i);
            int j = i - 1;

            while (j >= 0 && compare(vectors.get(j), key)) {
                vectors.set(j + 1, vectors.get(j));
                j--;
            }
            vectors.set(j + 1, key);
        }
    }

    private static boolean compare(Vector v1, Vector v2) {
        for (int i = 0; i < v1.elements.size(); i++) {
            if (!Objects.equals(v1.elements.get(i), v2.elements.get(i))) {
                return v1.elements.get(i) > v2.elements.get(i);
            }
        }
        return false;
    }

    public static void printArray(List<Vector> vectors) {
        System.out.println("Результат:");
        for (Vector vector : vectors) {
            for (int j = 0; j < vector.elements.size(); j++) {
                System.out.print(vector.elements.get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество векторов и их размер: ");
        int amount = sc.nextInt();
        int size = sc.nextInt();

        List<Vector> vectors = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            List<Integer> elements = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                elements.add(sc.nextInt());
            }
            vectors.add(new Vector(elements));
        }
        insertSort(vectors);
        printArray(vectors);
    }
}