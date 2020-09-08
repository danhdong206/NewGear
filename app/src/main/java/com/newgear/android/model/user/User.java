package com.newgear.android.model.user;


import android.text.TextUtils;
import android.util.Patterns;

import com.newgear.android.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import javax.inject.Inject;

@Table(database = MyDatabase.class, name = "User")
public class User extends BaseModel implements IUser {
    @PrimaryKey
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String apiToken;
    @Column
    private String role;
    @Column
    private String subRole;
    @Column
    private String imageID;
    @Column
    private String tmsAPIToken;
    @Column
    private String firebaseToken;
    @Column
    private int gender;
    @Column
    private String locale;
    @Column
    private String image;
    @Column
    private String phoneNumber;
    @Column
    private String dateOfBirthday;
    @Column
    private String qualification;
    @Column
    private int workingInfo;
    @Column
    private int totalPoint;

    private String password;

    public User() {

    }

    public User(int id, String name, String apiToken, String role, String subRole, String imageID, String tmsAPIToken, String firebaseToken, int gender, String locale, String image, String phoneNumber, String dateOfBirthday, String qualification, int workingInfo, int totalPoint) {
        this.id = id;
        this.name = name;
        this.apiToken = apiToken;
        this.role = role;
        this.subRole = subRole;
        this.imageID = imageID;
        this.tmsAPIToken = tmsAPIToken;
        this.firebaseToken = firebaseToken;
        this.gender = gender;
        this.locale = locale;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.dateOfBirthday = dateOfBirthday;
        this.qualification = qualification;
        this.workingInfo = workingInfo;
        this.totalPoint = totalPoint;
    }

    public User(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSubRole() {
        return subRole;
    }

    public void setSubRole(String subRole) {
        this.subRole = subRole;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getTmsAPIToken() {
        return tmsAPIToken;
    }

    public void setTmsAPIToken(String tmsAPIToken) {
        this.tmsAPIToken = tmsAPIToken;
    }

    public String getFirebaseToken() {
        return firebaseToken;
    }

    public void setFirebaseToken(String firebaseToken) {
        this.firebaseToken = firebaseToken;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getWorkingInfo() {
        return workingInfo;
    }

    public void setWorkingInfo(int workingInfo) {
        this.workingInfo = workingInfo;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    @Override
    public int isValidData() {
        if (TextUtils.isEmpty(getPhoneNumber()))
            return 0;
        else if (getPhoneNumber().length() < 6)
            return 1;
        else if (getPhoneNumber().length() > 12)
            return 2;
        else
            return -1;
    }
}
