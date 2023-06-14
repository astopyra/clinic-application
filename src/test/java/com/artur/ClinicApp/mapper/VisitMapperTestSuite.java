package com.artur.ClinicApp.mapper;

import com.artur.ClinicApp.domain.dto.VisitDto;
import com.artur.ClinicApp.domain.entity.Doctor;
import com.artur.ClinicApp.domain.entity.Patient;
import com.artur.ClinicApp.domain.entity.Visit;
import com.artur.ClinicApp.service.DoctorDbService;
import com.artur.ClinicApp.service.PatientDbService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class VisitMapperTestSuite {

    @Autowired
    VisitMapper visitMapper;

    @MockBean
    private DoctorDbService doctorDbService;

    @MockBean
    private PatientDbService patientDbService;
//todo
//    @Test
//    void testMapToVisit() throws ObjectNotFoundException {
//        //given
//        VisitDto visitDto = new VisitDto(1L, LocalDateTime.now(), "first visit", 1L, 1L);
//        Doctor doctor = new Doctor(1L, "Jan", "Pyś", "janp@o2.pl", "chirurg");
//        Patient patient = new Patient(1L, "Jan", "nowak", "jann@o2.pl", "rzeszow");
//
//        Mockito.when(doctorDbService.getDoctor(1L)).thenReturn(doctor);
//        Mockito.when(patientDbService.getPatientById(1L)).thenReturn(patient);
//
//        //when
//        Visit visit = visitMapper.mapToVisit(visitDto);
//
//        //then
//        assertEquals("first visit", visit.getNotes());
//    }
    @Test
    void testMapToVisitDto() {
        //given
        Visit visit = new Visit(1L, LocalDateTime.now(), "first visit",
                new Doctor(1L, "Jan", "Pyś", "janp@o2.pl", "chirurg"),
                new Patient(1L, "Jan", "nowak", "jann@o2.pl", "rzeszow"));

        //when
        VisitDto visitDto = visitMapper.mapToVisitDto(visit);

        //then
        assertEquals(1L, visitDto.getDoctorId());
        assertEquals(1L, visitDto.getPatientId());
        assertEquals("first visit", visitDto.getNotes());
    }

    @Test
    void testMaptoVisitDtoList() {
        //given
        Visit visit = new Visit(1L, LocalDateTime.now(), "first visit",
                new Doctor(1L, "Jan", "Pyś", "janp@o2.pl", "chirurg"),
                new Patient(1L, "Jan", "nowak", "jann@o2.pl", "rzeszow"));
        List<Visit> visits = List.of(visit);

        //when
        List<VisitDto> visitsDto = visitMapper.mapToVisitDtoList(visits);

        //when
        assertEquals(1, visitsDto.size());
        assertEquals("first visit", visitsDto.get(0).getNotes());
    }
}
