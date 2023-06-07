package com.artur.ClinicApp.domain.dto;

import com.artur.ClinicApp.domain.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ReviewDto {

    private Long id;
    private String opinion;
    private LocalDateTime date;
    private String author;
    private Long doctorId;
}
