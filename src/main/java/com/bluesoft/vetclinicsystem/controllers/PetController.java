package com.bluesoft.vetclinicsystem.controllers;

import com.bluesoft.vetclinicsystem.dtos.PetDTO;
import com.bluesoft.vetclinicsystem.entities.Pet;
import com.bluesoft.vetclinicsystem.entities.common.DefaultResponse;
import com.bluesoft.vetclinicsystem.entities.common.Gender;
import com.bluesoft.vetclinicsystem.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/pets")
public class PetController extends BaseController {

    @Autowired
    private PetService petService;

    @GetMapping("/{petId}")
    public ResponseEntity<?> getPet(@PathVariable Integer petId) {
        try {
            Pet pet = petService.getPet(petId);
            return ResponseEntity.ok(pet);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DefaultResponse("Error Occurred, please contract admin"));
        }
    }

    @PostMapping
    public ResponseEntity<?> createPet(@Valid @RequestBody PetDTO petDTO) {
        try {
            boolean isPetNameAlreadyExists = petService.existWithName(petDTO.getName());
            if (isPetNameAlreadyExists) {
                return ResponseEntity.badRequest().body(new DefaultResponse("Pet name is already exists"));
            }
            String perGender = petDTO.getGender();
            if (perGender != null && !perGender.equals(Gender.MALE.toString()) && !perGender.equals(Gender.FEMALE.toString())) {
                return ResponseEntity.badRequest().body(new DefaultResponse("Gender must be Male or Female"));
            }
            Pet savedPet = petService.savePet(petDTO);
            return ResponseEntity.ok(savedPet);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DefaultResponse("Error Occurred, please contract admin"));
        }
    }
}