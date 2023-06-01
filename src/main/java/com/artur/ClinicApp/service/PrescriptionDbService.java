package com.artur.ClinicApp.service;

import com.artur.ClinicApp.domain.Prescription;
import com.artur.ClinicApp.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class PrescriptionDbService {

    private final PrescriptionRepository repository;

    public Prescription savePrescription(final Prescription prescription) {
          return repository.save(prescription);
    }

    public List<Prescription> allPatientPrescriptions(final Long patientId) {
        return repository.findPrescriptionByPatientId(patientId);
    }
}
