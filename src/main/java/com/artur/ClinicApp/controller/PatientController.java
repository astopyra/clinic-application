package com.artur.ClinicApp.controller;


import com.artur.ClinicApp.domain.PatientRegisterForm;
import com.artur.ClinicApp.domain.entity.Patient;
import com.artur.ClinicApp.domain.dto.PatientDto;
import com.artur.ClinicApp.mapper.PatientMapper;
import com.artur.ClinicApp.service.PatientDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    private final PatientDbService service;
    private final PatientMapper mapper;

    @GetMapping(value="/all-patients")
    public ResponseEntity<List<PatientDto>> getPatients() {
        List<Patient> patients = service.getAllPatients();
        return ResponseEntity.ok(mapper.mapToPatientsDtoList(patients));
    }

    @GetMapping(value="/patient/{patientId}")
    public ResponseEntity<PatientDto> getPatient(@PathVariable Long patientId) throws ObjectNotFoundException {
        return ResponseEntity.ok(mapper.mapToPatientDto(service.getPatientById(patientId)));
    }

    @PostMapping(value="/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registerPatient(@RequestBody PatientRegisterForm registerForm) {
        service.registerPatient(registerForm);
        return ResponseEntity.ok().build();
    }

    @Secured({"ROLE_ADMIN", "ROLE_PATIENT"})
    @PutMapping(value="/patient/update")
    public ResponseEntity<PatientDto> updatePatient(@RequestBody PatientDto patientDto) {
        Patient patient = mapper.mapToPatient(patientDto);
        Patient savedPatient = service.updatePatient(patient);
        return ResponseEntity.ok(mapper.mapToPatientDto(savedPatient));
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping(value="/patient/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long patientId) throws ObjectNotFoundException {
        service.deletePatient(patientId);
        return ResponseEntity.ok().build();
    }


}
