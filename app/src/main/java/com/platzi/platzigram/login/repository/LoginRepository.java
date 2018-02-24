package com.platzi.platzigram.login.repository;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by moises on 21/01/18.
 */

public interface LoginRepository {
    void singIn(String username, String password, Activity activity, FirebaseAuth firebaseAuth);
}
