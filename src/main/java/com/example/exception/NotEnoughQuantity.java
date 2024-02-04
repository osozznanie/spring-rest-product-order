package com.example.exception;

import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
public class NotEnoughQuantity extends RuntimeException{
    public NotEnoughQuantity() {
        super("Not enough quantity");
    }
}
