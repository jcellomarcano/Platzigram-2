package com.platzi.platzigram.login.view;

/**
 * Created by xor503 on 08/12/2017.
 */

public interface LoginView {

    void enableInputs();
    void disabledInputs();

    void showProgressBar();
    void hideProgressBar();

    void loginError(String error);

    void goCreateAccount();
    void goHome();
}
