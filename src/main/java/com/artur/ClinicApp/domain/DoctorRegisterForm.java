package com.artur.ClinicApp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DoctorRegisterForm {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String specialization;
    private String username;
    private String password;
}
