package com.xavier.theshopapi.repository;

import com.xavier.theshopapi.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
