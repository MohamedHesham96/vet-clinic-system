package com.bluesoft.vetclinicsystem.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class DoctorDTO {

    private int id;

    @NotNull(message = "Doctor name is required")
    @NotBlank(message = "Doctor name is required")
    @Size(max = 50, message = "Doctor name max size is 50")
    private String name;

    @Pattern(regexp = "^01[0-2|5]{1}[0-9]{8}", message = "Doctor phone is invalid")
    @NotNull(message = "Doctor phone is required")
    @NotBlank(message = "Doctor phone is required")
    @Size(max = 11, message = "Doctor phone max size is 11")
    private String phone;

    private String photo;

    private String bio;

    @NotNull(message = "Doctor clinic is required")
    private Integer clinicId;

    private ClinicDTO clinic;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public ClinicDTO getClinic() {
        return clinic;
    }

    public void setClinic(ClinicDTO clinic) {
        this.clinic = clinic;
    }
}
