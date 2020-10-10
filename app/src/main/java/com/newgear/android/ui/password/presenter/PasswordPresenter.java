package com.newgear.android.ui.password.presenter;

public interface PasswordPresenter {
    void loadPassword(String mPhoneNumber, String mPassword);
    void onLoginPassword(String mPassword);
}
