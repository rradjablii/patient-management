package com.rradjabli.patientservice.patient.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rradjabli.patientservice.patient.validation.annotation.Adult;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequestDTO
{
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

    @JsonFormat(pattern = "yyyy-mm-dd")
    @NotNull(message = "date of registration is a required field")
    private String dateOfRegistration;
}
