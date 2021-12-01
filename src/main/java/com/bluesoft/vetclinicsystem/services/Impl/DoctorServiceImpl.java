package com.bluesoft.vetclinicsystem.services.Impl;

import com.bluesoft.vetclinicsystem.dtos.DoctorDTO;
import com.bluesoft.vetclinicsystem.entities.Clinic;
import com.bluesoft.vetclinicsystem.entities.Doctor;
import com.bluesoft.vetclinicsystem.repositories.DoctorRepository;
import com.bluesoft.vetclinicsystem.services.DoctorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

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
        BeanUtils.copyProperties(doctorDTO, doctor);
        doctor.setClinic(new Clinic(doctorDTO.getClinicId()));
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllByClinicId(Integer clinicId) {
        return doctorRepository.findAllByClinicId(clinicId);
    }

}
