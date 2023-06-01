package com.artur.ClinicApp.controller;


import com.artur.ClinicApp.domain.Patient;
import com.artur.ClinicApp.domain.dto.PatientDto;
import com.artur.ClinicApp.mapper.PatientMapper;
import com.artur.ClinicApp.service.PatientDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientDbService service;
    private final PatientMapper mapper;

    @GetMapping(value="/all")
    public ResponseEntity<List<PatientDto>> getPatients() {
        List<Patient> patients = service.getAllPatients();
        return ResponseEntity.ok(mapper.mapToPatientsDtoList(patients));
    }

    @GetMapping(value="{patientId}")
    public ResponseEntity<PatientDto> getPatient(@PathVariable Long patientId) throws ObjectNotFoundException {
        return ResponseEntity.ok(mapper.mapToPatientDto(service.getPatientById(patientId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addPatient(@RequestBody PatientDto patientDto) {
        service.savePatient(mapper.mapToPatient(patientDto));
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<PatientDto> updatePatient(@RequestBody PatientDto patientDto) {
        Patient patient = mapper.mapToPatient(patientDto);
        Patient savedPatient = service.savePatient(patient);
        return ResponseEntity.ok(mapper.mapToPatientDto(savedPatient));
    }

    @DeleteMapping(value="{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long patientId) throws ObjectNotFoundException {
        service.deletePatient(patientId);
        return ResponseEntity.ok().build();
    }


}
