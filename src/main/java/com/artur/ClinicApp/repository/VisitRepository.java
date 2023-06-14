package com.artur.ClinicApp.repository;

import com.artur.ClinicApp.domain.entity.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {

    List<Visit> findVisitByPatientId(Long id);

    List<Visit> findVisitByDoctorId(Long id);

    List<Visit> findAll();
}
