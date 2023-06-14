package com.artur.ClinicApp.service;

import com.artur.ClinicApp.admin.AdminEntity;
import com.artur.ClinicApp.domain.AdminRegisterForm;
import com.artur.ClinicApp.domain.UserRole;
import com.artur.ClinicApp.domain.entity.User;
import com.artur.ClinicApp.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.EnumSet;


@RequiredArgsConstructor
@Service
public class AdminDbService {

    private final AdminRepository repo;
    private final PasswordEncoder passwordEncoder;

    public void addAdmin(final AdminRegisterForm registerForm) {
        AdminEntity adminToSave = new AdminEntity(
                registerForm.getId(),
                registerForm.getFirstname(),
                registerForm.getLastname(),
                registerForm.getEmail()
        );
        adminToSave.setUser(new User(
                registerForm.getId(),
                registerForm.getUsername(),
                passwordEncoder.encode(registerForm.getPassword()),
                EnumSet.of(UserRole.ADMIN, UserRole.PATIENT)
        ));
        repo.save(adminToSave);
    }
}
