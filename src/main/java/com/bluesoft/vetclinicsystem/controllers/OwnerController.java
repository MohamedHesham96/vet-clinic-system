package com.bluesoft.vetclinicsystem.controllers;

import com.bluesoft.vetclinicsystem.dtos.OwnerDTO;
import com.bluesoft.vetclinicsystem.entities.Owner;
import com.bluesoft.vetclinicsystem.entities.Pet;
import com.bluesoft.vetclinicsystem.entities.common.DefaultResponse;
import com.bluesoft.vetclinicsystem.entities.common.Gender;
import com.bluesoft.vetclinicsystem.services.OwnerService;
import com.bluesoft.vetclinicsystem.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController extends BaseController {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private PetService petService;

    @GetMapping("/{ownerId}")
    public ResponseEntity<?> getOwner(@PathVariable Integer ownerId) {
        try {
            Owner owner = ownerService.getOwner(ownerId);
            return ResponseEntity.ok(owner);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DefaultResponse("Error Occurred, please contract admin"));
        }
    }

    @PostMapping
    public ResponseEntity<?> createOwner(@Valid @RequestBody OwnerDTO ownerDTO) {
        try {
            boolean isOwnerNameAlreadyExists = ownerService.existWithName(ownerDTO.getName());
            if (isOwnerNameAlreadyExists) {
                return ResponseEntity.badRequest().body(new DefaultResponse("Owner name is already exists"));
            }
            String ownerGender = ownerDTO.getGender();
            if (ownerGender != null && !ownerGender.equals(Gender.MALE.toString()) && !ownerGender.equals(Gender.FEMALE.toString())) {
                return ResponseEntity.badRequest().body(new DefaultResponse("Gender must be Male or Female"));
            }
            Owner savedOwner = ownerService.saveOwner(ownerDTO);
            return ResponseEntity.ok(savedOwner);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DefaultResponse("Error Occurred, please contract admin"));
        }
    }

    @GetMapping("/{ownerId}/pets")
    public ResponseEntity<?> getOwnerPets(@PathVariable Integer ownerId) {
        try {
            List<Pet> ownerPets = petService.getAllByOwnerId(ownerId);
            return ResponseEntity.ok(ownerPets);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DefaultResponse("Error Occurred, please contract admin"));
        }
    }
}