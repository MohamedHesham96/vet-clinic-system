package com.bluesoft.vetclinicsystem.repositories;

import com.bluesoft.vetclinicsystem.entities.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
}
