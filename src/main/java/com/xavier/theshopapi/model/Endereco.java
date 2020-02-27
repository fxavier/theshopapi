package com.xavier.theshopapi.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Endereco {

    private String bairro;
    private String ruaOuAv;
    private String numero;

    public Endereco(String bairro, String ruaOuAv, String numero) {
        this.bairro = bairro;
        this.ruaOuAv = ruaOuAv;
        this.numero = numero;
    }
}
