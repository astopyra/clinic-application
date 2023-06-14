package com.artur.ClinicApp.domain.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name="patients")
public class Patient {

    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;

    @OneToMany(
            targetEntity = Prescription.class,
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Prescription> prescriptionList;

    @OneToMany(
            targetEntity = Visit.class,
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Visit> visitList;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_details")
    private User user;

    public Patient(Long id, String firstname, String lastname, String email, String address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
    }
}


