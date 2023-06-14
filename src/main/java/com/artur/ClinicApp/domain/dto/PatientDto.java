package com.artur.ClinicApp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PatientDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private UserDto userDto;

    public PatientDto(Long id, String firstname, String lastname, String email, String address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
    }
}
