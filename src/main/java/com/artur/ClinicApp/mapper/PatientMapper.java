package com.artur.ClinicApp.mapper;

import com.artur.ClinicApp.domain.Patient;
import com.artur.ClinicApp.domain.dto.PatientDto;
import com.artur.ClinicApp.service.PrescriptionDbService;
import com.artur.ClinicApp.service.VisitDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientMapper {

    private final PrescriptionMapper prescriptionMapper;
    private final PrescriptionDbService prescriptionDbService;
    private final VisitMapper visitMapper;
    private final VisitDbService visitDbService;


    public Patient mapToPatient(PatientDto patientDto) {
        return new Patient(
                patientDto.getId(),
                patientDto.getFirstname(),
                patientDto.getLastname(),
                patientDto.getAddress(),
                patientDto.getGender(),
                prescriptionDbService.allPatientPrescriptions(patientDto.getId()),
                visitDbService.allPatientVisits(patientDto.getId())
        );
    }

    public PatientDto mapToPatientDto(Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getFirstname(),
                patient.getLastname(),
                patient.getAddress(),
                patient.getGender(),
                prescriptionMapper.mapToPrescriptionDtoList(patient.getPrescriptionList()),
                visitMapper.mapToVisitDtoList(patient.getVisitList())
        );
    }

    public List<PatientDto> mapToPatientsDtoList(List<Patient> patients) {
        return patients.stream()
                .map(this::mapToPatientDto)
                .toList();
    }

}
