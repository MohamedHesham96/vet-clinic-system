package com.bluesoft.vetclinicsystem.services.Impl;

import com.bluesoft.vetclinicsystem.dtos.OwnerDTO;
import com.bluesoft.vetclinicsystem.entities.Owner;
import com.bluesoft.vetclinicsystem.repositories.OwnerRepository;
import com.bluesoft.vetclinicsystem.services.OwnerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public Owner getOwner(Integer ownerId) {
        Optional<Owner> OwnerOptional = ownerRepository.findById(ownerId);
        if (OwnerOptional.isPresent()) {
            return OwnerOptional.get();
        }
        return null;
    }

    @Override
    public Owner saveOwner(OwnerDTO ownerDTO) {
        Owner owner = new Owner();
        BeanUtils.copyProperties(ownerDTO, owner);
        return ownerRepository.save(owner);
    }

    @Override
    public boolean existWithName(String ownerName) {
        return ownerRepository.existsOwnerByName(ownerName);
    }
}
