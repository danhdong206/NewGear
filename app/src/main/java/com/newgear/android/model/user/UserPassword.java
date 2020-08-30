package com.newgear.android.model.user;

import android.text.TextUtils;

public class UserPassword implements IUserPassword {

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
