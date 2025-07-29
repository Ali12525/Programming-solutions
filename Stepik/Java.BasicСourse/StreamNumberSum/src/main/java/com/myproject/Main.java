package com.myproject;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0.0;

        while (scanner.hasNext()) {
            String token = scanner.next();
            try {
                sum += Double.parseDouble(token);
            } catch (NumberFormatException ignored) {}
        }

        System.out.printf(Locale.ROOT, "%.6f%n", sum);
    }
}