package com.newgear.android.model.timeline;

import com.google.gson.annotations.SerializedName;
import com.newgear.android.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.ArrayList;
import java.util.List;

@Table(database = MyDatabase.class, name = "NewTaskGroup")
public class NewTaskGroup extends BaseModel {
    @PrimaryKey
    @Column
    @SerializedName("id")
    private int id;
    @Column
    @SerializedName("reject_reason")
    private String rejectReason;
    @Column
    @SerializedName("status")
    private String status;
    @Column
    @SerializedName("updated_at_time_seconds")
    private int updatedAtTimeSeconds;
    @Column
    @SerializedName("assignment_number")
    private String assignmentNumber;
    @Column
    @SerializedName("sent_at_time_seconds")
    private int sentAtTimeSeconds;
    @Column
    @SerializedName("confirmed_at_time_seconds")
    private int confirmedAtTimeSeconds;
    @Column
    @SerializedName("started_at_time_seconds")
    private int startedAtTimeSeconds;
    @Column
    @SerializedName("cargos_number")
    private int cargosNumber;
    @Column
    @SerializedName("cancelled_cargos_number")
    private int cancelledCargosNumber;
    @Column
    @SerializedName("is_delivered")
    private boolean isDelivered;
    @Column
    @SerializedName("transportation_company_name")
    private String transportationCompanyName;
    @SerializedName("tasks_mini")
    private List<TasksMini> tasksMinis;

    public NewTaskGroup() {

    }

    public NewTaskGroup(int id, String rejectReason, String status, int updatedAtTimeSeconds, String assignmentNumber, int sentAtTimeSeconds, int confirmedAtTimeSeconds, int startedAtTimeSeconds, int cargosNumber, int cancelledCargosNumber, boolean isDelivered, String transportationCompanyName, List<TasksMini> tasksMinis) {
        this.id = id;
        this.rejectReason = rejectReason;
        this.status = status;
        this.updatedAtTimeSeconds = updatedAtTimeSeconds;
        this.assignmentNumber = assignmentNumber;
        this.sentAtTimeSeconds = sentAtTimeSeconds;
        this.confirmedAtTimeSeconds = confirmedAtTimeSeconds;
        this.startedAtTimeSeconds = startedAtTimeSeconds;
        this.cargosNumber = cargosNumber;
        this.cancelledCargosNumber = cancelledCargosNumber;
        this.isDelivered = isDelivered;
        this.transportationCompanyName = transportationCompanyName;
        this.tasksMinis = tasksMinis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUpdatedAtTimeSeconds() {
        return updatedAtTimeSeconds;
    }

    public void setUpdatedAtTimeSeconds(int updatedAtTimeSeconds) {
        this.updatedAtTimeSeconds = updatedAtTimeSeconds;
    }

    public String getAssignmentNumber() {
        return assignmentNumber;
    }

    public void setAssignmentNumber(String assignmentNumber) {
        this.assignmentNumber = assignmentNumber;
    }

    public int getSentAtTimeSeconds() {
        return sentAtTimeSeconds;
    }

    public void setSentAtTimeSeconds(int sentAtTimeSeconds) {
        this.sentAtTimeSeconds = sentAtTimeSeconds;
    }

    public int getConfirmedAtTimeSeconds() {
        return confirmedAtTimeSeconds;
    }

    public void setConfirmedAtTimeSeconds(int confirmedAtTimeSeconds) {
        this.confirmedAtTimeSeconds = confirmedAtTimeSeconds;
    }

    public int getStartedAtTimeSeconds() {
        return startedAtTimeSeconds;
    }

    public void setStartedAtTimeSeconds(int startedAtTimeSeconds) {
        this.startedAtTimeSeconds = startedAtTimeSeconds;
    }

    public int getCargosNumber() {
        return cargosNumber;
    }

    public void setCargosNumber(int cargosNumber) {
        this.cargosNumber = cargosNumber;
    }

    public int getCancelledCargosNumber() {
        return cancelledCargosNumber;
    }

    public void setCancelledCargosNumber(int cancelledCargosNumber) {
        this.cancelledCargosNumber = cancelledCargosNumber;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public String getTransportationCompanyName() {
        return transportationCompanyName;
    }

    public void setTransportationCompanyName(String transportationCompanyName) {
        this.transportationCompanyName = transportationCompanyName;
    }

    public List<TasksMini> getTasksMinis() {
        return tasksMinis;
    }

    public void setTasksMinis(List<TasksMini> tasksMinis) {
        this.tasksMinis = tasksMinis;
    }
}
