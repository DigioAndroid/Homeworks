package com.digio.homeworks.login.view.interfaces;

import android.content.Context;
import android.support.annotation.Nullable;

import com.google.firebase.auth.FirebaseUser;

public interface LoginView {

    Context getContext();
    void showMain(@Nullable FirebaseUser fbUser);

}
