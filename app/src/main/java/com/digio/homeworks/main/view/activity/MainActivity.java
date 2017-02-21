package com.digio.homeworks.main.view.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.digio.homeworks.R;
import com.digio.homeworks.login.view.interfaces.LoginView;
import com.digio.homeworks.login.view.presenter.LoginPresenter;
import com.digio.homeworks.main.view.interfaces.MainView;
import com.digio.homeworks.main.view.presenter.MainPresenter;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView, NavigationView.OnNavigationItemSelectedListener{

    private LoginPresenter loginPresenter;
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

        // Set Navigation listener
        navView.setNavigationItemSelectedListener(this);

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

            // Show Sign-out button and hide Sign-in button
            MenuItem btnSignOut = navView.getMenu().findItem(R.id.nav_sign_out_opt);
            btnSignOut.setVisible(true);
            MenuItem btnSignIn = navView.getMenu().findItem(R.id.nav_sign_in_opt);
            btnSignIn.setVisible(false);
        }

        // Enable hamburger menu
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerToggle.syncState();
    }

    /**
     * Handle NavigationDrawer item events
     * @param item
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.nav_profile_opt:
                showProfile();
                break;
            case R.id.nav_my_lessons_opt:
                showLessons();
                break;
            case R.id.nav_settings_opt:
                showSettings();
                break;
            case R.id.nav_sign_in_opt:
                handleLogin(item);
                break;
            case R.id.nav_sign_out_opt:
                handleLogout(item);
                break;
            case R.id.nav_search_opt:
                showSearch();
                break;
            case R.id.nav_my_students_opt:
                showStudents();
                break;
            default:
                showMessages();
        }
        return true;
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

    /**
     * Launch ProfileActivity
     */
    private void showProfile() {
        // TODO: Implement
    }

    /**
     * Launch MyLessonsActivity
     */
    private void showLessons() {
        // TODO: Implement
    }

    /**
     * Launch SettingsActivity
     */
    private void showSettings() {
        // TODO: Implement
    }

    /**
     * Sign-in using Google Sign-in API
     */
    private void handleLogin(MenuItem item) {
        // Hide Sign-in button and show Sign-out button
        MenuItem btnSignOut = navView.getMenu().findItem(R.id.nav_sign_out_opt);
        btnSignOut.setVisible(true);
        item.setVisible(false);

        // TODO: Implement
    }

    /**
     * Sign-out Google account
     */
    private void handleLogout(MenuItem item) {
        // Hide Sign-out button and show Sign-in button
        MenuItem btnSignIn = navView.getMenu().findItem(R.id.nav_sign_in_opt);
        btnSignIn.setVisible(true);
        item.setVisible(false);

        // TODO: Implement
    }

    /**
     * Launch SearchActivity
     */
    private void showSearch() {
        // TODO: Implement
    }

    /**
     * Launch StudentsActivity
     */
    private void showStudents() {
        // TODO: Implement
    }

    /**
     * Launch MessagesActivity
     */
    private void showMessages() {
        // TODO: Implement
    }
}
