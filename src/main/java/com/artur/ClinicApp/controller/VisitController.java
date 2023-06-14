package com.artur.ClinicApp.controller;

import com.artur.ClinicApp.domain.entity.Visit;
import com.artur.ClinicApp.domain.dto.VisitDto;
import com.artur.ClinicApp.mapper.VisitMapper;
import com.artur.ClinicApp.service.VisitDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/visit")
public class VisitController {

    private final VisitDbService dbService;
    private final VisitMapper mapper;

    @Secured({"ROLE_DOCTOR"})
    @GetMapping("/patient/{id}")
    public ResponseEntity<List<VisitDto>> getPatientVisits(@PathVariable Long id) {
        List<Visit> visits =dbService.allPatientVisits(id);
        return ResponseEntity.ok(mapper.mapToVisitDtoList(visits));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addVisit(@RequestBody VisitDto visitDto) throws ObjectNotFoundException {
        Visit visit = mapper.mapToVisit(visitDto);
        dbService.saveVisit(visit);
        return ResponseEntity.ok().build();
    }


    @PutMapping
    public ResponseEntity<VisitDto> changeVisit(@RequestBody VisitDto visitDto) throws ObjectNotFoundException {
        Visit visit = mapper.mapToVisit(visitDto);
        Visit savedVisit = dbService.saveVisit(visit);
        return ResponseEntity.ok(mapper.mapToVisitDto(savedVisit));
    }


    @DeleteMapping(value = "{visitId}")
    public ResponseEntity<Void> deleteVisit(@PathVariable  Long visitId) {
        return ResponseEntity.ok().build();
    }
}
