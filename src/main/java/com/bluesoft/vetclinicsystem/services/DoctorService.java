package com.bluesoft.vetclinicsystem.services;

import com.bluesoft.vetclinicsystem.entities.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAllByClinicId(Integer clinicId);
}
