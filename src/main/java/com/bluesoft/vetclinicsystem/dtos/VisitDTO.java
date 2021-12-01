package com.bluesoft.vetclinicsystem.dtos;

import javax.validation.constraints.NotNull;

public class VisitDTO {

    private int id;

    @NotNull(message = "Pet is required")
    private Integer petId;

    @NotNull(message = "Doctor is required")
    private Integer doctorId;

    @NotNull(message = "Clinic is required")
    private Integer clinicId;

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
}
