package com.digio.homeworks.login.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.digio.homeworks.R;
import com.digio.homeworks.login.view.presenter.LoginPresenter;
import com.digio.homeworks.main.view.activity.MainActivity;
import com.digio.homeworks.main.view.activity.ParentActivity;
import com.digio.homeworks.main.view.interfaces.Presenter;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends ParentActivity implements LoginPresenter.View {

    @BindView(R.id.btnLogin) Button btnLogin;
    private LoginPresenter loginPresenter;
    @BindView(R.id.loginToolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Bind Views with Butterknife
        ButterKnife.bind(this);

        // Show toolbar with login welcome title
        toolbar.setTitle(getString(R.string.login_title));
        setSupportActionBar(toolbar);
    }

    @NonNull
    @Override
    public Presenter getPresenter() {
        if(loginPresenter == null) {
            loginPresenter = new LoginPresenter(this);
        }
        return loginPresenter;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == LoginPresenter.RC_SIGN_IN) {
            ((LoginPresenter)getPresenter()).signInRequestHandle(data);
        }
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

    /**
     * Launch MainActivity
     */
    @Override
    public void showMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btnLogin)
    public void onLoginClick(View v) {
        ((LoginPresenter)getPresenter()).signIn();
    }

    @OnClick(R.id.btnAnonymousLogin)
    public void onAnonymousClick(View v) {
        showMain();
    }
}
