package org.example;

import java.io.File;
import java.util.Scanner;

public class FileSorter {

    public static void selectionSort(File[] files, int mode) {
        for (int i = 0; i < files.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < files.length; j++) {
                if ((!compare(files[index], files[j]) && mode == 1) || (compare(files[index], files[j]) && mode == 0)) {
                    index = j;
                }
            }
            File temp = files[i];
            files[i] = files[index];
            files[index] = temp;
        }
    }

    public static boolean compare(File file1, File file2) {
        String name1 = file1.getName().toLowerCase();
        String name2 = file2.getName().toLowerCase();

        int minLength = Math.min(name1.length(), name2.length());
        for (int i = 0; i < minLength; i++) {
            if (name1.charAt(i) != name2.charAt(i)) {
                return name1.charAt(i) > name2.charAt(i);
            }
        }
        return name1.length() > name2.length();
    }

    public static void print(File[] files) {
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Неверный аргумент");
            return;
        }
        String directoryPath = args[0];
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Ошибка при получении списка файлов.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int choice = 1;

        while (choice != 0) {
            System.out.println("Выберите способ сортировки:");
            System.out.println("1: В обратном порядке");
            System.out.println("2: По алфавиту");
            System.out.println("0: Выход");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    selectionSort(files, 1);
                    print(files);
                    break;
                case 2:
                    selectionSort(files, 0);
                    print(files);
                    break;
                case 0:
                    System.out.println("Программа завершена");
                    break;
                default:
                    System.out.println("Неверный выбор");
            }
        }

        scanner.close();
    }
}