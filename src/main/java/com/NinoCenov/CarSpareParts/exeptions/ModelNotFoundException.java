package com.NinoCenov.CarSpareParts.exeptions;

public class ModelNotFoundException extends RuntimeException{
    public ModelNotFoundException(String message){
        super(message);
    }
}
