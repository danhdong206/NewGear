package com.newgear.android.model.timeline;

import com.google.gson.annotations.SerializedName;
import com.newgear.android.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDatabase.class, name = "DriverInfo")
public class DriverInfo extends BaseModel {
    @Column
    @SerializedName("trailer_number")
    private String trailerNumber;
    @Column
    @SerializedName("user_name")
    private String userName;
    @Column
    @SerializedName("user_role")
    private String userRole;
    @Column
    @SerializedName("user_image")
    private String userImage;
    @Column
    @PrimaryKey
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
