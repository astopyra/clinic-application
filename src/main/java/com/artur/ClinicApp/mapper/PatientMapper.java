package com.artur.ClinicApp.mapper;

import com.artur.ClinicApp.domain.dto.PatientDto;
import com.artur.ClinicApp.domain.entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientMapper {

    private final UserMapper userMapper;

    public Patient mapToPatient(final PatientDto patientDto) {
       return Patient.builder()
               .id(patientDto.getId())
               .firstname(patientDto.getFirstname())
               .lastname(patientDto.getLastname())
               .email(patientDto.getEmail())
               .address(patientDto.getAddress())
               .user(userMapper.mapToUser(patientDto.getUserDto()))
               .build();
    }

    public PatientDto mapToPatientDto(final Patient patient) {
        return PatientDto.builder()
                .id(patient.getId())
                .firstname(patient.getFirstname())
                .lastname(patient.getLastname())
                .email(patient.getEmail())
                .address(patient.getAddress())
                .userDto(userMapper.mapToUSerDto(patient.getUser()))
                .build();
    }

    public List<PatientDto> mapToPatientsDtoList(final List<Patient> patients) {
        return patients.stream()
                .map(this::mapToPatientDto)
                .toList();
    }

}
