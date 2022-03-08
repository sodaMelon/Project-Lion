package com.mission3.Community.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Shop {
    @Id
    @GeneratedValue
    private Long id;
    private String category;

    @OneToOne(mappedBy = "Shop")
    private User user;

    public Area findShopArea(Shop shop){
        return shop.getUser().getArea();
    }
}
