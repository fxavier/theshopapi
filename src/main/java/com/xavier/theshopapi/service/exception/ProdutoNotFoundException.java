package com.xavier.theshopapi.service.exception;

import org.springframework.http.HttpStatus;

public class ProdutoNotFoundException extends BusnessException {
    public ProdutoNotFoundException() {
        super("produto-5", HttpStatus.BAD_REQUEST);
    }
}
