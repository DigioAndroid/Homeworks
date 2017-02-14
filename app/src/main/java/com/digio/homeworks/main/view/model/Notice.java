package com.digio.homeworks.main.view.model;

public class Notice {

    // Variables
    public String title;
    public int iconID;
    public String teacherName;
    public String teacherLocation;
    public int teacherCurrentRate;
    public int teacherTotalRates;

    // Empty constructor
    public Notice() {

    }

    // Constructor
    public Notice(String title, int iconID, String teacherName, String teacherLocation,
                  int teacherCurrentRate, int teacherTotalRates) {
        this.title = title;
        this.iconID = iconID;
        this.teacherName = teacherName;
        this.teacherLocation = teacherLocation;
        this.teacherCurrentRate = teacherCurrentRate;
        this.teacherTotalRates = teacherTotalRates;
    }

}
