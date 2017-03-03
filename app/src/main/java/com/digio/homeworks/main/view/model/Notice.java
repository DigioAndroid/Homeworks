package com.digio.homeworks.main.view.model;

public class Notice {

    // Variables
    private String title;
    private int iconID;
    private String teacherEmail;
    private int pricePerHour;
    private double distanceInKm;

    // Empty constructor
    public Notice() {

    }

    // Constructor
    public Notice(String title, int iconID, String teacherEmail, int pricePerHour, double distanceInKm) {
        this.title = title;
        this.iconID = iconID;
        this.teacherEmail = teacherEmail;
        this.pricePerHour = pricePerHour;
        this.distanceInKm = distanceInKm;
    }

    /**
     * Get notice title
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get teacher icon id
     * @return
     */
    public int getIconID() {
        return iconID;
    }

    /**
     * Get teacher name
     * @return
     */
    public String getTeacherEmail() {
        return teacherEmail;
    }

    /**
     * Get price per hour
     * @return
     */
    public int getPricePerHour() {
        return pricePerHour;
    }

    /**
     * Get distance to location
     * @return
     */
    public double getDistanceInKm() {
        return distanceInKm;
    }

}
