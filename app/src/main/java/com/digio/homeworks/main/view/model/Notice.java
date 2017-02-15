package com.digio.homeworks.main.view.model;

public class Notice {

    // Variables
    private String title;
    private int iconID;
    private String teacherName;
    private String teacherLocation;
    private double teacherCurrentRate;
    private int teacherTotalRates;
    private int pricePerHour;
    private double distanceInKm;

    // Empty constructor
    public Notice() {

    }

    // Constructor
    public Notice(String title, int iconID, String teacherName, String teacherLocation,
                  double teacherCurrentRate, int teacherTotalRates, int pricePerHour, double distanceInKm) {
        this.title = title;
        this.iconID = iconID;
        this.teacherName = teacherName;
        this.teacherLocation = teacherLocation;
        this.teacherCurrentRate = teacherCurrentRate;
        this.teacherTotalRates = teacherTotalRates;
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
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * Get teacher location
     * @return
     */
    public String getTeacherLocation() {
        return teacherLocation;
    }

    /**
     * Get teacher current rate
     * @return
     */
    public double getTeacherCurrentRate() {
        return teacherCurrentRate;
    }

    /**
     * Get teacher total rates
     * @return
     */
    public int getTeacherTotalRates() {
        return teacherTotalRates;
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
