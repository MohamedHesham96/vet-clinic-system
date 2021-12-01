package com.bluesoft.vetclinicsystem.services;

import com.bluesoft.vetclinicsystem.dtos.VisitDTO;
import com.bluesoft.vetclinicsystem.entities.Visit;

public interface VisitService {
    Visit getVisit(Integer visitId);

    Visit saveVisit(VisitDTO visitDTO);
}
