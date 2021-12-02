package com.bluesoft.vetclinicsystem.controllers;

import com.bluesoft.vetclinicsystem.dtos.DoctorDTO;
import com.bluesoft.vetclinicsystem.dtos.UpdateDoctorDTO;
import com.bluesoft.vetclinicsystem.entities.Clinic;
import com.bluesoft.vetclinicsystem.entities.Doctor;
import com.bluesoft.vetclinicsystem.entities.common.DefaultResponse;
import com.bluesoft.vetclinicsystem.services.ClinicService;
import com.bluesoft.vetclinicsystem.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController extends BaseController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ClinicService clinicService;

    @GetMapping("/{doctorId}")
    public ResponseEntity<?> getDoctor(@Valid @PathVariable Integer doctorId) {
        try {
            Doctor doctor = doctorService.getDoctor(doctorId);
            if (doctor == null) {
                return ResponseEntity.badRequest().body(new DefaultResponse("Doctor can not be found"));
            }
            return ResponseEntity.ok(doctor);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DefaultResponse("Error Occurred, please contract admin"));
        }
    }

    @PostMapping
    public ResponseEntity<?> createDoctor(@Valid @RequestBody DoctorDTO doctorDTO) {
        try {
            boolean isDoctorNameAlreadyExists = doctorService.existWithName(doctorDTO.getName());
            if (isDoctorNameAlreadyExists) {
                return ResponseEntity.badRequest().body(new DefaultResponse("Doctor name is already exists"));
            }
            Clinic clinic = clinicService.getClinic(doctorDTO.getClinicId());
            if (clinic == null) {
                return ResponseEntity.badRequest().body(new DefaultResponse("Clinic can not be found"));
            }
            Doctor savedDoctor = doctorService.saveDoctor(doctorDTO);
            return ResponseEntity.ok(savedDoctor);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(new DefaultResponse("Doctor photo is not uploaded, please contract admin"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DefaultResponse("Error Occurred, please contract admin"));
        }
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<?> assignDoctorToClinic(@PathVariable Integer doctorId,
                                                  @RequestBody UpdateDoctorDTO updateDoctorDTO) {
        try {
            Doctor doctor = doctorService.getDoctor(doctorId);
            if (doctor == null) {
                return ResponseEntity.badRequest().body(new DefaultResponse("Doctor can not be found"));
            }
            Doctor savedDoctor;
            if (updateDoctorDTO.isAssigned()) {
                Clinic clinic = clinicService.getClinic(updateDoctorDTO.getClinicId());
                if (clinic == null) {
                    return ResponseEntity.badRequest().body(new DefaultResponse("Clinic can not be found"));
                }
                savedDoctor = doctorService.assignDoctorToClinic(doctor, clinic);
                return ResponseEntity.ok(savedDoctor);
            } else {
                savedDoctor = doctorService.deassignToClinic(doctor);
            }
            return ResponseEntity.ok(savedDoctor);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DefaultResponse("Error Occurred, please contract admin"));
        }
    }

    @PutMapping("/{doctorId}/photo")
    public ResponseEntity<?> updateDoctorPhoto(@PathVariable Integer doctorId, @RequestParam MultipartFile doctorPhoto) {
        try {
            Doctor doctor = doctorService.getDoctor(doctorId);
            if (doctor == null) {
                return ResponseEntity.badRequest().body(new DefaultResponse("Doctor can not be found"));
            }
            Doctor savedDoctor = doctorService.updateDoctorPhoto(doctor, doctorPhoto);
            return ResponseEntity.ok(savedDoctor);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DefaultResponse("Error Occurred, please contract admin"));
        }
    }
}
