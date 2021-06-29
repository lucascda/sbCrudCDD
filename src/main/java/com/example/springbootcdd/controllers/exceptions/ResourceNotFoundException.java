package com.example.springbootcdd.controllers.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    
    public ResourceNotFoundException(Object id){
        super("Resource not found. id: " + id);
    }

    public ResourceNotFoundException(){
        super("Resource not found.");
    }
}
