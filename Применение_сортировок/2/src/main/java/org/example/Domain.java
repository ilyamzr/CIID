package org.example;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;

public class Domain {

    private static final Logger logger = Logger.getLogger(Domain.class.getName());

    private final String[] parts;

    public Domain(String version) {
        parts = version.split("\\.");
    }

    public String toString() {
        return String.join(".", toStringParts());
    }

    private String[] toStringParts() {
        String[] stringParts = new String[parts.length];
        for (int i = 0; i < parts.length; i++) {
            stringParts[i] = String.valueOf(parts[i]);
        }
        return stringParts;
    }

    public String reverseName() {
        String[] reversedParts = new String[parts.length];

        for (int i = 0; i < parts.length; i++) {
            reversedParts[i] = parts[parts.length - 1 - i]; // Corrected index
        }

        return String.join(".", reversedParts);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        logger.info("Введите имена доменов: ");
        String input;
        ArrayList<Domain> domains = new ArrayList<>();

        while (true) {
            input = sc.nextLine();
            if (input.isEmpty()) {
                break;
            } else {
                domains.add(new Domain(input));
            }
        }

        ArrayList<String> reversedNames = new ArrayList<>();
        for (Domain domain : domains) {
            reversedNames.add(domain.reverseName());
        }

        Collections.sort(reversedNames);

        logger.info("Упорядоченные обратные имена доменов: ");
        for (String reversedName : reversedNames) {
            logger.info(reversedName);
        }

        sc.close();
    }
}