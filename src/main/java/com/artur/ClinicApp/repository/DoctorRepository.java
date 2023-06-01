package com.artur.ClinicApp.repository;

import com.artur.ClinicApp.domain.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    @Override
    List<Doctor> findAll();

    @Override
    Optional<Doctor> findById(Long id);
    List<Doctor> findAllByLastname(String surname);

    List<Doctor> findAllBySpecialization(String specialization);
}
