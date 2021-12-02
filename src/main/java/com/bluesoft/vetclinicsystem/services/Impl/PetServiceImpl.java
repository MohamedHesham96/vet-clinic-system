package com.bluesoft.vetclinicsystem.services.Impl;

import com.bluesoft.vetclinicsystem.dtos.PetDTO;
import com.bluesoft.vetclinicsystem.entities.Owner;
import com.bluesoft.vetclinicsystem.entities.Pet;
import com.bluesoft.vetclinicsystem.repositories.PetRepository;
import com.bluesoft.vetclinicsystem.services.PetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    PetRepository petRepository;

    @Override
    public Pet getPet(Integer petId) {
        Optional<Pet> petOptional = petRepository.findById(petId);
        if (petOptional.isPresent()) {
            return petOptional.get();
        }
        return null;
    }

    @Override
    public Pet savePet(PetDTO petDTO) {
        Pet pet = new Pet();
        BeanUtils.copyProperties(petDTO, pet);
        pet.setOwner(new Owner(petDTO.getOwnerId()));
        Pet savedPet = petRepository.save(pet);
        return savedPet;
    }

    @Override
    public boolean existWithName(String petName) {
        return petRepository.existsPetByName(petName);
    }

    @Override
    public List<Pet> getAllByOwnerId(Integer ownerId) {
        return petRepository.findAllByOwnerId(ownerId);
    }
}
