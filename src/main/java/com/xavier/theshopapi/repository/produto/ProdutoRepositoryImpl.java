package com.xavier.theshopapi.repository.produto;

import com.xavier.theshopapi.model.Produto;
import com.xavier.theshopapi.repository.filter.ProdutoFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class ProdutoRepositoryImpl implements ProdutoRepositoryQuery {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Page<Produto> filtrar(ProdutoFilter produtoFilter, Pageable pageable) {

        return null;
    }
}
