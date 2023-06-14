package com.artur.ClinicApp.repository;

import com.artur.ClinicApp.domain.entity.Prescription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrescriptionRepository extends CrudRepository<Prescription, Long> {

    @Override
    Prescription save(Prescription prescription);

    @Override
    Optional<Prescription> findById(Long aLong);

    List<Prescription> findPrescriptionsByPatientId(Long id);
}
