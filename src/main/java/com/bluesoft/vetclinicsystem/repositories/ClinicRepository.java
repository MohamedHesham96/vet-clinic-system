package com.bluesoft.vetclinicsystem.repositories;

import com.bluesoft.vetclinicsystem.entities.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {

    @Query("SELECT c FROM Clinic c where" +
            " (:phone is null or c.phone like concat('%', :phone, '%'))" +
            " and (:address is null or c.address like concat('%', :address, '%'))")
    List<Clinic> findByClinicId(String phone, String address);
}
