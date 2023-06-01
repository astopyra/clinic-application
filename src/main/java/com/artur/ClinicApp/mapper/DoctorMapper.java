package com.artur.ClinicApp.mapper;

import com.artur.ClinicApp.domain.Doctor;
import com.artur.ClinicApp.domain.dto.DoctorDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorMapper {

    public Doctor mapToDoctor(DoctorDto doctorDto) {
        return new Doctor(
                doctorDto.getId(),
                doctorDto.getFirstname(),
                doctorDto.getLastname(),
                doctorDto.getSpecialization()
        );
    }

    public DoctorDto mapToDoctorDto(Doctor doctor) {
        return new DoctorDto(
                doctor.getId(),
                doctor.getFirstname(),
                doctor.getLastname(),
                doctor.getSpecialization()
        );
    }

    public List<DoctorDto> mapToDoctorDtoList(final List<Doctor> doctors) {
        return doctors.stream()
                .map(this::mapToDoctorDto)
                .toList();
    }
}
