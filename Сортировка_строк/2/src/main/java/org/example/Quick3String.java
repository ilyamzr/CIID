package org.example;

import java.util.Arrays;

public class Quick3String {

    public static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void quickThreeSort(int[] a, int low, int high) {
        if (high <= low) return;

        int lt = low;
        int gt = high;
        int i = lt + 1;
        int v = a[lt];

        while (i <= gt) {
            if (a[i] < v) exch(a, lt++, i++);
            else if (a[i] > v) exch(a, i, gt--);
            else i++;
        }
        quickThreeSort(a, low, lt - 1);
        quickThreeSort(a, gt + 1, high);
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {5, 3, 8, 6, 2, 7, 4},
                {1, 9, 2, 8, 3, 7, 4, 6},
                {10, 5, 6, 3, 9, 1, 2, 8, 4},
                {7, 2, 3, 5, 8, 1, 6, 4, 9, 10}
        };

        for (int[] array : arrays) {
            System.out.print("Исходный массив: ");
            System.out.println(Arrays.toString(array));
            quickThreeSort(array, 0, array.length - 1);
            System.out.print("Отсортированный массив: ");
            System.out.println(Arrays.toString(array));
        }
    }
}
