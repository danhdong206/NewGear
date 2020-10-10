package com.newgear.android.ui.password.view;

public interface PasswordView {
    void showProgress();

    void hideProgress();

    void showError(String message);

    void showComplete(String message);
}
