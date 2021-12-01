package com.bluesoft.vetclinicsystem.services;

import com.bluesoft.vetclinicsystem.entities.Pet;

import java.util.List;

public interface PetService {
    List<Pet> getAllByOwnerId(Integer ownerId);
}
