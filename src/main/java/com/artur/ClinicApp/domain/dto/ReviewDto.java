package com.artur.ClinicApp.domain.dto;

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
