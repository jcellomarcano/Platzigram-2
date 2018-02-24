package com.platzi.platzigram.login.repository;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.platzi.platzigram.login.presenter.LoginPresenter;

/**
 * Created by moises on 21/01/18.
 */

public class LoginRepositoryImpl implements LoginRepository {

    private LoginPresenter loginPresenter;

    public LoginRepositoryImpl(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void singIn(String username, String password, Activity activity, FirebaseAuth firebaseAuth) {
        firebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    loginPresenter.loginSuccess();
                } else {
                    loginPresenter.loginError("Ha ocurrido un error");
                }
            }
        });
    }
}
