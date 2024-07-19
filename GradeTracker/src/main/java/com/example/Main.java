package com.example;

import com.example.CustomExceptions.InvalidInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static GradeTracker tracker = new GradeTracker();

    public static void main(String[] args) {
        UIUtil.printHeader("WELCOME TO GRADE TRACKER");

        while (true) {
            try {
                String[] mainMenuOptions = {"Enter a New Student", "View Students", "Exit"};
                UIUtil.printMenu(mainMenuOptions);
                UIUtil.printMessage("Choose an option");

                int option = HelperFunctions.getValidIntInput(scanner);

                if (option == 1) {
                    HelperFunctions.addNewStudent(scanner, tracker);
                } else if (option == 2) {
                    HelperFunctions.viewStudents(scanner, tracker);
                } else if (option == 3) {
                    UIUtil.printHeader("Goodbye");
                    break;
                } else {
                    throw new InvalidInputException("Invalid option, please choose a valid option.");
                }
            } catch (InvalidInputException | InputMismatchException e) {
                UIUtil.printMessage(e.getMessage());
            }
        }
        scanner.close();
    }
}
