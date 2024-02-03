package com.example.exception;

import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
public class NotEnoughQuantity extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public NotEnoughQuantity(String resourceName, String fieldName, Long fieldValue){
        super(String.format("%s not enough %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
