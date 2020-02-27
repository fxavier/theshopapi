package com.xavier.theshopapi.repository;

import com.xavier.theshopapi.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<Pedido, String> {
}
