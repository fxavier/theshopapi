package com.xavier.theshopapi.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "pedido")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pedido {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @Field(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @DBRef
    private Usuario usuario;


    private EstadoPedido estadoPedido;

    @DBRef
    private List<ItemPedido> items = new ArrayList<>();

    @DBRef
    private Pagamento pagamento;

    public Pedido(LocalDateTime dataCriacao, Usuario usuario, EstadoPedido estadoPedido,
                  List<ItemPedido> items, Pagamento pagamento) {
        this.dataCriacao = dataCriacao;
        this.usuario = usuario;
        this.estadoPedido = estadoPedido;
        this.items = items;
        this.pagamento = pagamento;
    }

    public BigDecimal getValorTotal() {
        return items.stream()
                .map(ItemPedido::getValorTotal)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
