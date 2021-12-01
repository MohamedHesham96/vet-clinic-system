package com.bluesoft.vetclinicsystem.services.Impl;

import com.bluesoft.vetclinicsystem.entities.Clinic;
import com.bluesoft.vetclinicsystem.repositories.ClinicRepository;
import com.bluesoft.vetclinicsystem.services.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    ClinicRepository clinicRepository;

    @Override
    public List<Clinic> getByPhoneAndAddress(String phone, String address) {
        return clinicRepository.findByPhoneAndAddress(phone, address);
    }
}
