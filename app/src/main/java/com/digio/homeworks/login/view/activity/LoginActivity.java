package com.digio.homeworks.login.view.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.digio.homeworks.R;
import com.digio.homeworks.login.view.presenter.LoginPresenter;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btnLogin) Button btnLogin;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Bind Views with Butterknife
        ButterKnife.bind(this);

        // Show toolbar with login welcome title
        Toolbar toolbar = (Toolbar)findViewById(R.id.loginToolbar);
        TextView loginTitle = (TextView)toolbar.findViewById(R.id.toolbarTitle);
        loginTitle.setText(getString(R.string.login_title));
        setSupportActionBar(toolbar);
    }

    @Override
    public void onStart() {
        super.onStart();
        getLoginPresenter().onActivityStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        getLoginPresenter().onActivityStop();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getLoginPresenter().onActivityResult(requestCode, resultCode, data);
    }

    @OnClick(R.id.btnLogin)
    public void onClick(View v) {
        getLoginPresenter().onLoginClick();
    }

    /**
     * Get LoginPresenter instance creating it if needed
     * @return
     */
    public LoginPresenter getLoginPresenter() {
        if (loginPresenter == null) loginPresenter = new LoginPresenter(this);
        return loginPresenter;
    }

}
