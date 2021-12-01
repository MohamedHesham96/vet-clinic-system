package com.bluesoft.vetclinicsystem.services.Impl;

import com.bluesoft.vetclinicsystem.entities.Doctor;
import com.bluesoft.vetclinicsystem.repositories.DoctorRepository;
import com.bluesoft.vetclinicsystem.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAllByClinicId(Integer clinicId) {
        return doctorRepository.findAllByClinicId(clinicId);
    }
}
