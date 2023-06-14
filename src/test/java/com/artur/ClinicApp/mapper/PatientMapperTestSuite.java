package com.artur.ClinicApp.mapper;

import com.artur.ClinicApp.domain.UserRole;
import com.artur.ClinicApp.domain.dto.PatientDto;
import com.artur.ClinicApp.domain.dto.UserDto;
import com.artur.ClinicApp.domain.entity.Patient;
import com.artur.ClinicApp.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PatientMapperTestSuite {

    @Autowired
    PatientMapper patientMapper;

    @Test
    void testMapToDoctor() {
        //given
        PatientDto patientDto = new PatientDto(1L, "Jan", "Kos", "jank@gmail.com", "rzeszow 007");
        patientDto.setUserDto(new UserDto(1L, "jkos", "jan123", Collections.singleton(UserRole.PATIENT)));

        //when
        Patient patient = patientMapper.mapToPatient(patientDto);

        //then
        assertEquals("Jan", patient.getFirstname());
        assertEquals("jan123", patient.getUser().getPassword());
    }

    @Test
    void testMapToDoctorDto() {
        //given
        Patient patient = new Patient(1L, "Jan", "Kos", "jank@gmail.com", "rzeszow008");
        patient.setUser(new User(1L, "jkos", "jan123", Collections.singleton(UserRole.PATIENT)));

        //when
        PatientDto patientDto = patientMapper.mapToPatientDto(patient);

        //then
        assertEquals("Jan", patientDto.getFirstname());
        assertEquals(Collections.singleton(UserRole.PATIENT), patientDto.getUserDto().getRoles());
        assertEquals(1L, patientDto.getUserDto().getId());
    }

    @Test
    void testMapToDoctorDtoList() {
        //given
        Patient patient = new Patient(1L, "Jan", "Kos", "jank@gmail.com", "rzeszow008");
        patient.setUser(new User(1L, "jkos", "jan123", Collections.singleton(UserRole.PATIENT)));
        List<Patient> doctors = List.of(patient);

        //when
        List<PatientDto> patientsDto = patientMapper.mapToPatientsDtoList(doctors);

        //then
        assertNotNull(patientsDto);
        assertEquals("jkos", patientsDto.get(0).getUserDto().getUsername());
    }
}
