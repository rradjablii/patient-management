package com.rradjabli.patientservice.kafka;

import com.rradjabli.patientservice.patient.entity.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Slf4j
@Service
public class KafkaProducer {

    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(Patient patient) {
        PatientEvent patientEvent = PatientEvent.newBuilder()
                .setPatientId(patient.getId().toString())
                .setName(patient.getName())
                .setEmail(patient.getEmail())
                .setEventType("PATIENT_REGISTERED")
                .build();
        try{
            kafkaTemplate.send("patient-events", patientEvent.toByteArray());
        } catch (Exception e){
            log.error("Error sending patient_registered event: {}", patientEvent);
        }
    }

}
