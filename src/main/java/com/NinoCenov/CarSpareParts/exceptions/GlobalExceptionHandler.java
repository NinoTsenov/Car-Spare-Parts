package com.NinoCenov.CarSpareParts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> handlerCategoryNotFound (CategoryNotFoundException message) {
        return new ResponseEntity<>(message.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MakeNotFoundException.class)
    public ResponseEntity<String> handlerMakeNotFound (MakeNotFoundException message) {
        return new ResponseEntity<>(message.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<String> handlerModelNotFound (ModelNotFoundException message) {
        return new ResponseEntity<>(message.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PartNotFoundException.class)
    public ResponseEntity<String> handlerPartNotFound (PartNotFoundException message) {
        return new ResponseEntity<>(message.getMessage(), HttpStatus.NOT_FOUND);
    }
}
