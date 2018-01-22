package com.platzi.platzigram.login.repository;

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
    public void singIn(String username, String password) {
        boolean success = true;
        if(success){
            loginPresenter.loginSuccess();
        } else {
            loginPresenter.loginError("Ocurrió un error");
        }
    }
}
