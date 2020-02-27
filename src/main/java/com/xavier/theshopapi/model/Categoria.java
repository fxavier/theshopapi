package com.xavier.theshopapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "categoria")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Categoria {

    @Id
    @EqualsAndHashCode.Include
    private String id;
    @NotBlank(message = "categoria-1")
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Boolean isNew() {
        return this.id == null;
    }

    public Boolean exist() {
        return this.id != null;
    }
}
