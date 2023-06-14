package com.artur.ClinicApp.domain.dto;

import com.artur.ClinicApp.domain.entity.Review;
import com.artur.ClinicApp.domain.entity.Visit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DoctorDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String specialization;
    private List<Visit> visitList;
    private List<Review> reviewList;
    private UserDto userDto;

    public DoctorDto(Long id, String firstname, String lastname, String email, String specialization) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.specialization = specialization;
    }
}
