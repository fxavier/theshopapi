package com.xavier.theshopapi.repository;

import com.xavier.theshopapi.model.ItemPedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemPedidoRepository extends MongoRepository<ItemPedido, String> {
}
