package com.artur.ClinicApp.service;


import com.artur.ClinicApp.controller.ObjectNotFoundException;
import com.artur.ClinicApp.domain.Patient;
import com.artur.ClinicApp.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PatientDbService {
    private final PatientRepository repository;

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public Patient savePatient(final Patient patient) {
        return repository.save(patient);
    }

    public void deletePatient(Long patientId) throws ObjectNotFoundException {
        Optional<Patient> patientToDelete = repository.findById(patientId);
        if(patientToDelete.isPresent()) {
            repository.deleteById(patientId);
        } else throw new ObjectNotFoundException();
    }

    public Patient getPatientById(Long id) throws ObjectNotFoundException {
        return repository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }



}
