package com.digio.homeworks.main.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.digio.homeworks.R;
import com.digio.homeworks.main.view.interfaces.MainView;
import com.digio.homeworks.main.view.presenter.MainPresenter;
import com.digio.homeworks.utils.DBUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{

    private MainPresenter mainPresenter;
    @BindView(R.id.mainToolbar) Toolbar toolbar;
    @BindView(R.id.toolbarTitle) TextView mainTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind Views with Butterknife
        ButterKnife.bind(this);

        // Show toolbar with main title
        mainTitle.setText(getString(R.string.main_title));
        setSupportActionBar(toolbar);

        //DBUtils.test();

        // Create fragment and add it to container
        getMainPresenter().showList();
    }

    /**
     * Get MainPresenter instance creating it if needed
     * @return
     */
    public MainPresenter getMainPresenter() {
        if(mainPresenter == null) {
            mainPresenter = new MainPresenter(this);
        }
        return mainPresenter;
    }

}
