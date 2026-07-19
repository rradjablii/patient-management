package com.rradjabli.patientservice.patient.service;

import com.rradjabli.patientservice.patient.dto.PatientRequestDTO;
import com.rradjabli.patientservice.patient.dto.PatientResponseDTO;
import com.rradjabli.patientservice.patient.entity.Patient;
import com.rradjabli.patientservice.patient.mapper.PatientMapper;
import com.rradjabli.patientservice.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients (){
        List<Patient> patients = patientRepository.findAll();
        return patients
                .stream()
                    .map(PatientMapper::toPatientResponseDTO)
                        .toList();
    }

    public PatientResponseDTO savePatient(PatientRequestDTO patientRequestDTO){
        Patient patient = PatientMapper.toPatient(patientRequestDTO);
        patientRepository.save(patient);
        return PatientMapper.toPatientResponseDTO(patient);
    }

}
