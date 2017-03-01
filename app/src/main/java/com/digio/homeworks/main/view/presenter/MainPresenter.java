package com.digio.homeworks.main.view.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.digio.homeworks.R;
import com.digio.homeworks.main.view.activity.MainActivity;
import com.digio.homeworks.main.view.fragment.LessonsListFragment;
import com.digio.homeworks.main.view.interfaces.Presenter;

public class MainPresenter implements Presenter {

    private MainPresenter.View mainView;

    public MainPresenter(MainPresenter.View mainView) {
        this.mainView = mainView;
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
        SharedPreferences pref = mainView.getSharedPreferences();
        String user = pref.getString("ACCOUNT_USER", null);
        String email = pref.getString("ACCOUNT_EMAIL", null);
        if(user != null) {
            mainView.userSignIn(user, email);
        }
        else {
            mainView.anonymousSignIn();
        }
    }

    public interface View {

        Context getContext();
        void userSignIn(String user, String email);
        void anonymousSignIn();
        SharedPreferences getSharedPreferences();

    }
}
