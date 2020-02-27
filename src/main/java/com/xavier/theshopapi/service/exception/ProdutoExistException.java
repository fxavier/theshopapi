package com.xavier.theshopapi.service.exception;

import org.springframework.http.HttpStatus;

public class ProdutoExistException extends BusnessException {
    public ProdutoExistException() {
        super("produto-4", HttpStatus.BAD_REQUEST);
    }
}
