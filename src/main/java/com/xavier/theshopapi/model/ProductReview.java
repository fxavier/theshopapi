package com.xavier.theshopapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.TextIndexed;

@Getter
@Setter
@NoArgsConstructor
public class ProductReview {

    @TextIndexed
    private  String username;
    private int rating;

    public ProductReview(String username, int rating) {
        this.username = username;
        this.rating = rating;
    }
}
