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

@Table(database = MyDatabase.class, name = "TasksMini")
public class TasksMini extends BaseModel {
    @PrimaryKey
    @Column
    @SerializedName("id")
    private int id;
    @Column
    @SerializedName("sequence")
    private int sequence;
    @Column
    @SerializedName("task_type")
    private String taskType;
    @Column
    @SerializedName("updated_at_time_seconds")
    private int updatedAtTimeSeconds;
    @Column
    @SerializedName("received_cargo_at_time_seconds")
    private int receivedCargoAtTimeSeconds;
    @Column
    @SerializedName("inspection_group_status")
    private String inspectionGroupStatus;
    @Column
    @SerializedName("inspection_group_type")
    private String inspectionGroupType;
    @Column
    @SerializedName("location")
    private String location;
    @Column
    @SerializedName("is_handler")
    private boolean isHandler;
    @Column
    @SerializedName("task_status")
    private String taskStatus;

    @SerializedName("partner_rating")
    private List<PartnerRating> partnerRatings;

    @SerializedName("driver_info")
    private List<DriverInfo> driverInfos;

    public TasksMini() {

    }

    public TasksMini(int id, int sequence, String taskType, int updatedAtTimeSeconds, int receivedCargoAtTimeSeconds, String inspectionGroupStatus, String inspectionGroupType, String location, boolean isHandler, String taskStatus, List<PartnerRating> partnerRatings, List<DriverInfo> driverInfos) {
        this.id = id;
        this.sequence = sequence;
        this.taskType = taskType;
        this.updatedAtTimeSeconds = updatedAtTimeSeconds;
        this.receivedCargoAtTimeSeconds = receivedCargoAtTimeSeconds;
        this.inspectionGroupStatus = inspectionGroupStatus;
        this.inspectionGroupType = inspectionGroupType;
        this.location = location;
        this.isHandler = isHandler;
        this.taskStatus = taskStatus;
        this.partnerRatings = partnerRatings;
        this.driverInfos = driverInfos;
    }

    @Inject
    public TasksMini(List<PartnerRating> partnerRatings, List<DriverInfo> driverInfos) {
        this.partnerRatings = partnerRatings;
        this.driverInfos = driverInfos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public int getUpdatedAtTimeSeconds() {
        return updatedAtTimeSeconds;
    }

    public void setUpdatedAtTimeSeconds(int updatedAtTimeSeconds) {
        this.updatedAtTimeSeconds = updatedAtTimeSeconds;
    }

    public int getReceivedCargoAtTimeSeconds() {
        return receivedCargoAtTimeSeconds;
    }

    public void setReceivedCargoAtTimeSeconds(int receivedCargoAtTimeSeconds) {
        this.receivedCargoAtTimeSeconds = receivedCargoAtTimeSeconds;
    }

    public String getInspectionGroupStatus() {
        return inspectionGroupStatus;
    }

    public void setInspectionGroupStatus(String inspectionGroupStatus) {
        this.inspectionGroupStatus = inspectionGroupStatus;
    }

    public String getInspectionGroupType() {
        return inspectionGroupType;
    }

    public void setInspectionGroupType(String inspectionGroupType) {
        this.inspectionGroupType = inspectionGroupType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isHandler() {
        return isHandler;
    }

    public void setHandler(boolean handler) {
        isHandler = handler;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public List<PartnerRating> getPartnerRatings() {
        return partnerRatings;
    }

    public void setPartnerRatings(List<PartnerRating> partnerRatings) {
        this.partnerRatings = partnerRatings;
    }

    public List<DriverInfo> getDriverInfos() {
        return driverInfos;
    }

    public void setDriverInfos(List<DriverInfo> driverInfos) {
        this.driverInfos = driverInfos;
    }
}
