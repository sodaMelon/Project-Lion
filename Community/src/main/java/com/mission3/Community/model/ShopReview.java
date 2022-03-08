package com.mission3.Community.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class ShopReview {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="shop_id")
    private Shop shop;

    private String review;

    public ShopReview(Shop shop, String review) {
        this.shop = shop;
        this.review = review;
    }
}
