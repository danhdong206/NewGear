package com.newgear.android.presenter;

import com.newgear.android.model.user.User;
import com.newgear.android.model.user.UserPassword;
import com.newgear.android.view.ILoginViewPassword;
import com.newgear.android.view.ILoginViewPhoneNumber;

public class LoginPresenter implements ILoginPresenter {

    ILoginViewPhoneNumber loginViewPhoneNumber;
    ILoginViewPassword loginViewPassword;

    public LoginPresenter(ILoginViewPhoneNumber loginViewPhoneNumber) {
        this.loginViewPhoneNumber = loginViewPhoneNumber;
    }

    public LoginPresenter(ILoginViewPassword loginViewPassword) {
        this.loginViewPassword = loginViewPassword;
    }

    @Override
    public void onLoginPhoneNumber(String phoneNumber) {
        User user = new User(phoneNumber);
        int loginCode = user.isValidData();

        if (loginCode == 0)
            loginViewPhoneNumber.onLoginPhoneNumberError("You must enter your phone number");
        else if (loginCode == 1)
            loginViewPhoneNumber.onLoginPhoneNumberError("Phone number must be at least 6 characters");
        else if (loginCode == 2)
            loginViewPhoneNumber.onLoginPhoneNumberError("Phone number must be at most 12 characters");
    }

    @Override
    public void onLoginPassword(String password) {
        UserPassword userPassword = new UserPassword(password);
        int loginCode = userPassword.isValidData();

        if (loginCode == 0) {
            loginViewPassword.onLoginPasswordError("You must enter your password");
        } else if (loginCode == 1) {
            loginViewPassword.onLoginPasswordError("Password must be at least 6 characters");
        } else if (loginCode == 2) {
            loginViewPassword.onLoginPasswordError("Password must be at most 127 characters");
        }
    }
}
