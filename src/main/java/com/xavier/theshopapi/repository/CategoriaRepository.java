package com.xavier.theshopapi.repository;

import com.xavier.theshopapi.model.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {

    Optional<Categoria> findByNomeIgnoreCase(String nome);

}
