package com.artur.ClinicApp.mapper;

import com.artur.ClinicApp.domain.UserRole;
import com.artur.ClinicApp.domain.dto.DoctorDto;
import com.artur.ClinicApp.domain.dto.UserDto;
import com.artur.ClinicApp.domain.entity.Doctor;
import com.artur.ClinicApp.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DoctorMapperTestSuite {

    @Autowired
    DoctorMapper doctorMapper;

    @Test
    void testMapToDoctor() {
        //given
        DoctorDto doctorDto = new DoctorDto(1L, "Jan", "Kos", "jank@gmail.com", "chirurg");
        doctorDto.setUserDto(new UserDto(1L, "jkos", "jan123", Collections.singleton(UserRole.DOCTOR)));

        //when
        Doctor doctor = doctorMapper.mapToDoctor(doctorDto);

        //then
        assertEquals("Jan", doctor.getFirstname());
        assertEquals("jan123", doctor.getUser().getPassword());
    }

    @Test
    void testMapToDoctorDto() {
        //given
        Doctor doctor = new Doctor(1L, "Jan", "Kos", "jank@gmail.com", "chirurg");
        doctor.setUser(new User(1L, "jkos", "jan123", Collections.singleton(UserRole.DOCTOR)));

        //when
        DoctorDto doctorDto = doctorMapper.mapToDoctorDto(doctor);

        //then
        assertEquals("Jan", doctorDto.getFirstname());
        assertEquals(Collections.singleton(UserRole.DOCTOR), doctorDto.getUserDto().getRoles());
        assertEquals(1L, doctorDto.getUserDto().getId());
    }

    @Test
    void testMapToDoctorDtoList() {
        //given
        Doctor doctor = new Doctor(1L, "Jan", "Kos", "jank@gmail.com", "chirurg");
        doctor.setUser(new User(1L, "jkos", "jan123", Collections.singleton(UserRole.DOCTOR)));
        List<Doctor> doctors = List.of(doctor);

        //when
        List<DoctorDto> doctorsDto = doctorMapper.mapToDoctorDtoList(doctors);

        //then
        assertNotNull(doctorsDto);
        assertEquals("jkos", doctorsDto.get(0).getUserDto().getUsername());
    }
}
