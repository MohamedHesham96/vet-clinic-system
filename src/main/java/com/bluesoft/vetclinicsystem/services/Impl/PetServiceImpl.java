package com.bluesoft.vetclinicsystem.services.Impl;

import com.bluesoft.vetclinicsystem.entities.Pet;
import com.bluesoft.vetclinicsystem.repositories.PetRepository;
import com.bluesoft.vetclinicsystem.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    PetRepository petRepository;

    @Override
    public List<Pet> getAllByOwnerId(Integer ownerId) {
        return petRepository.findAllByOwnerId(ownerId);
    }
}
