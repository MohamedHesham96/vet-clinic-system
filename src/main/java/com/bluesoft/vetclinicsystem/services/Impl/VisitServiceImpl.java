package com.bluesoft.vetclinicsystem.services.Impl;

import com.bluesoft.vetclinicsystem.dtos.VisitDTO;
import com.bluesoft.vetclinicsystem.entities.Visit;
import com.bluesoft.vetclinicsystem.repositories.VisitRepository;
import com.bluesoft.vetclinicsystem.services.VisitService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Override
    public Visit getVisit(Integer visitId) {
        Optional<Visit> visitOptional = visitRepository.findById(visitId);
        if (visitOptional.isPresent()) {
            return visitOptional.get();
        }
        return null;
    }

    @Override
    public Visit saveVisit(VisitDTO visitDTO) {
        Visit visit = new Visit();
        BeanUtils.copyProperties(visitDTO, visit);
        return visitRepository.save(visit);
    }
}
