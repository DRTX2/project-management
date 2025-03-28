package com.projectManagement.heavySpring.adapters.rest.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // interpreta excepciones y da una respuesta personalizada.
// Es decir un manejador global de excepciones para cualquier controlador usando 1 archivo/lugar
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(IllegalArgumentException ex){
        return ResponseEntity.badRequest().body(new ErrorResponse(ex.getMessage()));// Devuelve una respuesta con HTTP 400 (Bad Request) y un mensaje de error.
    }

    public record ErrorResponse(String message){}
}
