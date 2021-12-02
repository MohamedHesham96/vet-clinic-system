package com.bluesoft.vetclinicsystem.services.Impl;

import com.bluesoft.vetclinicsystem.dtos.ClinicDTO;
import com.bluesoft.vetclinicsystem.entities.Clinic;
import com.bluesoft.vetclinicsystem.repositories.ClinicRepository;
import com.bluesoft.vetclinicsystem.services.ClinicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    ClinicRepository clinicRepository;

    @Override
    public Clinic getClinic(Integer clinicId) {
        Optional<Clinic> clinicOptional = clinicRepository.findById(clinicId);
        if (clinicOptional.isPresent()) {
            return clinicOptional.get();
        }
        return null;
    }

    @Override
    public Clinic saveClinic(ClinicDTO clinicDTO) {
        Clinic clinic = new Clinic();
        BeanUtils.copyProperties(clinicDTO, clinic);
        return clinicRepository.save(clinic);
    }

    @Override
    public List<Clinic> getByPhoneAndAddress(String phone, String address) {
        return clinicRepository.findByPhoneAndAddress(phone, address);
    }

    @Override
    public Boolean existWithName(String clinicName) {
        return clinicRepository.existsClinicByName(clinicName);
    }

}
