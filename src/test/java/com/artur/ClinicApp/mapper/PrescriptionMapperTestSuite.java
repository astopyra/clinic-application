package com.artur.ClinicApp.mapper;

import com.artur.ClinicApp.controller.ObjectNotFoundException;
import com.artur.ClinicApp.domain.dto.PrescriptionDto;
import com.artur.ClinicApp.domain.entity.Patient;
import com.artur.ClinicApp.domain.entity.Prescription;
import com.artur.ClinicApp.service.PatientDbService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PrescriptionMapperTestSuite {

    @Autowired
    PrescriptionMapper prescriptionMapper;

    @MockBean
    private PatientDbService patientDbService;

    @Test
    void testMapToPrescription() throws ObjectNotFoundException {
        //given
        PrescriptionDto prescriptionDto = new PrescriptionDto(1L, "prescription content", 1L);
        Patient patient = new Patient(1L, "Jan", "nowak", "jann@o2.pl", "rzeszow");

        Mockito.when(patientDbService.getPatientById(1L)).thenReturn(patient);

        //when
        Prescription prescrition = prescriptionMapper.mapToPrescription(prescriptionDto);

        //then
        assertEquals("prescription content", prescrition.getContent());
        assertEquals(1L, prescrition.getPatient().getId());
    }

    @Test
    void testMapToPrescriptionDto() {
        //given
        Prescription prescription = new Prescription(1L, "prescription content",
                new Patient(1L, "Jan", "nowak", "jann@o2.pl", "rzeszow"));

        //when
        PrescriptionDto prescriptionDto = prescriptionMapper.mapToPrescriptionDto(prescription);

        //then
        assertEquals(1L, prescriptionDto.getId());
        assertEquals(1L, prescriptionDto.getPatientId());
    }

    @Test
    void testMapToPrescriptionDtoList() {
        //given
        Prescription prescription = new Prescription(1L, "prescription content",
                new Patient(1L, "Jan", "nowak", "jann@o2.pl", "rzeszow"));
        List<Prescription> prescriptions = List.of(prescription);

        //when
        List<PrescriptionDto> prescriptionsDto = prescriptionMapper.mapToPrescriptionDtoList(prescriptions);

        //then
        assertEquals(1, prescriptionsDto.size());
        assertEquals("prescription content", prescriptionsDto.get(0).getContent());
    }
}
