package com.fibe.Fibe.controlers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Component
public class ControllerAsAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> exceptionHAndler(MethodArgumentNotValidException ex){
        Map<String,String> map= new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String field=((FieldError)error).getField();
            String error_name= error.getDefaultMessage();
            map.put(field,error_name);
        });
        return map;
    }
}
