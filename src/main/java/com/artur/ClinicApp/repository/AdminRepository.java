package com.artur.ClinicApp.repository;

import com.artur.ClinicApp.admin.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {

}
