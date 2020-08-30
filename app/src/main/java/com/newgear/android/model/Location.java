package com.newgear.android.model;


import com.newgear.android.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDatabase.class, name = "Location")
public class Location extends BaseModel {
    @PrimaryKey
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String city;
    @Column
    private String longitude;
    @Column
    private String latitude;
    @Column
    private int transportationCompanyID;

    public Location() {

    }

    public Location(int id, String name, String city, String longitude, String latitude, int transportationCompanyID) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
        this.transportationCompanyID = transportationCompanyID;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public int getTransportationCompanyID() {
        return transportationCompanyID;
    }

    public void setTransportationCompanyID(int transportationCompanyID) {
        this.transportationCompanyID = transportationCompanyID;
    }
}
