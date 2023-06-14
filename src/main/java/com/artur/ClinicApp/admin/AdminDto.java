package com.artur.ClinicApp.admin;


import com.artur.ClinicApp.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AdminDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private UserDto userDto;
}
