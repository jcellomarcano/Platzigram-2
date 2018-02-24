package com.platzi.platzigram.login.interactor;


import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;
import com.platzi.platzigram.login.presenter.LoginPresenter;
import com.platzi.platzigram.login.repository.LoginRepository;
import com.platzi.platzigram.login.repository.LoginRepositoryImpl;

public class LoginInteractorImpl implements LoginInteractor {

    private LoginPresenter loginPresenter;
    private LoginRepository loginRepository;

    public LoginInteractorImpl(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
        loginRepository = new LoginRepositoryImpl(loginPresenter);
    }

    @Override
    public void singIn(String username, String password, Activity activity, FirebaseAuth firebaseAuth) {
        loginRepository.singIn(username, password, activity, firebaseAuth);
    }
}
