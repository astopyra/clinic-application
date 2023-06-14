package com.artur.ClinicApp.mapper;

import com.artur.ClinicApp.controller.ObjectNotFoundException;
import com.artur.ClinicApp.domain.entity.Visit;
import com.artur.ClinicApp.domain.dto.VisitDto;
import com.artur.ClinicApp.service.DoctorDbService;
import com.artur.ClinicApp.service.PatientDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitMapper {

    DoctorDbService doctorDbService;
    PatientDbService patientDbService;

    public Visit mapToVisit(final VisitDto visitDto) throws ObjectNotFoundException {
        return new Visit(
                visitDto.getId(),
                visitDto.getDateOfVisit(),
                visitDto.getNotes(),
                doctorDbService.getDoctorById(visitDto.getDoctorId()),
                patientDbService.getPatientById(visitDto.getPatientId())
        );
    }

    public VisitDto mapToVisitDto(final Visit visit) {
        return new VisitDto(
                visit.getId(),
                visit.getDateOfVisit(),
                visit.getNotes(),
                visit.getDoctor().getId(),
                visit.getPatient().getId()
        );
    }

    public List<VisitDto> mapToVisitDtoList(final List<Visit> visits) {
        return visits.stream()
                .map(this::mapToVisitDto)
                .toList();
    }
}
