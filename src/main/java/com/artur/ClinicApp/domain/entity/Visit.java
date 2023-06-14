package com.artur.ClinicApp.domain.entity;

import com.artur.ClinicApp.domain.entity.Doctor;
import com.artur.ClinicApp.domain.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name="visits")
public class Visit {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime dateOfVisit;

    private String notes;

    @ManyToOne
    @JoinColumn(name="doctorId")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="patientId")
    private Patient patient;
}
