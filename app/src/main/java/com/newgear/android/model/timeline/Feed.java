package com.newgear.android.model.timeline;

import com.google.gson.annotations.SerializedName;
import com.newgear.android.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@Table(database = MyDatabase.class, name = "Feed")
public class Feed extends BaseModel {
    @PrimaryKey
    @Column
    @SerializedName("id")
    private int id;
    @Column
    @SerializedName("feed_type")
    private String feedType;
    @Column
    @SerializedName("transportation_company_id")
    private int transportationCompanyID;
    @Column
    @SerializedName("created_at_time_seconds")
    private int createdAtTimeSeconds;
    @Column
    @SerializedName("updated_at_time_seconds")
    private int updatedAtTimeSeconds;
    @Column
    @SerializedName("confirmed_at_time_seconds")
    private int confirmedAtTimeSeconds;
    @SerializedName("new_task_group")
    private List<NewTaskGroup> newTaskGroups;

    public Feed() {

    }

    public Feed(int id, String feedType, int transportationCompanyID, int createdAtTimeSeconds, int updatedAtTimeSeconds, int confirmedAtTimeSeconds, List<NewTaskGroup> newTaskGroups) {
        this.id = id;
        this.feedType = feedType;
        this.transportationCompanyID = transportationCompanyID;
        this.createdAtTimeSeconds = createdAtTimeSeconds;
        this.updatedAtTimeSeconds = updatedAtTimeSeconds;
        this.confirmedAtTimeSeconds = confirmedAtTimeSeconds;
        this.newTaskGroups = newTaskGroups;
    }

    @Inject
    public Feed(List<NewTaskGroup> newTaskGroups) {
        this.newTaskGroups = newTaskGroups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeedType() {
        return feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public int getTransportationCompanyID() {
        return transportationCompanyID;
    }

    public void setTransportationCompanyID(int transportationCompanyID) {
        this.transportationCompanyID = transportationCompanyID;
    }

    public int getCreatedAtTimeSeconds() {
        return createdAtTimeSeconds;
    }

    public void setCreatedAtTimeSeconds(int createdAtTimeSeconds) {
        this.createdAtTimeSeconds = createdAtTimeSeconds;
    }

    public int getUpdatedAtTimeSeconds() {
        return updatedAtTimeSeconds;
    }

    public void setUpdatedAtTimeSeconds(int updatedAtTimeSeconds) {
        this.updatedAtTimeSeconds = updatedAtTimeSeconds;
    }

    public int getConfirmedAtTimeSeconds() {
        return confirmedAtTimeSeconds;
    }

    public void setConfirmedAtTimeSeconds(int confirmedAtTimeSeconds) {
        this.confirmedAtTimeSeconds = confirmedAtTimeSeconds;
    }

    public List<NewTaskGroup> getNewTaskGroups() {
        return newTaskGroups;
    }

    public void setNewTaskGroups(List<NewTaskGroup> newTaskGroups) {
        this.newTaskGroups = newTaskGroups;
    }
}
