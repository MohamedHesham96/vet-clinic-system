package com.bluesoft.vetclinicsystem.services;

import com.bluesoft.vetclinicsystem.entities.Clinic;

import java.util.List;

public interface ClinicService {
    List<Clinic> getByPhoneAndAddress(String phone, String address);
}
