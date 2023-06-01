package com.artur.ClinicApp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PrescriptionDto {
    private Long id;
    private String content;
    private Long patientId;
}
