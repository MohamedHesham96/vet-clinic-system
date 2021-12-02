package com.bluesoft.vetclinicsystem.services.Impl;

import com.bluesoft.vetclinicsystem.dtos.DoctorDTO;
import com.bluesoft.vetclinicsystem.entities.Clinic;
import com.bluesoft.vetclinicsystem.entities.Doctor;
import com.bluesoft.vetclinicsystem.repositories.DoctorRepository;
import com.bluesoft.vetclinicsystem.services.DoctorService;
import com.bluesoft.vetclinicsystem.services.FileUploadService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    FileUploadService fileUploadService;

    @Value("${com.bluesoft.fileupload.doctors-photos}")
    private String UPLOAD_DOCTOR_PHOTOS_DIRECTORY;

    @Override
    public Doctor getDoctor(Integer doctorId) {
        Optional<Doctor> clinicOptional = doctorRepository.findById(doctorId);
        if (clinicOptional.isPresent()) {
            return clinicOptional.get();
        }
        return null;
    }

    @Override
    public Doctor saveDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        Integer doctorId = doctorDTO.getId();
        BeanUtils.copyProperties(doctorDTO, doctor);
        doctor.setClinic(new Clinic(doctorId));
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor assignDoctorToClinic(Doctor doctor, Clinic clinic) {
        doctor.setClinic(clinic);
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor deassignToClinic(Doctor doctor) {
        doctor.setClinic(null);
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllByClinicId(Integer clinicId) {
        return doctorRepository.findAllByClinicId(clinicId);
    }

}
