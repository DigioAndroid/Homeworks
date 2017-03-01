package com.digio.homeworks.profile.view.presenter;


import android.content.Context;
import android.content.SharedPreferences;

import com.digio.homeworks.main.view.interfaces.Presenter;

public class ProfilePresenter implements Presenter {

    private ProfilePresenter.View profileView;

    public ProfilePresenter(ProfilePresenter.View profileView) {
        this.profileView = profileView;
    }

    @Override
    public void create() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    /**
     * Manage account information stored in shared preferences
     */
    public void handleAccountInfo() {
        // Store user and email in shared preferences
        SharedPreferences pref = profileView.getSharedPreferences();
        String user = pref.getString("ACCOUNT_USER", null);
        String email = pref.getString("ACCOUNT_EMAIL", null);
        getUserProfile(user, email);
    }

    private void getUserProfile(String user, String email) {
        // TODO: Implement
        //profileView.fillProfileInfo(user, profile);
    }

    public interface View {

        Context getContext();
        //void fillProfileInfo(String user, Profile profile);
        SharedPreferences getSharedPreferences();

    }
}
