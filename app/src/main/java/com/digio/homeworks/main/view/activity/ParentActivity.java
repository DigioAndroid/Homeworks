package com.digio.homeworks.main.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.digio.homeworks.main.view.interfaces.Presenter;

/**
 * Created by Isidoro on 1/3/17.
 */

public abstract class ParentActivity extends AppCompatActivity {

    @NonNull
    public abstract Presenter getPresenter();

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getPresenter().create();
    }

    @Override protected void onStart() {
        super.onStart();

        getPresenter().start();
    }

    @Override protected void onStop() {
        super.onStop();

        getPresenter().stop();
    }

    @Override protected void onDestroy() {
        super.onDestroy();

        getPresenter().destroy();
    }
}
