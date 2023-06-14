package com.artur.ClinicApp.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name="doctors")
public class Doctor {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    private String email;

    @Column(name="specialization")
    private String specialization;

    @OneToMany(
            targetEntity = Visit.class,
            mappedBy = "doctor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Visit> visitList;

    @OneToMany(
            targetEntity = Review.class,
            mappedBy = "doctor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Review> reviewList;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_details")
    private User user;

    public Doctor(Long id, String firstname, String lastname, String email, String specialization) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.specialization = specialization;
    }
}
