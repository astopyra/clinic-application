package com.artur.ClinicApp.service;

import com.artur.ClinicApp.domain.Visit;
import com.artur.ClinicApp.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VisitDbService {

    private final VisitRepository repository;

    public Visit saveVisit(final Visit visit) {
        return repository.save(visit);
    }

    public List<Visit> allPatientVisits(final Long patientId) {
        return repository.findVisitByPatientId(patientId);
    }

    public List<Visit> allDoctorVisits(final Long patientId) {
        return repository.findVisitByDoctorId(patientId);
    }
}
