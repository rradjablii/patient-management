package com.rradjabli.analyticsservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "patient-events", groupId = "analytics-service")
    public void consume(byte[] message) {
        try{
            PatientEvent patientEvent = PatientEvent.parseFrom(message);
            // ...any business logic...
            log.info("Received patient_registered even: [patient_id={}, patient_name={}, patient_email={}]",
                    patientEvent.getPatientId(),
                    patientEvent.getName(),
                    patientEvent.getEmail());
        }catch (InvalidProtocolBufferException e){
            log.error("Error parsing patient_registered event: {}", e.getMessage());
        }

    }

}
