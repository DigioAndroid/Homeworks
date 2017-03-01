package com.digio.homeworks.profile.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.digio.homeworks.R;
import com.digio.homeworks.main.view.activity.MainActivity;
import com.digio.homeworks.main.view.activity.ParentActivity;
import com.digio.homeworks.main.view.interfaces.Presenter;
import com.digio.homeworks.profile.view.presenter.ProfilePresenter;

public class ProfileActivity extends ParentActivity implements ProfilePresenter.View {

    private ProfilePresenter profilePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Handle account information in presenter
        ((ProfilePresenter)getPresenter()).handleAccountInfo();
    }

    @NonNull
    @Override
    public Presenter getPresenter() {
        if(profilePresenter == null) {
            profilePresenter = new ProfilePresenter(this);
        }
        return profilePresenter;
    }

    @Override
    public Context getContext() {
        return this;
    }
/*
    @Override
    public void fillProfileInfo(String user, Profile profile) {

    }
*/
    /**
     * Get shared preferences
     * @return
     */
    @Override
    public SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    }
}
