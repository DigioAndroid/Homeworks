package com.digio.homeworks.main.view.presenter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.digio.homeworks.R;
import com.digio.homeworks.main.view.activity.MainActivity;
import com.digio.homeworks.main.view.fragment.LessonsListFragment;
import com.digio.homeworks.main.view.interfaces.MainView;
import com.digio.homeworks.main.view.interfaces.Presenter;

public class MainPresenter implements Presenter {

    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    @Override public void create() {

    }

    @Override public void start() {

    }

    @Override public void stop() {

    }

    @Override public void destroy() {

    }

    public void showList() {
        // Get fragment manager
        FragmentManager manager = ((MainActivity) mainView).getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        // Create LessonsList fragment
        LessonsListFragment llf = new LessonsListFragment();

        // Add fragment to container
        ft.replace(R.id.listContainer, llf);
        ft.commit();
    }
}
