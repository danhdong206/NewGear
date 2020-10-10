package com.newgear.android.data.model;

import android.text.TextUtils;

public class UserPassword {
    private String password;

    public UserPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
