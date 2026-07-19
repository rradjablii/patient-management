package com.rradjabli.patientservice.patient.repository;

import com.rradjabli.patientservice.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID>
{

    boolean existsByEmail(String email);

}
