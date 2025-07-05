package com.ilbeol.crud.domain.exception;

public class NoUserFoundException  extends RuntimeException{

    public NoUserFoundException(){
        super("No se encontraron usuarios en la base de datos");
    }

}
