package com.bluesoft.vetclinicsystem.repositories;

import com.bluesoft.vetclinicsystem.entities.Clinic;
import com.bluesoft.vetclinicsystem.entities.Doctor;
import com.bluesoft.vetclinicsystem.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query("SELECT d FROM Doctor d where d.clinic.id = :clinicId")
    List<Doctor> findAllByClinicId(Integer clinicId);

    boolean existsDoctorByName(String doctorName);
}
