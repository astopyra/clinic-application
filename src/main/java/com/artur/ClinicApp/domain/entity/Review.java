package com.artur.ClinicApp.domain.entity;

import com.artur.ClinicApp.domain.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "reviews")
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String opinion;

    private LocalDateTime date;

    private String author;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;
}
