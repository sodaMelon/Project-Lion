package springboot.mission.basic.controller.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import springboot.mission.basic.entity.UserEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipalDto extends User {

    public UserPrincipalDto(UserEntity userEntity) {
        super(userEntity.getUsername(), userEntity.getPassword(), authorities(userEntity));
    }

    private static Collection<? extends GrantedAuthority> authorities (UserEntity userEntity) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (userEntity.getShopOwner()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_SHOP_OWNER"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authorities;
    }
}
