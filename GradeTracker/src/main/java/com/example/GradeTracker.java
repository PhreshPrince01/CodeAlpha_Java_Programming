package com.example;

import com.example.CustomExceptions.InvalidInputException;
import com.example.CustomExceptions.StudentNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GradeTracker {
    private ArrayList<Student> students;
    private Set<String> studentNames;

    public GradeTracker() {
        students = new ArrayList<>();
        studentNames = new HashSet<>();
    }


    /**
     * Adds a student to the tracker.
     *
     * @param student The student to be added.
     * @throws InvalidInputException If a student with the same name already exists.
     */
    public void addStudent(Student student) throws InvalidInputException {
        String studentName = student.getName().toLowerCase();
        if (studentNames.contains(studentName)) {
            throw new InvalidInputException("A student with the name " + student.getName() + " already exists.");
        }
        students.add(student);
        studentNames.add(studentName);
    }


    /**
     * Retrieves a student by name.
     *
     * @param name The name of the student to retrieve.
     * @return The student with the given name.
     * @throws StudentNotFoundException If no student with the given name is found.
     */
    public Student getStudent(String name) throws StudentNotFoundException {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        throw new StudentNotFoundException("Student with name " + name + " not found.");
    }


    /**
     * Retrieves the list of students.
     *
     * @return The list of students.
     */
    public ArrayList<Student> getStudents() {
        return students;
    }


    /**
     * Prints the details of a student, including their grades and overall 
     * statistics.
     *
     * @param student The student whose details are to be printed.
     */
    public void printStudentDetails(Student student) {
        if (student.getGrades().isEmpty()) {
            UIUtil.printMessage("No grades available for student " + student.getName());
            return;
        }
    
        UIUtil.printHeader("Grades for " + student.getName());
        System.out.printf("%-15s | %-10s | %-5s%n", "Date", "Subject", "Grade");
        System.out.println("=".repeat(50));
    
        for (Grade grade : student.getGrades()) {
            System.out.printf("%-15s | %-10s | %-5d%n", grade.getDate(), grade.getSubject(), grade.getScore());
        }
        UIUtil.printFooter();
    
        Set<String> subjects = student.getSubjects();
        for (String subject : subjects) {
            UIUtil.printHeader("Stats for " + subject.toUpperCase());
            System.out.println("Average: " + student.getAverage(subject));
            System.out.println("Lowest: " + student.getLowest(subject));
            System.out.println("Highest: " + student.getHighest(subject));
            UIUtil.printFooter();
        }

        UIUtil.printHeader("Overall Stats for " + student.getName());
        System.out.println("Average: " + student.getAverage());
        System.out.println("Lowest: " + student.getLowest());
        System.out.println("Highest: " + student.getHighest());
        UIUtil.printFooter();
    }
}    