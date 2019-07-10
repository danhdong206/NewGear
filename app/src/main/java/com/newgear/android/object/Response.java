package com.newgear.android.object;

import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("status")
    private int status;

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
