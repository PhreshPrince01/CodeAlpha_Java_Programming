package com.example;

public class Grade {
    private String subject;
    private int score;
    private String date;

    public Grade(String subject, int score, String date){
        this.subject = subject;
        this.score = score;
        this.date = date;
    }
   

     /**
     * Retrieves the score of the grade.
     *
     * @return The score.
     */
    public int getScore() {
        return score;
    }


    /**
     * Retrieves the subject of the grade.
     *
     * @return The subject.
     */
    public String getSubject() {
        return subject;
    }


    /**
     * Retrieves the date the grade was received.
     *
     * @return The date.
     */
    public String getDate() {
        return date;
    }


     /**
     * Sets the subject of the grade.
     *
     * @param subject The new subject.
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Sets the score of the grade.
     *
     * @param score The new score.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Sets the date the grade was received.
     *
     * @param date The new date.
     */
    public void setDate(String date) {
        this.date = date;
    }
}
