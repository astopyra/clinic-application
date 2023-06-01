package com.artur.ClinicApp.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name="prescriptions")
public class Prescription {

    @Id
    @GeneratedValue
    private Long prescriptionId;

    @Column(name="content")
    private String content;

    @ManyToOne
    @JoinColumn(name="patientId")
    private Patient patient;


}
