package com.xavier.theshopapi.repository.produto;

import com.xavier.theshopapi.model.Produto;
import com.xavier.theshopapi.repository.filter.ProdutoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoRepositoryQuery {

    Page<Produto> filtrar(ProdutoFilter produtoFilter, Pageable pageable);
}
