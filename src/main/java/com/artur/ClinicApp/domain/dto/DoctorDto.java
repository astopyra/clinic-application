package com.artur.ClinicApp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DoctorDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String specialization;

}
