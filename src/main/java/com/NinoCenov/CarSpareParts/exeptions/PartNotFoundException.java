package com.NinoCenov.CarSpareParts.exeptions;

public class PartNotFoundException extends RuntimeException {
    public PartNotFoundException(String message){
        super(message);
    }
}
