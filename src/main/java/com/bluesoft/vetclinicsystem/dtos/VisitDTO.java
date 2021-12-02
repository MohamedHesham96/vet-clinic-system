package com.bluesoft.vetclinicsystem.dtos;

import javax.validation.constraints.NotNull;

public class VisitDTO {

    private int id;

    @NotNull(message = "Visit pet is required")
    private Integer petId;

    @NotNull(message = "Visit doctor is required")
    private Integer doctorId;

    @NotNull(message = "Visit clinic is required")
    private Integer clinicId;

    @NotNull(message = "Visit date is required")
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
