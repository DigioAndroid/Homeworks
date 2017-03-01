package com.digio.homeworks.profile.view.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.digio.homeworks.R;
import com.digio.homeworks.main.view.activity.MainActivity;
import com.digio.homeworks.main.view.activity.ParentActivity;
import com.digio.homeworks.main.view.interfaces.Presenter;

public class ProfileActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    @NonNull
    @Override
    public Presenter getPresenter() {
        return null;
    }

}
