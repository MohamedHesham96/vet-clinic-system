package com.bluesoft.vetclinicsystem.repositories;

import com.bluesoft.vetclinicsystem.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
