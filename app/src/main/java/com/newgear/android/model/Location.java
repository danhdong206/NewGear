package com.newgear.android.model;


import com.google.gson.annotations.SerializedName;


public class Location {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("city")
    private String city;

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("transportation_company_id")
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
