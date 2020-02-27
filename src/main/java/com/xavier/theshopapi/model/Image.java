package com.xavier.theshopapi.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Image {

    private String nome;
    private String url;

    public Image(String nome, String url) {
        this.nome = nome;
        this.url = url;
    }
}
