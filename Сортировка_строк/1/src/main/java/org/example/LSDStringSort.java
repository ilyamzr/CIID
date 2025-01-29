package org.example;

import java.util.Arrays;

public class LSDStringSort {

    public static String[] equalizeLines(String[] lines) {
        int maxLength = 0;
        for (String line : lines) {
            maxLength = Math.max(maxLength, line.length());
        }

        String[] equalLines = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            equalLines[i] = String.format("%-" + maxLength + "s", lines[i]);
        }

        return equalLines;
    }

    public static String[] sortByCharacter(String[] lines, int d) {
        int N = lines.length;
        int R = 256;
        int[] count = new int[R + 1];
        String[] aux = new String[N];

        for (String s : lines) {
            count[s.charAt(d)]++;
        }

        for (int i = 1; i <= R; i++) {
            count[i] += count[i - 1];
        }

        for (int i = N - 1; i >= 0; i--) {
            aux[count[lines[i].charAt(d)]-- - 1] = lines[i];
        }

        return aux;
    }

    public static void lsdSort(String[] lines) {
        String[] strings = equalizeLines(lines);
        for (int d = strings[0].length() - 1; d >= 0; d--) {
            strings = sortByCharacter(strings, d);
        }
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].trim();
        }
        System.arraycopy(strings, 0, lines, 0, lines.length);
    }

    public static void main(String[] args) {
        String[] strings = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", };
        lsdSort(strings);
        System.out.println(Arrays.toString(strings));
    }
}