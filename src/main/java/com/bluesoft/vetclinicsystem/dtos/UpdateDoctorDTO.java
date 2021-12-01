package com.bluesoft.vetclinicsystem.dtos;

public class UpdateDoctorDTO {

    private boolean isAssigned;
    private Integer clinicId;

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setIsAssigned(boolean assigned) {
        isAssigned = assigned;
    }

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }
}
