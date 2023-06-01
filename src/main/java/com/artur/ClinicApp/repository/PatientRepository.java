package com.artur.ClinicApp.repository;

import com.artur.ClinicApp.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    @Override
    Optional<Patient> findById(Long id);

    @Override
    List<Patient> findAll();


}
