package com.rradjabli.patientservice.patient.validation.validator;

import com.rradjabli.patientservice.patient.validation.annotation.Adult;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class AdultValidator implements ConstraintValidator<Adult, String> {
    @Override
    public boolean isValid(String date, ConstraintValidatorContext context) {
        if(date == null || date.isEmpty()) {
            return false;
        }

        LocalDate toDate = LocalDate.parse(date);

        return !toDate.isAfter(LocalDate.now().minusYears(18));
    }
}
