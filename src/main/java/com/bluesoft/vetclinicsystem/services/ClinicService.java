package com.bluesoft.vetclinicsystem.services;

import com.bluesoft.vetclinicsystem.dtos.ClinicDTO;
import com.bluesoft.vetclinicsystem.entities.Clinic;

import java.util.List;

public interface ClinicService {

    Clinic getClinic(Integer clinicId);

    Clinic saveClinic(ClinicDTO clinicDTO);

    List<Clinic> getByPhoneAndAddress(String phone, String address);
}
