package com.xavier.theshopapi.service.exception;

import org.springframework.http.HttpStatus;

public class CategoriaExistException extends BusnessException {
    public CategoriaExistException() {
        super("categoria-2", HttpStatus.BAD_REQUEST);
    }
}
