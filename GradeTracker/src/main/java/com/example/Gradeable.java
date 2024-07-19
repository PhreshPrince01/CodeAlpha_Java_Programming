package com.example;

import com.example.CustomExceptions.InvalidGradeException;

public interface Gradeable {

     /**
     * Adds a grade to the gradeable entity.
     *
     * @param grade The grade to be added.
     * @throws InvalidGradeException if the grade is invalid.
     */
    void addGrade(Grade grade) throws InvalidGradeException;


    /**
     * Calculates and retrieves the average grade.
     *
     * @return The average grade.
     */
    double getAverage();

     /**
     * Retrieves the lowest grade.
     *
     * @return The lowest grade.
     */
    int getLowest();


    /**
     * Retrieves the highest grade.
     *
     * @return The highest grade.
     */
    int getHighest();
}
