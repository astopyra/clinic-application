package com.artur.ClinicApp.mapper;

import com.artur.ClinicApp.controller.ObjectNotFoundException;
import com.artur.ClinicApp.domain.Prescription;
import com.artur.ClinicApp.domain.dto.PrescriptionDto;
import com.artur.ClinicApp.service.PatientDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrescriptionMapper {

    private final PatientDbService patientDbService;

    public Prescription mapToPrescription(final PrescriptionDto prescriptionDto) throws ObjectNotFoundException {
        return new Prescription(
                prescriptionDto.getId(),
                prescriptionDto.getContent(),
                patientDbService.getPatientById(prescriptionDto.getPatientId())
        );
    }

    public PrescriptionDto mapToPrescriptionDto(final Prescription prescription) {
        return new PrescriptionDto(
                prescription.getPrescriptionId(),
                prescription.getContent(),
                prescription.getPatient().getId()
        );
    }



    public List<PrescriptionDto> mapToPrescriptionDtoList(final List<Prescription> prescriptionList) {
        return prescriptionList.stream()
                .map(this::mapToPrescriptionDto)
                .toList();
    }
}
