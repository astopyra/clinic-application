package com.artur.ClinicApp.repository;

import com.artur.ClinicApp.domain.Prescription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends CrudRepository<Prescription, Long> {

    @Override
    Prescription save(Prescription prescription);

    List<Prescription> findPrescriptionByPatientId(Long id);
}
