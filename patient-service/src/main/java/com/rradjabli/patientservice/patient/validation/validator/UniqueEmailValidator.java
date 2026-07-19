package com.rradjabli.patientservice.patient.validation.validator;

import com.rradjabli.patientservice.patient.repository.PatientRepository;
import com.rradjabli.patientservice.patient.validation.annotation.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final PatientRepository patientRepository;

    public UniqueEmailValidator(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        if (email == null || email.isBlank()) {
            return true;
        }

        return !patientRepository.existsByEmail(email);
    }

}
