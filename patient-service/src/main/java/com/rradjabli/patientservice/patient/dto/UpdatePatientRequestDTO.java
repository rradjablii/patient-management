package com.rradjabli.patientservice.patient.dto;

import lombok.Getter;

@Getter
public class UpdatePatientRequestDTO {
    private String name;
    private String email;
    private String address;
    private String dateOfBirth;
}
