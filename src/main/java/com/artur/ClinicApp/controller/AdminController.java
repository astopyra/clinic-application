package com.artur.ClinicApp.controller;


import com.artur.ClinicApp.domain.AdminRegisterForm;
import com.artur.ClinicApp.service.AdminDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminDbService adminDbService;
//    private final AdminMapper adminMapper;

    @PostMapping(value="register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> register(@RequestBody AdminRegisterForm registerForm) {
        adminDbService.addAdmin(registerForm);
        return ResponseEntity.ok().build();
    }

}
