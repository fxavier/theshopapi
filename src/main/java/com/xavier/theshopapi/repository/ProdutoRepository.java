package com.xavier.theshopapi.repository;

import com.xavier.theshopapi.model.Produto;
import com.xavier.theshopapi.repository.produto.ProdutoRepositoryQuery;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface ProdutoRepository extends MongoRepository<Produto, String> {

   Optional<Produto> findByNomeIgnoreCase(String nome);

    List<Produto> findAllBy(TextCriteria textCriteria);

    List<Produto> findByFeatured(Boolean featured);

    @Query("{'reviews.rating' : { $gte : 5}}")
    List<Produto> findAllByGreatReviews();

    @Query("{'categoria.id' : ?0 }")
    List<Produto> findByCategoriaId(String id);

   /* @Query("{ $or: [ {'categoria.id': ?0, {'nome': { $regex: ?1, $options: 'i'}, { preco: { $lte: ?2 }}}}]}")
    List<Produto> fullSearch(String categoriaId, String nome, BigDecimal preco);
*/
    @Query("{ 'categoria.id': ?0}")
    List<Produto> fullsearch(String id);


}
