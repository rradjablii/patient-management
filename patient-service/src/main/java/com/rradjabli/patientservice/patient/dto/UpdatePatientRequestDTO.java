package com.rradjabli.patientservice.patient.dto;

import com.rradjabli.patientservice.patient.validation.annotation.Adult;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdatePatientRequestDTO {
    @NotBlank
    @Size(max = 32, message = "number of characters in name cannot exceed 32")
    private String name;

    @NotBlank
    @Email(message="invalid email")
    private String email;

    @NotBlank
    @Size(max = 100, message = "number of characters in address cannot exceed 100")
    private String address;

    @Adult
    @NotBlank(message = "date of birth is a required field")
    private String dateOfBirth;
}
