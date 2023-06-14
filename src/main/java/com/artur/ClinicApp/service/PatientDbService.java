package com.artur.ClinicApp.service;


import com.artur.ClinicApp.controller.ObjectNotFoundException;
import com.artur.ClinicApp.domain.PatientRegisterForm;
import com.artur.ClinicApp.domain.UserRole;
import com.artur.ClinicApp.domain.entity.Patient;
import com.artur.ClinicApp.domain.entity.User;
import com.artur.ClinicApp.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PatientDbService {
    private final PatientRepository repository;
    private final PasswordEncoder passwordEncoder;

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public Patient getPatientById(Long id) throws ObjectNotFoundException {
        return repository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    public Patient registerPatient(final PatientRegisterForm registerForm) {
        Patient patientToSave = new Patient(
                registerForm.getId(),
                registerForm.getFirstname(),
                registerForm.getLastname(),
                registerForm.getEmail(),
                registerForm.getAddress()
        );

        patientToSave.setUser(new User(
                registerForm.getId(),
                registerForm.getUsername(),
                passwordEncoder.encode(registerForm.getPassword()),
                EnumSet.of(UserRole.PATIENT)
        ));

        return repository.save(patientToSave);
    }

    public Patient updatePatient(final Patient patient) { return repository.save(patient); }

    public void deletePatient(Long patientId) throws ObjectNotFoundException {
        Optional<Patient> patientToDelete = repository.findById(patientId);
        if(patientToDelete.isPresent()) {
            repository.deleteById(patientId);
        } else throw new ObjectNotFoundException();
    }


}
