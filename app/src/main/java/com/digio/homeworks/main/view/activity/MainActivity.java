package com.digio.homeworks.main.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.digio.homeworks.R;
import com.digio.homeworks.main.view.fragment.LessonsListFragment;
import com.digio.homeworks.main.view.interfaces.Presenter;
import com.digio.homeworks.main.view.presenter.MainPresenter;
import com.digio.homeworks.profile.view.activity.ProfileActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends ParentActivity implements MainPresenter.View, NavigationView.OnNavigationItemSelectedListener{

    private MainPresenter mainPresenter;
    @BindView(R.id.drawerLayout) DrawerLayout drawerLayout;
    @BindView(R.id.mainToolbar) Toolbar toolbar;
    @BindView(R.id.mainNavView) NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind Views with Butterknife
        ButterKnife.bind(this);

        // Show toolbar with main title
        toolbar.setTitle(getString(R.string.main_title));
        setSupportActionBar(toolbar);

        //DBUtils.test();

        // Create fragment and add it to container
        showList();

        // Set Navigation listener
        navView.setNavigationItemSelectedListener(this);

        // Configure NavigationDrawer options
        ((MainPresenter)getPresenter()).handleAccountInfo();

        // Enable hamburger menu
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerToggle.syncState();
    }

    /**
     * Show LessonsListFragment
     */
    private void showList() {
        // Get fragment manager
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        // Create LessonsList fragment
        LessonsListFragment llf = new LessonsListFragment();

        // Add fragment to container
        ft.replace(R.id.listContainer, llf);
        ft.commit();
    }

    @NonNull
    @Override
    public Presenter getPresenter() {
        if(mainPresenter == null) {
            mainPresenter = new MainPresenter(this);
        }
        return mainPresenter;
    }

    /**
     * Configure NavigationDrawer for signed-in user
     * @param userName
     * @param userEmail
     */
    public void userSignIn(String userName, String userEmail) {
        // Get header view
        View headerView = navView.getHeaderView(0);

        // Get header textviews
        TextView user = ButterKnife.findById(headerView, R.id.navHeaderUser);
        TextView email = ButterKnife.findById(headerView, R.id.navHeaderEmail);

        // Set account information
        user.setText(userName);
        email.setText(userEmail);

        // Show Sign-out button and hide Sign-in button
        MenuItem btnSignOut = navView.getMenu().findItem(R.id.nav_sign_out_opt);
        btnSignOut.setVisible(true);
        MenuItem btnSignIn = navView.getMenu().findItem(R.id.nav_sign_in_opt);
        btnSignIn.setVisible(false);
    }

    /**
     * Configure NavigationDrawer for anonymous user
     */
    public void anonymousSignIn() {
        // Disable profile, my lessons, my students and messages buttons
        MenuItem btnProfile = navView.getMenu().findItem(R.id.nav_profile_opt);
        btnProfile.setEnabled(false);
        MenuItem btnLessons = navView.getMenu().findItem(R.id.nav_my_lessons_opt);
        btnLessons.setEnabled(false);
        MenuItem btnStudents = navView.getMenu().findItem(R.id.nav_my_students_opt);
        btnStudents.setEnabled(false);
        MenuItem btnMessages = navView.getMenu().findItem(R.id.nav_messages_opt);
        btnMessages.setEnabled(false);
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
     * Launch ProfileActivity
     */
    private void showProfile() {
        // TODO: Implement
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
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


    @Override
    public Context getContext() {
        return this;
    }

    /**
     * Get shared preferences
     * @return
     */
    @Override
    public SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    }
}
