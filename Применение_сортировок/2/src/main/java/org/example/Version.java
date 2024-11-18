package org.example;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.Arrays;

public class Version implements Comparable<Version> {

    private static final Logger logger = Logger.getLogger(Version.class.getName());

    private final int[] parts;

    public Version(String version) {
        String[] splitParts = version.split("\\.");
        parts = new int[splitParts.length];
        for (int i = 0; i < splitParts.length; i++) {
            parts[i] = Integer.parseInt(splitParts[i]);
        }
    }

    @Override
    public int compareTo(Version other) {
        for (int i = 0; i < Math.min(this.parts.length, other.parts.length); i++) {
            if (this.parts[i] != other.parts[i]) {
                return Integer.compare(this.parts[i], other.parts[i]);
            }
        }
        return Integer.compare(this.parts.length, other.parts.length);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Version other = (Version) obj;
        return Arrays.equals(this.parts, other.parts);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(parts);
    }

    @Override
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        logger.info("Введите два номера версий: ");
        String version1 = sc.nextLine();
        String version2 = sc.nextLine();

        Version v1 = new Version(version1);
        Version v2 = new Version(version2);

        int comparisonResult = v1.compareTo(v2);
        if (comparisonResult < 0) {
            logger.info(String.format("%s меньше, чем %s", version1, version2));
        } else if (comparisonResult > 0) {
            logger.info(String.format("%s больше, чем %s", version1, version2));
        } else {
            logger.info(String.format("%s равен %s", version1, version2));
        }
        sc.close();
    }
}