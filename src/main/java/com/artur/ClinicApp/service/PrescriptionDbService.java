package com.artur.ClinicApp.service;

import com.artur.ClinicApp.controller.ObjectNotFoundException;
import com.artur.ClinicApp.domain.entity.Prescription;
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
        return repository.findPrescriptionsByPatientId(patientId);
    }

    public Prescription getPrescription(Long id) throws ObjectNotFoundException {
        return repository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    public void deletePrescription(Long prescriptionId) throws ObjectNotFoundException {
        repository.findById(prescriptionId).orElseThrow(ObjectNotFoundException::new);
        repository.deleteById(prescriptionId);
    }
}
