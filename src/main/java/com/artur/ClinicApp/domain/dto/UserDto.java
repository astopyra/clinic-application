package com.artur.ClinicApp.domain.dto;

import com.artur.ClinicApp.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private Set<UserRole> roles;
}
