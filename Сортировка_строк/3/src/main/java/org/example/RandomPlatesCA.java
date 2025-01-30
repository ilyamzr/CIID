package org.example;

import java.util.Random;
import java.util.Scanner;

public class RandomPlatesCA {

    private static final Random random = new Random();

    public static String[] randomPlatesCA(int n) {
        String[] plates = new String[n];
        for (int i = 0; i < n; i++) {
            plates[i] = generateNewPlate();
        }
        lsdSort(plates);
        return plates;
    }

    public static String generateNewPlate()
    {
        StringBuilder plate = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            plate.append(random.nextInt(10));
        }

        for (int i = 0; i < 3; i++) {
            char letter = (char) ('A' + random.nextInt(26));
            plate.append(letter);
        }

        for (int i = 0; i < 2; i++) {
            plate.append(random.nextInt(10));
        }

        return plate.toString();
    }

    public static void lsdSort(String[] plates) {
        int N = plates.length;
        int R = 256;
        String[] aux = new String[N];

        for (int d = plates[0].length() - 1; d >= 0; d--) {
            int[] count = new int[R + 1];

            for (String s : plates) {
                count[s.charAt(d) + 1]++;
            }

            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            for (String plate : plates) {
                aux[count[plate.charAt(d)]++] = plate;
            }

            System.arraycopy(aux, 0, plates, 0, N);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество номеров: ");
        int n = scanner.nextInt();
        String[] plates = randomPlatesCA(n);
        System.out.println("Сгенерированные номера: " + java.util.Arrays.toString(plates));
    }
}