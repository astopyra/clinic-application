package com.artur.ClinicApp.controller;


import com.artur.ClinicApp.domain.Doctor;
import com.artur.ClinicApp.domain.dto.DoctorDto;
import com.artur.ClinicApp.mapper.DoctorMapper;
import com.artur.ClinicApp.service.DoctorDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorDbService service;
    private final DoctorMapper mapper;

    @GetMapping(value="/all")
    public ResponseEntity<List<DoctorDto>> getAllDoctors(){
        List<Doctor> doctors = service.getAllDoctors();
        return ResponseEntity.ok(mapper.mapToDoctorDtoList(doctors));
    }

    @GetMapping(params="lastname")
    public ResponseEntity<List<DoctorDto>> getDoctorsByLastname(@RequestParam String lastname) throws ObjectNotFoundException {
        List<Doctor> doctors = service.getDoctorsByLastname(lastname);
        return ResponseEntity.ok(mapper.mapToDoctorDtoList(doctors));
    }

    @GetMapping(params="specialization")
    public ResponseEntity<List<DoctorDto>> getDoctorsBySpecialization(@RequestParam String specialization) throws ObjectNotFoundException{
        List<Doctor> doctors = service.getDoctorsBySpecialization(specialization);
        return ResponseEntity.ok(mapper.mapToDoctorDtoList(doctors));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addDoctor(@RequestBody DoctorDto doctorDto){
        Doctor doctor = mapper.mapToDoctor(doctorDto);
        service.saveDoctor(doctor);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<DoctorDto> updateDoctor(@RequestBody DoctorDto doctorDto) {
        Doctor doctor = mapper.mapToDoctor(doctorDto);
        Doctor savedDoctor = service.saveDoctor(doctor);
        return ResponseEntity.ok(mapper.mapToDoctorDto(savedDoctor));
    }

    @DeleteMapping(value="{doctorId}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long doctorId) throws ObjectNotFoundException{
        service.deleteDoctor(doctorId);
        return ResponseEntity.ok().build();
    }
}
