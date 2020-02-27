package com.xavier.theshopapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Collection;

@Document(collection = "item_pedido")
@Getter
@Setter
@NoArgsConstructor
public class ItemPedido {

    @Id
    private String id;

    @DBRef
    private Produto produto;

    private Integer quantidade;

    private BigDecimal preco;

    public ItemPedido(Produto produto, Integer quantidade, BigDecimal preco) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public BigDecimal getValorTotal() {
        return preco.multiply(new BigDecimal(quantidade));
    }
}
