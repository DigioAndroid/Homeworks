package com.digio.homeworks.utils;

import com.digio.homeworks.R;
import com.digio.homeworks.main.view.model.Notice;
import com.digio.homeworks.profile.view.model.Profile;
import com.digio.homeworks.profile.view.model.Rate;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    private DBUtils() {

    }

    public static void test() {
        // Notices
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("notice");

        String id = mDatabase.push().getKey();

        Notice notice = new Notice("ESO Lessons", R.mipmap.ic_launcher, "john.doe@mydomain.com", 8, 3.7);
        Notice notice2 = new Notice("1º Bachiller Maths Lessons", R.mipmap.ic_launcher, "rightshield@esdebian.org", 9, 2);

        mDatabase.child(id).setValue(notice);

        id = mDatabase.push().getKey();
        mDatabase.child(id).setValue(notice2);

        // Profiles
        mDatabase = FirebaseDatabase.getInstance().getReference("profile");
        id = mDatabase.push().getKey();

        List<String> profile1_subj = new ArrayList<>();
        profile1_subj.add("History");
        List<String> profile1_hour = new ArrayList<>();
        profile1_hour.add("10:00");
        profile1_hour.add("12:00");
        profile1_hour.add("16:00");
        List<String> profile2_subj = new ArrayList<>();
        profile2_subj.add("Maths");
        profile2_subj.add("Geography");
        List<String> profile2_hour = new ArrayList<>();
        profile2_hour.add("9:00");
        profile2_hour.add("10:00");
        profile2_hour.add("12:00");
        profile2_hour.add("17:00");

        Profile profile = new Profile("john.doe@mydomain.com", "New York", profile1_subj,
                profile1_hour);
        Profile profile2 = new Profile("rightshield@esdebian.org", "CT", profile2_subj,
                profile2_hour);

        mDatabase.child(id).setValue(profile);

        id = mDatabase.push().getKey();
        mDatabase.child(id).setValue(profile2);

        // Rates
        mDatabase = FirebaseDatabase.getInstance().getReference("rate");
        id = mDatabase.push().getKey();

        Rate rate = new Rate("rightshield@esdebian.org", 5, "john.doe@mdomain.com");
        Rate rate2 = new Rate("rightshield@esdebian.org", 8, "bryan.cranston@mdomain.com");

        mDatabase.child(id).setValue(rate);

        id = mDatabase.push().getKey();
        mDatabase.child(id).setValue(rate2);


    }

}
