package com.artur.ClinicApp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminRegisterForm {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
}
