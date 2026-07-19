package com.rradjabli.patientservice.patient.service;

import com.rradjabli.patientservice.exception.EmailAlreadyExistsException;
import com.rradjabli.patientservice.exception.PatientNotFoundException;
import com.rradjabli.patientservice.patient.dto.PatientRequestDTO;
import com.rradjabli.patientservice.patient.dto.PatientResponseDTO;
import com.rradjabli.patientservice.patient.dto.UpdatePatientRequestDTO;
import com.rradjabli.patientservice.patient.entity.Patient;
import com.rradjabli.patientservice.patient.mapper.PatientMapper;
import com.rradjabli.patientservice.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public PatientResponseDTO updatePatient(UUID id, UpdatePatientRequestDTO patientRequestDTO){
        Patient patient = patientRepository.findById(id).orElseThrow(()-> new PatientNotFoundException(id));

        if(!patient.getEmail().equals(patientRequestDTO.getEmail()) && patientRepository.existsByEmail(patientRequestDTO.getEmail())){throw new EmailAlreadyExistsException(patientRequestDTO.getEmail());}
        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        Patient updatedPatient = patientRepository.save(patient);
        return PatientMapper.toPatientResponseDTO(updatedPatient);
    }

}
