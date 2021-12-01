package com.bluesoft.vetclinicsystem.controllers;

import com.bluesoft.vetclinicsystem.dtos.VisitDTO;
import com.bluesoft.vetclinicsystem.entities.Visit;
import com.bluesoft.vetclinicsystem.entities.common.DefaultResponse;
import com.bluesoft.vetclinicsystem.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visits")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @GetMapping("/{visitId}")
    public ResponseEntity<?> getVisit(@PathVariable Integer visitId) {
        try {
            Visit visit = visitService.getVisit(visitId);
            return ResponseEntity.ok(visit);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DefaultResponse("Error Occurred, please contract admin"));
        }
    }

    @PostMapping
    public ResponseEntity<?> createVisit(@RequestBody VisitDTO visitDTO) {
        try {
            Visit savedVisit = visitService.saveVisit(visitDTO);
            return ResponseEntity.ok(savedVisit);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DefaultResponse("Error Occurred, please contract admin"));
        }
    }
}