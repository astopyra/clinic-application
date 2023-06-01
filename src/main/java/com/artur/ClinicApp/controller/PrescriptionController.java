package com.artur.ClinicApp.controller;


import com.artur.ClinicApp.domain.dto.PrescriptionDto;
import com.artur.ClinicApp.mapper.PrescriptionMapper;
import com.artur.ClinicApp.service.PrescriptionDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    private final PrescriptionMapper mapper;
    private final PrescriptionDbService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPrescription(@RequestBody PrescriptionDto prescriptionDto) throws ObjectNotFoundException {
        service.savePrescription(mapper.mapToPrescription(prescriptionDto));
        return ResponseEntity.ok().build();
    }


}
