package com.xavier.theshopapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class Pagamento {

    private BigDecimal valor;
    private OpcaoPagamento opcaoPagamento;

    public Pagamento(BigDecimal valor, OpcaoPagamento opcaoPagamento) {
        this.valor = valor;
        this.opcaoPagamento = opcaoPagamento;
    }
}
