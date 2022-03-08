package com.mission3.Community.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class ShopPost {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="shop_id")
    private Shop shop;

    private String post;

    public ShopPost(Shop shop, String post) {
        this.shop = shop;
        this.post = post;
    }
}
