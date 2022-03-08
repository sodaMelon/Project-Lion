package com.mission3.Community.model;

import lombok.*;

import javax.persistence.*;
import javax.servlet.http.HttpSession;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Long id;
    private String writer;
    private String password;
    @OneToOne
    @JoinColumn(name = "shop_id")
    private Area area;

    public void isShopkeeper(boolean fact) {
        Shopkeeper = fact;
    }

    private boolean Shopkeeper;

    public User(String writer, String password) {
        this.writer = writer;
        this.password = password;
    }

    public ShopPost writeShopPost(HttpSession session,
                                Shop targetShop,
                                String ShopPost){
        User currentLogin = (User) session.getAttribute("loginUser");
        if (currentLogin.equals(targetShop.getUser() )) { //shop주인 User와 로그인User 정보가같을때만 작성가능
            return new ShopPost(targetShop, ShopPost);
        }
        return null; //권한없음
    }

    public ShopReview writeShopReview(Shop targetShop, String review){
        return new ShopReview(targetShop, review);    
    }
    
}
