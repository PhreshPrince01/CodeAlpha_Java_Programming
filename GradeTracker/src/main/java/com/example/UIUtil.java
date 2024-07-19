package com.example;

public class UIUtil {

    public static void printHeader(String title) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println(title);
        System.out.println("=".repeat(50));
    }


    /**
     * Prints a footer with decoration.
     */
    public static void printFooter() {
        System.out.println("=".repeat(50) + "\n");
    }


    /**
     * Prints a menu with given options.
     *
     * @param options The menu options.
     */
    public static void printMenu(String[] options) {
        System.out.println("\n" + "-".repeat(50));
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d. %s%n", i + 1, options[i]);
        }
        System.out.println("-".repeat(50));
    }


    /**
     * Prints a message to the console.
     *
     * @param message The message to print.
     */
    public static void printMessage(String message) {
        System.out.println("\n" + message + "\n");
    }
}
