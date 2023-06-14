package com.artur.ClinicApp.service;


import com.artur.ClinicApp.controller.ObjectNotFoundException;
import com.artur.ClinicApp.domain.DoctorRegisterForm;
import com.artur.ClinicApp.domain.UserRole;
import com.artur.ClinicApp.domain.entity.Doctor;
import com.artur.ClinicApp.domain.entity.User;
import com.artur.ClinicApp.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DoctorDbService {
    private final DoctorRepository doctorRepository;
    private final PasswordEncoder passwordEncoder;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) throws ObjectNotFoundException {
        return doctorRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    public Doctor registerDoctor(final DoctorRegisterForm registerForm) {
        Doctor doctorToRegister = new Doctor(
                registerForm.getId(),
                registerForm.getFirstname(),
                registerForm.getLastname(),
                registerForm.getEmail(),
                registerForm.getSpecialization()
        );

        doctorToRegister.setUser(new User(
                registerForm.getId(),
                registerForm.getUsername(),
                passwordEncoder.encode(registerForm.getPassword()),
                EnumSet.of(UserRole.DOCTOR)
        ));
        return doctorRepository.save(doctorToRegister);
    }

    public Doctor updateDoctor(final Doctor doctor) {
         return doctorRepository.save(doctor);
    }


    public List<Doctor> getDoctorsByLastname(String surname) throws ObjectNotFoundException {
        List<Doctor> doctorsWithGivenLastname = doctorRepository.findAllByLastname(surname);
        if(doctorsWithGivenLastname.isEmpty())
            throw new ObjectNotFoundException();
        return doctorsWithGivenLastname;
    }

    public List<Doctor> getDoctorsBySpecialization(String specialization) throws ObjectNotFoundException{
        List<Doctor> doctorsWithGivenSpecialization = doctorRepository.findAllBySpecialization(specialization);
        if(doctorsWithGivenSpecialization.isEmpty())
            throw new ObjectNotFoundException();
        return doctorsWithGivenSpecialization;
    }


    public void deleteDoctor(Long doctorId) throws ObjectNotFoundException {
        doctorRepository.findById(doctorId).orElseThrow(ObjectNotFoundException::new);
        doctorRepository.deleteById(doctorId);
    }
}
