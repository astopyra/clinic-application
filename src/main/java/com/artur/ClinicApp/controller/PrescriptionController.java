package com.artur.ClinicApp.controller;


import com.artur.ClinicApp.domain.entity.Prescription;
import com.artur.ClinicApp.domain.dto.PrescriptionDto;
import com.artur.ClinicApp.mapper.PrescriptionMapper;
import com.artur.ClinicApp.service.PrescriptionDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    private final PrescriptionMapper mapper;
    private final PrescriptionDbService service;

    @Secured({"ROLE_DOCTOR"})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPrescription(@RequestBody PrescriptionDto prescriptionDto) throws ObjectNotFoundException {
        service.savePrescription(mapper.mapToPrescription(prescriptionDto));
        return ResponseEntity.ok().build();
    }

    @Secured({"ROLE_DOCTOR"})
    @DeleteMapping(value = "{prescriptionId}")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long prescriptionId) throws ObjectNotFoundException {
        service.deletePrescription(prescriptionId);
        return ResponseEntity.ok().build();
    }

    @Secured({"ROLE_DOCTOR", "ROLE_PATIENT"})
    @GetMapping(value = "/all-prescriptions/{patientId}")
    public ResponseEntity<List<PrescriptionDto>> getAllPatientPrescriptions(@PathVariable Long patientId) {
        List<Prescription> prescriptions = service.allPatientPrescriptions(patientId);
        return ResponseEntity.ok(mapper.mapToPrescriptionDtoList(prescriptions));
    }

    @Secured({"ROLE_DOCTOR", "ROLE_PATIENT"})
    @GetMapping(value = {"prescriptionId"})
    public ResponseEntity<Prescription> getPrescription(@PathVariable Long prescriptionId) throws ObjectNotFoundException {
        return ResponseEntity.ok(service.getPrescription(prescriptionId));
    }

}
