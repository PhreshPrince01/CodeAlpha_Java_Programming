package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Student implements Gradeable {
    private String firstName;
    private String lastName;
    private ArrayList<Grade> grades;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = new ArrayList<>();
    }


    /**
     * Retrieves the student's full name.
     *
     * @return The full name of the student.
     */
    public String getName() {
        return capitalise(firstName) + " " + capitalise(lastName);
    }


    /**
     * Retrieves the list of grades for the student.
     *
     * @return The list of grades.
     */
    public ArrayList<Grade> getGrades() {
        return grades;
    }
    

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


     /**
     * Adds a grade to the student's record.
     *
     * @param grade The grade to be added.
     */
    @Override
    public void addGrade(Grade grade) {
        grades.add(grade);
    }


    /**
     * Calculates the average grade of the student.
     *
     * @return The average grade.
     */
    @Override
    public double getAverage() {
        if (grades.isEmpty()) return 0.0;
        int total = 0;
        for (Grade grade : grades) {
            total += grade.getScore();
        }
        return (double) total / grades.size();
    }


    /**
     * Calculates the lowest grade of the student.
     *
     * @return The lowest grade.
     */
    @Override
    public int getLowest() {
        if (grades.isEmpty()) return -1;
        int lowest = Integer.MAX_VALUE;
        for (Grade grade : grades) {
            if (grade.getScore() < lowest) {
                lowest = grade.getScore();
            }
        }
        return lowest;
    }


    /**
     * Calculates the highest grade of the student.
     *
     * @return The highest grade.
     */
    @Override
    public int getHighest() {
        if (grades.isEmpty()) return -1;
        int highest = Integer.MIN_VALUE;
        for (Grade grade : grades) {
            if (grade.getScore() > highest) {
                highest = grade.getScore();
            }
        }
        return highest;
    }


    /**
     * Retrieves the set of subjects the student has grades for.
     *
     * @return The set of subjects.
     */
    public Set<String> getSubjects() {
        Set<String> subjects = new HashSet<>();
        for (Grade grade : grades) {
            subjects.add(grade.getSubject().toLowerCase());
        }
        return subjects;
    }

    
    /**
     * Returns a string representation of the student.
     *
     * @return The string representation of the student.
     */
    @Override
    public String toString() {
        return getName();
    }


    /**
     * Calculates the average grade of the student's subject.
     *
     * @param subject the selected subject
     * @return The average grade.
     */
    public double getAverage(String subject) {
        ArrayList<Integer> subjectGrades = new ArrayList<>();
        for (Grade grade : grades) {
            if (grade.getSubject().equalsIgnoreCase(subject)) {
                subjectGrades.add(grade.getScore());
            }
        }
        if (subjectGrades.isEmpty()) return 0.0;
        int total = 0;
        for (int grade : subjectGrades) {
            total += grade;
        }
        return (double) total / subjectGrades.size();
    }


    /**
     * Calculates the lowest grade of the student subject.
     *
     * @param subject the selected subject
     * @return The lowest grade.
     */
    public int getLowest(String subject) {
        int lowest = Integer.MAX_VALUE;
        for (Grade grade : grades) {
            if (grade.getSubject().equalsIgnoreCase(subject) && grade.getScore() < lowest) {
                lowest = grade.getScore();
            }
        }
        return lowest == Integer.MAX_VALUE ? -1 : lowest;
    }


    /**
     * Calculates the highest grade of the student subject.
     *
     * @param subject the selected subject
     * @return The highest grade.
     */
    public int getHighest(String subject) {
        int highest = Integer.MIN_VALUE;
        for (Grade grade : grades) {
            if (grade.getSubject().equalsIgnoreCase(subject) && grade.getScore() > highest) {
                highest = grade.getScore();
            }
        }
        return highest == Integer.MIN_VALUE ? -1 : highest;
    }



    /**
     * Prints the grade trends for a specified subject.
     *
     * @param subject The subject to print the grade trends for.
     */
    public void printGradeTrends(String subject) {
        ArrayList<Grade> subjectGrades = new ArrayList<>();
        for (Grade grade : grades) {
            if (grade.getSubject().equalsIgnoreCase(subject)) {
                subjectGrades.add(grade);
            }
        }

        if (subjectGrades.isEmpty()) {
            UIUtil.printMessage("No grades available for subject " + subject);
            return;
        }

        UIUtil.printHeader("Grade Trends for " + subject.toUpperCase());
        System.out.printf("%-15s | %-5s | %-6s%n", "Date", "Grade", "Trend");
        System.out.println("=".repeat(50));

        for (int i = 0; i < subjectGrades.size(); i++) {
            Grade current = subjectGrades.get(i);
            String trend = "";

            if (i > 0) {
                Grade previous = subjectGrades.get(i - 1);
                int difference = current.getScore() - previous.getScore();
                trend = difference > 0 ? "+" + difference : String.valueOf(difference);
                trend = difference > 10 ? "++" : difference < -10 ? "--" : trend;
            }

            System.out.printf("%-15s | %-5d | %-6s%n", current.getDate(), current.getScore(), trend);
        }
        UIUtil.printFooter();
    }

    /**
     * Capitalises a String.
     *
     * @param str The String to capitalise.
     * @return The capitalised String
     */
    private static String capitalise(String str){
        if (str==null || str.length() == 0) return str;
          return str.substring(0, 1).toUpperCase() +
          str.substring(1);
    }
}
