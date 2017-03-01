package com.digio.homeworks.login.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.digio.homeworks.R;
import com.digio.homeworks.login.view.interfaces.LoginView;
import com.digio.homeworks.login.view.presenter.LoginPresenter;
import com.digio.homeworks.main.view.activity.MainActivity;
import com.digio.homeworks.main.view.activity.ParentActivity;
import com.digio.homeworks.main.view.interfaces.Presenter;
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

public class LoginActivity extends ParentActivity implements LoginView {

    @BindView(R.id.btnLogin) Button btnLogin;
    private LoginPresenter loginPresenter;
    @BindView(R.id.loginToolbar) Toolbar toolbar;
    @BindView(R.id.toolbarTitle) TextView loginTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Bind Views with Butterknife
        ButterKnife.bind(this);

        // Show toolbar with login welcome title
        loginTitle.setText(getString(R.string.login_title));
        setSupportActionBar(toolbar);
    }

    @NonNull @Override public LoginPresenter getPresenter() {
        if(loginPresenter == null) {
            loginPresenter = new LoginPresenter(this);
        }
        return loginPresenter;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getPresenter().onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public Context getContext() {
        return this;
    }

    /**
     * Launch MainActivity
     */
    @Override
    public void showMain(@Nullable FirebaseUser fbUser) {
        Intent intent = new Intent(this, MainActivity.class);
        if(fbUser != null) {
            Bundle bundle = new Bundle();
            bundle.putString("ACCOUNT_USER", fbUser.getDisplayName());
            bundle.putString("ACCOUNT_EMAIL", fbUser.getEmail());
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    @OnClick({R.id.btnLogin, R.id.btnAnonymousLogin})
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnLogin:
                getPresenter().signIn();
                break;
            default:
                showMain(null);
        }
    }
}
