package com.digio.homeworks.profile.view.model;

public class Rate {

    // Variables
    private String teacherEmail;
    private int rate;
    private String studentEmail;

    // Empty constructor
    public Rate() {

    }

    // Constructor
    public Rate(String teacherEmail, int rate, String studentEmail) {
        this.teacherEmail = teacherEmail;
        this.rate = rate;
        this.studentEmail = studentEmail;
    }

    /**
     * Get teacher email
     * @return
     */
    public String getTeacherEmail() {
        return teacherEmail;
    }

    /**
     * Get rate
     * @return
     */
    public int getRate() {
        return rate;
    }

    /**
     * Get teacher email
     * @return
     */
    public String getStudentEmail() {
        return studentEmail;
    }

}
