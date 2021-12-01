package com.bluesoft.vetclinicsystem.services;

import com.bluesoft.vetclinicsystem.dtos.OwnerDTO;
import com.bluesoft.vetclinicsystem.entities.Owner;

public interface OwnerService {

    Owner getOwner(Integer ownerId);

    Owner saveOwner(OwnerDTO ownerDTO);
}
