package com.xavier.theshopapi.service;

import com.xavier.theshopapi.model.Produto;
import com.xavier.theshopapi.repository.ProdutoRepository;
import com.xavier.theshopapi.repository.filter.ProdutoFilter;
import com.xavier.theshopapi.service.exception.ProdutoExistException;
import com.xavier.theshopapi.service.exception.ProdutoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public List<Produto> search(String text) {
        TextCriteria textCriteria = TextCriteria.forDefaultLanguage().matching(text);
        return produtoRepository.findAllBy(textCriteria);
    }

    /* public List<Produto> fullSearch(String categoriaId, String nome, BigDecimal preco) {
        return produtoRepository.fullSearch(categoriaId, nome, preco);
    }*/
    public List<Produto> findAllByGreatReviews() {
        return produtoRepository.findAllByGreatReviews();
    }

    public List<Produto> findByCategoriaId(String id) {
        return produtoRepository.findByCategoriaId(id);
    }

    public List<Produto> findFeaturedProdutos(Boolean featured) {
        return produtoRepository.findByFeatured(featured);
    }

    public Produto save(final Produto produto) {
        verifyIfProdutoExist(produto);
        return produtoRepository.save(produto);
    }

    public void delete(String id) {
        verifyIfProdutoNotExist(id);
        produtoRepository.deleteById(id);
    }

    private void verifyIfProdutoNotExist(String id) throws ProdutoNotFoundException {
        Optional<Produto> foundProduto = produtoRepository.findById(id);
        if (foundProduto.isEmpty()) {
            throw new ProdutoNotFoundException();
        }
    }

    private void verifyIfProdutoExist(Produto produto) throws ProdutoExistException {
        Optional<Produto> foundProduto = produtoRepository.findByNomeIgnoreCase(produto.getNome());
        if (foundProduto.isPresent() && produto.isNew()) {
            throw new ProdutoExistException();
        }
    }
}
