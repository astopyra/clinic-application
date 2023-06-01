package com.artur.ClinicApp.service;


import com.artur.ClinicApp.controller.ObjectNotFoundException;
import com.artur.ClinicApp.domain.Doctor;
import com.artur.ClinicApp.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DoctorDbService {
    private final DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctor(final Long id) throws ObjectNotFoundException {
        return doctorRepository.findById(id);
    }

    public Doctor saveDoctor(final Doctor doctor) {
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
        Optional<Doctor> doctorToDelete = doctorRepository.findById(doctorId);
        if(doctorToDelete.isPresent()) {
            doctorRepository.deleteById(doctorId);
        } else throw new ObjectNotFoundException();
    }
}
