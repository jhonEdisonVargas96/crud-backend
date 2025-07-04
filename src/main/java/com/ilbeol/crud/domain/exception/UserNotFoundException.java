package com.ilbeol.crud.domain.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id){
        super("Usuario con ID " + id + " no encontrado");
    }

}
