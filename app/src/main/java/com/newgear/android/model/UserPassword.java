package com.newgear.android.model;

import android.text.TextUtils;

import com.newgear.android.mvp.login.LoginModel;
import com.newgear.android.mvp.password.PasswordModel;

public class UserPassword implements PasswordModel {
    private String password;

    public UserPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidData() {
        if (TextUtils.isEmpty(getPassword()))
            return 0;
        else if (getPassword().length() < 6)
            return 1;
        else if (getPassword().length() > 127)
            return 2;
        else
            return -1;
    }
}
