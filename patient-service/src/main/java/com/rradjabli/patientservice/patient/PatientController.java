package com.rradjabli.patientservice.patient;

import com.rradjabli.patientservice.patient.dto.PatientRequestDTO;
import com.rradjabli.patientservice.patient.dto.PatientResponseDTO;
import com.rradjabli.patientservice.patient.dto.UpdatePatientRequestDTO;
import com.rradjabli.patientservice.patient.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getPatients(){
        List<PatientResponseDTO> patients = patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> savePatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO){
        PatientResponseDTO patientResponseDTO = patientService.savePatient(patientRequestDTO);
        return ResponseEntity.ok().body(patientResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id,
                                                @Valid @RequestBody UpdatePatientRequestDTO patientRequestDTO){
        return ResponseEntity.ok().body(patientService.updatePatient(id, patientRequestDTO));
    }

}
