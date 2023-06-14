package com.artur.ClinicApp.mapper;

import com.artur.ClinicApp.domain.dto.DoctorDto;
import com.artur.ClinicApp.domain.entity.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DoctorMapper {

    private final UserMapper userMapper;

    public Doctor mapToDoctor(final DoctorDto doctorDto) {
        return Doctor.builder()
                .id(doctorDto.getId())
                .firstname(doctorDto.getFirstname())
                .lastname(doctorDto.getLastname())
                .email(doctorDto.getEmail())
                .specialization(doctorDto.getSpecialization())
                .user(userMapper.mapToUser(doctorDto.getUserDto()))
                .build();
    }

    public DoctorDto mapToDoctorDto(final Doctor doctor) {
        return DoctorDto.builder()
                .id(doctor.getId())
                .firstname(doctor.getFirstname())
                .lastname(doctor.getLastname())
                .email(doctor.getEmail())
                .specialization(doctor.getSpecialization())
                .userDto(userMapper.mapToUSerDto(doctor.getUser()))
                .build();
    }

    public List<DoctorDto> mapToDoctorDtoList(final List<Doctor> doctors) {
        return doctors.stream()
                .map(this::mapToDoctorDto)
                .toList();
    }
}
