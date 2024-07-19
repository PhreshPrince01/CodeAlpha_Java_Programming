package com.example;

import com.example.CustomExceptions.InvalidGradeException;
import com.example.CustomExceptions.InvalidInputException;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

/**
 * Utility class containing helper functions for the Grade Tracker application.
 */
public class HelperFunctions {

    /**
     * Adds a new student to the Grade Tracker.
     *
     * @param scanner The scanner object for input.
     * @param tracker The Grade Tracker object.
     */
    public static void addNewStudent(Scanner scanner, GradeTracker tracker) {
        try {
            UIUtil.printMessage("Enter first name: ");
            String firstName = scanner.nextLine();
            UIUtil.printMessage("Enter last name: ");
            String lastName = scanner.nextLine();
            tracker.addStudent(new Student(firstName, lastName));
            UIUtil.printMessage("Student added successfully!");
        } catch (InvalidInputException e) {
            UIUtil.printMessage(e.getMessage());
        }
    }

    /**
     * Views the list of students in the Grade Tracker.
     *
     * @param scanner The scanner object for input.
     * @param tracker The Grade Tracker object.
     */
    public static void viewStudents(Scanner scanner, GradeTracker tracker) {
        if (tracker.getStudents().isEmpty()) {
            UIUtil.printMessage("No students available.");
            return;
        }

        int num = 1;
        UIUtil.printHeader("Students");
        for (Student student : tracker.getStudents()) {
            System.out.printf("%d. %s%n", num, student.toString());
            num += 1;
        }
        UIUtil.printFooter();

        try {
            UIUtil.printMessage("Choose a student by number");
            int choice = getValidIntInput(scanner);

            if (choice >= 1 && choice <= tracker.getStudents().size()) {
                Student selectedStudent = tracker.getStudents().get(choice - 1);
                UIUtil.printMessage("Selected student: " + selectedStudent);
                studentMenu(scanner, selectedStudent, tracker);
            } else {
                throw new InvalidInputException("Invalid student number, please choose a valid number.");
            }
        } catch (InvalidInputException | InputMismatchException e) {
            UIUtil.printMessage(e.getMessage());
        }
    }

    /**
     * Displays the student menu for a selected student.
     *
     * @param scanner  The scanner object for input.
     * @param student  The selected student.
     * @param tracker  The Grade Tracker object.
     */
    private static void studentMenu(Scanner scanner, Student student, GradeTracker tracker) {
        try {
            String[] studentMenuOptions = {"Add Grades", "Print Details", "View Grade Trends","Print Detailed Report", "Return to Main Menu"};
            UIUtil.printMenu(studentMenuOptions);
            UIUtil.printMessage("Choose an option");

            int option = getValidIntInput(scanner);

            if (option == 1) {
                addGrades(scanner, student);
            } else if (option == 2) {
                tracker.printStudentDetails(student);
            } else if (option == 3) {
                viewGradeTrends(scanner, student);
            } else if (option == 4) {
                return; // Return to Main Menu
            } else {
                throw new InvalidInputException("Invalid option, please choose a valid option.");
            }
        } catch (InvalidInputException | InputMismatchException e) {
            UIUtil.printMessage(e.getMessage());
        }
    }

    /**
     * Adds grades for a selected student.
     *
     * @param scanner The scanner object for input.
     * @param student The selected student.
     */
    private static void addGrades(Scanner scanner, Student student) {
        try {
            UIUtil.printMessage("Enter subject: ");
            String subject = scanner.nextLine();

            UIUtil.printMessage("Enter grade: ");
            int score = getValidIntInput(scanner);
            if (score < 0 || score > 100) {
                throw new InvalidGradeException("Grade must be between 0 and 100.");
            }

            UIUtil.printMessage("Enter date (YYYY-MM-DD): ");
            String date = scanner.nextLine();

            student.addGrade(new Grade(subject, score, date));
            UIUtil.printMessage("Grade added successfully!");
        } catch (InvalidGradeException | InputMismatchException e) {
            UIUtil.printMessage(e.getMessage());
        }
    }

    /**
     * Views the grade trends for a selected student.
     *
     * @param scanner The scanner object for input.
     * @param student The selected student.
     */
    private static void viewGradeTrends(Scanner scanner, Student student) {
        try {
            if (student.getGrades().isEmpty()) {
                UIUtil.printMessage("No grades available for trend analysis.");
                return;
            }

            Set<String> subjects = student.getSubjects();
            if (subjects.isEmpty()) {
                UIUtil.printMessage("No subjects available for trend analysis.");
                return;
            }

            UIUtil.printMessage("Available subjects for trend analysis:");
            for (String subject : subjects) {
                System.out.println("- " + subject);
            }

            UIUtil.printMessage("Enter subject for trend analysis: ");
            String subject = scanner.nextLine();

            if (!subjects.contains(subject.toLowerCase())) {
                throw new InvalidInputException("No grades found for the subject " + subject + ".");
            }

            student.printGradeTrends(subject);
        } catch (InvalidInputException e) {
            UIUtil.printMessage(e.getMessage());
        }
    }

    /**
     * Retrieves a valid integer input from the user.
     *
     * @param scanner The scanner object for input.
     * @return The valid integer input.
     * @throws InputMismatchException if the input is not a valid integer.
     */
    public static int getValidIntInput(Scanner scanner) throws InputMismatchException {
        try {
            int input = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            return input;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear the invalid input
            throw new InputMismatchException("Invalid input, please enter a valid number.");
        }
    }
}
