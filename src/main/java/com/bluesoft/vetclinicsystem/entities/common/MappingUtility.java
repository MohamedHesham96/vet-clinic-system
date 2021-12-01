package com.bluesoft.vetclinicsystem.entities.common;

import com.bluesoft.vetclinicsystem.dtos.ClinicDTO;
import com.bluesoft.vetclinicsystem.dtos.VisitDTO;
import com.bluesoft.vetclinicsystem.entities.Clinic;
import com.bluesoft.vetclinicsystem.entities.Visit;
import com.googlecode.jmapper.JMapper;
import org.springframework.stereotype.Component;

@Component
public class MappingUtility {

    public static Visit map(VisitDTO visitDTO) {
        JMapper<Visit, VisitDTO> mapper = new JMapper<>(Visit.class, VisitDTO.class);
        return mapper.getDestination(visitDTO);
    }

    public static VisitDTO map(Visit visit) {
        JMapper<VisitDTO, Visit> mapper = new JMapper<>(VisitDTO.class, Visit.class);
        return mapper.getDestination(visit);
    }

    public static Clinic map(ClinicDTO visitDTO) {
        JMapper<Clinic, ClinicDTO> mapper = new JMapper<>(Clinic.class, ClinicDTO.class);
        return mapper.getDestination(visitDTO);
    }

    public static ClinicDTO map(Clinic visit) {
        JMapper<ClinicDTO, Clinic> mapper = new JMapper<>(ClinicDTO.class, Clinic.class);
        return mapper.getDestination(visit);
    }
}
