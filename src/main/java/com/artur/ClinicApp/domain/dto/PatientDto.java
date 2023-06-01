package com.artur.ClinicApp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PatientDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private String gender;
    private List<PrescriptionDto> prescriptionList;
}
