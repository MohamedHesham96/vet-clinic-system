package com.bluesoft.vetclinicsystem.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClinicDTO {

    private int id;

    @NotNull(message = "Clinic name is required")
    @NotBlank(message = "Clinic name is required")
    @Size(max = 50, message = "Clinic name max size is 50")
    private String name;

    @NotNull(message = "Clinic address is required")
    @NotBlank(message = "Clinic address is required")
    @Size(max = 100, message = "Clinic address max size is 11")
    private String address;

    @NotNull(message = "Clinic phone is required")
    @NotBlank(message = "Clinic phone is required")
    @Size(max = 11, message = "Clinic phone max size is 11")
    private String phone;

    @Size(max = 100, message = "Clinic workingDaysHours max size is 11")
    private String workingDaysHours;

    @Size(max = 100, message = "Clinic email max size is 11")
    private String email;

    @Size(max = 500, message = "Clinic socialNetworksUrls max size is 11")
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
