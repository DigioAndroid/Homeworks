package com.digio.homeworks.utils;

import com.digio.homeworks.R;
import com.digio.homeworks.main.view.model.Notice;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DBUtils {

    private DBUtils() {

    }

    public static void test() {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("notice");

        // Creating new user node, which returns the unique key value
        // new user node would be /users/$userid/
        String id = mDatabase.push().getKey();

        // creating user object
        Notice notice = new Notice("ESO Lessons", R.mipmap.ic_launcher, "John Doe", "New York", 7, 10);

        // pushing user to 'users' node using the userId
        mDatabase.child(id).setValue(notice);
    }

}
