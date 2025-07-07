package com.ilbeol.crud.infraestructure.handler;

import com.ilbeol.crud.domain.exception.NoUserFoundException;
import com.ilbeol.crud.domain.exception.UserAlreadyExistsException;
import com.ilbeol.crud.domain.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFound(UserNotFoundException ex){
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Usuario no encontrado");
        response.put("message", ex.getMessage());
        response.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoUserFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNoUserFound(NoUserFoundException ex){
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Usuarios no encontrados");
        response.put("message", ex.getMessage());
        response.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleUserAlreadyExists(UserAlreadyExistsException ex){
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Usuario ya existente");
        response.put("message", ex.getMessage());
        response.put("status", HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Error interno del servidor");
        response.put("message", "Ocurrió un error inesperado. Por favor, valida tu solicitud e inténtalo nuevamente.");
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
