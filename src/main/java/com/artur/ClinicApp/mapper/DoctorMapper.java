package com.artur.ClinicApp.mapper;

import com.artur.ClinicApp.domain.Doctor;
import com.artur.ClinicApp.domain.dto.DoctorDto;
import com.artur.ClinicApp.service.ReviewDbService;
import com.artur.ClinicApp.service.VisitDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DoctorMapper {

    private final VisitDbService visitDbService;
    private final ReviewDbService reviewDbService;
    private final VisitMapper visitMapper;
    private final ReviewMapper reviewMapper;

    public Doctor mapToDoctor(DoctorDto doctorDto) {
        return new Doctor(
                doctorDto.getId(),
                doctorDto.getFirstname(),
                doctorDto.getLastname(),
                doctorDto.getSpecialization(),
                visitDbService.allDoctorVisits(doctorDto.getId()),
                reviewDbService.allDoctorReviews(doctorDto.getId())
        );
    }

    public DoctorDto mapToDoctorDto(Doctor doctor) {
        return new DoctorDto(
                doctor.getId(),
                doctor.getFirstname(),
                doctor.getLastname(),
                doctor.getSpecialization(),
                visitMapper.mapToVisitDtoList(doctor.getVisitList()),
                reviewMapper.mapToReviewDtoList(doctor.getReviewList())
        );
    }

    public List<DoctorDto> mapToDoctorDtoList(final List<Doctor> doctors) {
        return doctors.stream()
                .map(this::mapToDoctorDto)
                .toList();
    }
}
