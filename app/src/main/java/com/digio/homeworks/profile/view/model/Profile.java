package com.digio.homeworks.profile.view.model;

import java.util.List;

public class Profile {

    // Variables
    private String email;
    private String location;
    private List<String> subjects;
    private List<String> hours;

    // Empty constructor
    public Profile() {

    }

    // Constructor
    public Profile(String email, String location, List<String> subjects, List<String> hours) {
        this.email = email;
        this.location = location;
        this.subjects = subjects.subList(0, subjects.size() - 1);
        this.hours = hours.subList(0, subjects.size() - 1);
    }

    /**
     * Get user email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get user location
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     * Get teacher subjects
     * @return
     */
    public List<String> getSubjects() {
        return subjects;
    }

    /**
     * Get teacher hours
     * @return
     */
    public List<String> getHours() {
        return hours;
    }

}
