package com.ilbeol.crud.domain.exception;

public class NoUserFoundException  extends RuntimeException{

    public NoUserFoundException(){
        super("No hay usuarios registrados en el sistema");
    }

}
