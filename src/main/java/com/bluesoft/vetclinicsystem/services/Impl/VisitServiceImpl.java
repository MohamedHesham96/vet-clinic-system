package com.bluesoft.vetclinicsystem.services.Impl;

import com.bluesoft.vetclinicsystem.dtos.VisitDTO;
import com.bluesoft.vetclinicsystem.entities.Clinic;
import com.bluesoft.vetclinicsystem.entities.Doctor;
import com.bluesoft.vetclinicsystem.entities.Pet;
import com.bluesoft.vetclinicsystem.entities.Visit;
import com.bluesoft.vetclinicsystem.repositories.VisitRepository;
import com.bluesoft.vetclinicsystem.services.VisitService;
import com.sun.media.sound.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public Visit saveVisit(VisitDTO visitDTO) throws InvalidDataException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate visitDate = LocalDate.parse(visitDTO.getDate(), formatter);
        if (visitDate.isBefore(LocalDate.now())) {
            throw new InvalidDataException("Visit date should be in future");
        }
        Visit visit = new Visit();
        visit.setPet(new Pet(visitDTO.getPetId()));
        visit.setDoctor(new Doctor(visitDTO.getDoctorId()));
        visit.setClinic(new Clinic(visitDTO.getClinicId()));
        visit.setDate(visitDate);
        return visitRepository.save(visit);
    }
}
