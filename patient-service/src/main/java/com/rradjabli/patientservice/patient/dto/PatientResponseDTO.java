package com.rradjabli.patientservice.patient.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PatientResponseDTO {

    private String id;
    private String name;
    private String address;
    private String email;
    private String dateOfBirth;

}
