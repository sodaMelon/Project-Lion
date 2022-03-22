package springboot.mission.basic.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import springboot.mission.basic.controller.dto.UserPrincipalDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth)
            throws IOException {
        String url = "/home";

        UserPrincipalDto dto = (UserPrincipalDto) auth.getPrincipal();
        Collection<GrantedAuthority> authorities = dto.getAuthorities();

        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_SHOP_OWNER")) url = "/shop/home";
        }

        res.sendRedirect(url);
    }
}
