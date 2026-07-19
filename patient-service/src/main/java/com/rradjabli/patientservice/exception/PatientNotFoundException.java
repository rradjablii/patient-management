package com.rradjabli.patientservice.exception;

import java.util.UUID;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(UUID id) {
        super("Patient with id " + id + " does not exist.");
    }
}
