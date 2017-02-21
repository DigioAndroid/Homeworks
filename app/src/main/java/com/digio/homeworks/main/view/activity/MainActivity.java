package com.digio.homeworks.main.view.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.digio.homeworks.R;
import com.digio.homeworks.main.view.interfaces.MainView;
import com.digio.homeworks.main.view.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{

    private MainPresenter mainPresenter;
    @BindView(R.id.drawerLayout) DrawerLayout drawerLayout;
    @BindView(R.id.mainToolbar) Toolbar toolbar;
    @BindView(R.id.toolbarTitle) TextView mainTitle;
    @BindView(R.id.mainNavView) NavigationView navView;

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

        // Set NavigationDrawer username and email if needed
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            // Get header view
            View headerView = navView.getHeaderView(0);

            // Get header textviews
            TextView userName = ButterKnife.findById(headerView, R.id.navHeaderUser);
            TextView email = ButterKnife.findById(headerView, R.id.navHeaderEmail);

            // Set account information
            userName.setText(bundle.getString("ACCOUNT_USER"));
            email.setText(bundle.getString("ACCOUNT_EMAIL"));
        }

        // Enable hamburger menu
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerToggle.syncState();
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
