package com.newgear.android.model;

import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("status")
    protected int status;

    public Response(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
