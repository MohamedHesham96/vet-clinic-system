package com.bluesoft.vetclinicsystem.services;

import com.bluesoft.vetclinicsystem.dtos.DoctorDTO;
import com.bluesoft.vetclinicsystem.entities.Clinic;
import com.bluesoft.vetclinicsystem.entities.Doctor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DoctorService {

    Doctor getDoctor(Integer doctorId);

    List<Doctor> getAllByClinicId(Integer clinicId);

    Doctor saveDoctor(DoctorDTO doctorDTO) throws IOException;

    Doctor updateDoctorPhoto(Doctor doctor, MultipartFile doctorPhoto) throws IOException;

    Doctor assignDoctorToClinic(Doctor doctor, Clinic clinic);

    Doctor deassignToClinic(Doctor doctor);
}
