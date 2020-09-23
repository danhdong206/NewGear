package com.newgear.android.model.timeline;

import com.google.gson.annotations.SerializedName;


public class DriverInfo {

    @SerializedName("trailer_number")
    private String trailerNumber;

    @SerializedName("user_name")
    private String userName;

    @SerializedName("user_role")
    private String userRole;

    @SerializedName("user_image")
    private String userImage;

    @SerializedName("eta")
    private int eta;

    public DriverInfo() {

    }

    public DriverInfo(String trailerNumber, String userName, String userRole, String userImage, int eta) {
        this.trailerNumber = trailerNumber;
        this.userName = userName;
        this.userRole = userRole;
        this.userImage = userImage;
        this.eta = eta;
    }

    public String getTrailerNumber() {
        return trailerNumber;
    }

    public void setTrailerNumber(String trailerNumber) {
        this.trailerNumber = trailerNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
}
