package com.digio.homeworks.main.view.presenter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.digio.homeworks.R;
import com.digio.homeworks.main.view.activity.MainActivity;
import com.digio.homeworks.main.view.fragment.LessonsListFragment;
import com.digio.homeworks.main.view.interfaces.MainView;

public class MainPresenter {

    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public void showList() {
        // Get fragment manager
        FragmentManager manager = ((MainActivity)mainView).getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        // Create LessonsList fragment
        LessonsListFragment llf = new LessonsListFragment();

        // Add fragment to container
        ft.replace(R.id.listContainer, llf);
        ft.commit();
    }

}
