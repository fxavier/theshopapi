package com.xavier.theshopapi.repository.filter;

import com.xavier.theshopapi.model.Categoria;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoFilter {

    private Categoria categoria;
    private String nome;
    private BigDecimal preco;
}
