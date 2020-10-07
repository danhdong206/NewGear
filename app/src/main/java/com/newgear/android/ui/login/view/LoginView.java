package com.newgear.android.ui.login.view;

public interface LoginView {
    void showProgress();

    void hideProgress();

    void showError(String message);

    void showComplete(String message);
}
