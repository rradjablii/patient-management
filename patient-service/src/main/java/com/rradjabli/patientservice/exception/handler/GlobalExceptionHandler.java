package com.rradjabli.patientservice.exception.handler;

import com.rradjabli.patientservice.exception.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                    .forEach((error) -> {errors.put(error.getField(), error.getDefaultMessage());});

        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                400,
                "Validation Failed",
                "Request Validation Failed",
                request.getRequestURI(),
                errors
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

    }

//    @ExceptionHandler(EmailAlreadyExistsException.class)
//    public ResponseEntity<ErrorResponse> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex, HttpServletRequest request) {
//        Map<String, String> errors = new HashMap<>();
//
//
//        ErrorResponse error = new ErrorResponse(
//                LocalDateTime.now(),
//                400,
//                "Email Exists",
//                "user with this email already exists",
//                request.getRequestURI(),
//                errors
//        );
//        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
//    }

}
