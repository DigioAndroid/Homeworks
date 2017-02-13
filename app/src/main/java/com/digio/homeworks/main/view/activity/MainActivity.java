package com.digio.homeworks.main.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.digio.homeworks.R;
import com.digio.homeworks.main.view.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity {

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Show toolbar with main title
        Toolbar toolbar = (Toolbar)findViewById(R.id.mainToolbar);
        TextView mainTitle = (TextView)toolbar.findViewById(R.id.toolbarTitle);
        mainTitle.setText(getString(R.string.main_title));
        setSupportActionBar(toolbar);

        // Create fragment and add it to container
        getMainPresenter().showList();
    }

    /**
     * Get MainPresenter instance creating it if needed
     * @return
     */
    public MainPresenter getMainPresenter() {
        if (mainPresenter == null) mainPresenter = new MainPresenter(this);
        return mainPresenter;
    }

}
