package com.bluesoft.vetclinicsystem.dtos;

import com.googlecode.jmapper.annotations.JMap;

public class ClinicDTO {

    @JMap
    private int id;

    @JMap
    private String name;

    @JMap
    private String address;

    @JMap
    private String phone;

    @JMap
    private String workingDaysHours;

    @JMap
    private String email;

    @JMap
    private String socialNetworksUrls;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkingDaysHours() {
        return workingDaysHours;
    }

    public void setWorkingDaysHours(String workingDaysHours) {
        this.workingDaysHours = workingDaysHours;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialNetworksUrls() {
        return socialNetworksUrls;
    }

    public void setSocialNetworksUrls(String socialNetworksUrls) {
        this.socialNetworksUrls = socialNetworksUrls;
    }
}
