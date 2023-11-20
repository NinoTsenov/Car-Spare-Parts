package com.NinoCenov.CarSpareParts.exceptions;

public class PartNotFoundException extends RuntimeException {
    public PartNotFoundException(String message){
        super(message);
    }
}
