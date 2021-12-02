package com.bluesoft.vetclinicsystem.services;

import com.bluesoft.vetclinicsystem.dtos.PetDTO;
import com.bluesoft.vetclinicsystem.entities.Pet;

import java.util.List;

public interface PetService {

    Pet getPet(Integer petId);

    List<Pet> getAllByOwnerId(Integer ownerId);

    Pet savePet(PetDTO petDTO);

    boolean existWithName(String petName);
}
