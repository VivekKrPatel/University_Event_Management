package com.example.UniversityEventManagement.exception;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class CustomException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> exceptioMethod(MethodArgumentNotValidException customException) {
        Map<String,String> map = new HashMap<>();

        List<ObjectError> allErrors = customException.getBindingResult().getAllErrors();
        for(ObjectError error:allErrors){
            String code = error.getCode();
            String defaultMessage = error.getDefaultMessage();
            map.put(code,defaultMessage);
        }
        return map;
    }
}
