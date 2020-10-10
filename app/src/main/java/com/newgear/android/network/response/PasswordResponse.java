package com.newgear.android.network.response;

import com.google.gson.annotations.SerializedName;

public class PasswordResponse {
    @SerializedName("status")
    protected int status;

    public PasswordResponse(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
