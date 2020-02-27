package com.xavier.theshopapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Document(collection = "usuario")
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    @Id
    private String id;
    private String nome;
    private String username;
    private String password;
    private Collection<String> telefones = new ArrayList<>();
    private Collection<Endereco> enderecos = new ArrayList<>();

    private Cidade cidade;

    public Usuario(String id, String nome, String username,
                   String password, Collection<String> telefones,
                   Collection<Endereco> enderecos, Cidade cidade) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.telefones = telefones;
        this.enderecos = enderecos;
        this.cidade = cidade;
    }
}
