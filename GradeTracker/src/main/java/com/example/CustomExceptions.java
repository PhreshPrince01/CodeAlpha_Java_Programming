package com.example;

public class CustomExceptions {

    /**
     * Exception thrown when an invalid input is provided.
     */
    public static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }


     /**
     * Exception thrown when a student is not found.
     */
    public static class StudentNotFoundException extends Exception {
        public StudentNotFoundException(String message) {
            super(message);
        }
    }


    /**
     * Exception thrown when an invalid grade is provided.
     */
    public static class InvalidGradeException extends Exception {
        public InvalidGradeException(String message) {
            super(message);
        }
    }
}
