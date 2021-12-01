package com.bluesoft.vetclinicsystem.controllers;

import com.bluesoft.vetclinicsystem.dtos.ClinicDTO;
import com.bluesoft.vetclinicsystem.entities.Clinic;
import com.bluesoft.vetclinicsystem.entities.Doctor;
import com.bluesoft.vetclinicsystem.entities.common.DefaultResponse;
import com.bluesoft.vetclinicsystem.services.ClinicService;
import com.bluesoft.vetclinicsystem.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinics")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/{clinicId}")
    public ResponseEntity<?> getClinic(@PathVariable Integer clinicId) {
        try {
            Clinic clinic = clinicService.getClinic(clinicId);
            return ResponseEntity.ok(clinic);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DefaultResponse("Error Occurred, please contract admin"));
        }
    }

    @PostMapping
    public ResponseEntity<?> createClinic(@RequestBody ClinicDTO clinicDTO) {
        try {
            Clinic savedClinic = clinicService.saveClinic(clinicDTO);
            return ResponseEntity.ok(savedClinic);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DefaultResponse("Error Occurred, please contract admin"));
        }
    }

    @GetMapping("/{clinicId}/doctors")
    public ResponseEntity<?> getClinicDoctors(@PathVariable Integer clinicId) {
        try {
            List<Doctor> doctors = doctorService.getAllByClinicId(clinicId);
            return ResponseEntity.ok(doctors);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DefaultResponse("Error Occurred, please contract admin"));
        }
    }

    @GetMapping
    public ResponseEntity<?> getClinicsByPhoneAndAddress(@RequestParam(required = false) String phone,
                                                         @RequestParam(required = false) String address) {
        try {
            List<Clinic> clinics = clinicService.getByPhoneAndAddress(phone, address);
            return ResponseEntity.ok(clinics);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DefaultResponse("Error Occurred, please contract admin"));
        }
    }
}
