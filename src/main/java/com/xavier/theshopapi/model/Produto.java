package com.xavier.theshopapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "produto")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Produto {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @TextIndexed
    @NotBlank(message = "produto-1")
    private String nome;

    private String descricao;

    @NotNull(message = "produto-2")
    private Integer stock;

    @NotNull(message = "produto-3")
    private BigDecimal preco;

    private Boolean taxavel;

    private Boolean featured;

    @Field(name = "free_shipping")
    private Boolean freeShipping;

    private Integer vendido;

    @DBRef
    private Categoria categoria;

    private List<ProductReview> reviews = new ArrayList<>();

    private List<Image> images = new ArrayList<>();

    public Produto(String nome, String descricao, Integer stock, BigDecimal preco, Boolean taxavel,
                   Boolean featured, Boolean freeShipping, Categoria categoria, List<ProductReview> reviews) {
        this.nome = nome;
        this.descricao = descricao;
        this.stock = stock;
        this.preco = preco;
        this.taxavel = taxavel;
        this.featured = featured;
        this.freeShipping = freeShipping;
        this.categoria = categoria;
        this.reviews = reviews;
    }

    public boolean isNew() {
        return this.id == null;
    }
}
