package com.example.practiceproject.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class MapValidationErrorService {

    public Optional<ResponseEntity<?>> MapValidationService(BindingResult result){
        if(result.hasErrors())
        {
            Map<String, String> errorMap = new HashMap<String, String>();
            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            ResponseEntity<Map<String, String>> responseEntity = new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
            return Optional.of(responseEntity);
        }
        return Optional.empty();
    }
}
