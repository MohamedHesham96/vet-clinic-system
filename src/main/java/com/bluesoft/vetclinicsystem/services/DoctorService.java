package com.bluesoft.vetclinicsystem.services;

import com.bluesoft.vetclinicsystem.dtos.DoctorDTO;
import com.bluesoft.vetclinicsystem.entities.Clinic;
import com.bluesoft.vetclinicsystem.entities.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor getDoctor(Integer doctorId);

    List<Doctor> getAllByClinicId(Integer clinicId);

    Doctor saveDoctor(DoctorDTO doctorDTO);

    Doctor assignDoctorToClinic(Doctor doctor, Clinic clinic);

    Doctor deassignToClinic(Doctor doctor);
}
