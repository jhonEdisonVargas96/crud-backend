package com.ilbeol.crud.domain.exception;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String email) {
        super("Ya existe un usuario con el correo " + email);
    }

}
