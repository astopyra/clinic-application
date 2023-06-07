package com.artur.ClinicApp.domain.dto;

import com.artur.ClinicApp.domain.Review;
import com.artur.ClinicApp.domain.Visit;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DoctorDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String specialization;
    private List<VisitDto> visitList;
    private List<ReviewDto> reviewList;
}
