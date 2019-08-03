package com.newgear.android.model.timeline;

import com.google.gson.annotations.SerializedName;
import com.newgear.android.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDatabase.class, name = "PartnerRating")
public class PartnerRating extends BaseModel {
    @Column
    @SerializedName("inspection_group_id")
    private int inspectationGroupID;
    @Column
    @SerializedName("finished_at_time_seconds")
    private int finishedAtTimeSeconds;
    @Column
    @SerializedName("location_name")
    private String locationName;
    @Column
    @SerializedName("task_type")
    private String taskType;
    @Column
    @SerializedName("user_name")
    private String userName;
    @Column
    @SerializedName("user_role")
    private String userRole;
    @Column
    @SerializedName("user_image")
    private String userImage;
    @PrimaryKey
    @Column
    @SerializedName("id")
    private int id;
    @Column
    @SerializedName("rating_score")
    private String ratingScore;
    @Column
    @SerializedName("rating_comment")
    private String ratingComment;
    @Column
    @SerializedName("skip_signature")
    private boolean skipSignature;
    @Column
    @SerializedName("skip_inspection")
    private boolean skipInspection;

    public PartnerRating() {

    }

    public PartnerRating(int inspectationGroupID, int finishedAtTimeSeconds, String locationName, String taskType, String userName, String userRole, String userImage, int id, String ratingScore, String ratingComment, boolean skipSignature, boolean skipInspection) {
        this.inspectationGroupID = inspectationGroupID;
        this.finishedAtTimeSeconds = finishedAtTimeSeconds;
        this.locationName = locationName;
        this.taskType = taskType;
        this.userName = userName;
        this.userRole = userRole;
        this.userImage = userImage;
        this.id = id;
        this.ratingScore = ratingScore;
        this.ratingComment = ratingComment;
        this.skipSignature = skipSignature;
        this.skipInspection = skipInspection;
    }

    public int getInspectationGroupID() {
        return inspectationGroupID;
    }

    public void setInspectationGroupID(int inspectationGroupID) {
        this.inspectationGroupID = inspectationGroupID;
    }

    public int getFinishedAtTimeSeconds() {
        return finishedAtTimeSeconds;
    }

    public void setFinishedAtTimeSeconds(int finishedAtTimeSeconds) {
        this.finishedAtTimeSeconds = finishedAtTimeSeconds;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(String ratingScore) {
        this.ratingScore = ratingScore;
    }

    public String getRatingComment() {
        return ratingComment;
    }

    public void setRatingComment(String ratingComment) {
        this.ratingComment = ratingComment;
    }

    public boolean isSkipSignature() {
        return skipSignature;
    }

    public void setSkipSignature(boolean skipSignature) {
        this.skipSignature = skipSignature;
    }

    public boolean isSkipInspection() {
        return skipInspection;
    }

    public void setSkipInspection(boolean skipInspection) {
        this.skipInspection = skipInspection;
    }
}
