package com.artur.ClinicApp.domain.dto;

import com.artur.ClinicApp.domain.Doctor;
import com.artur.ClinicApp.domain.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class VisitDto {

    private Long id;
    private LocalDateTime dateOfVisit;
    private String notes;
    private Long doctorId;
    private Long patientId;

}
