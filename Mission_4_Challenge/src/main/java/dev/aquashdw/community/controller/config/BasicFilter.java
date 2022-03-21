package dev.aquashdw.community.controller.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.CookieStore;
import java.net.http.HttpRequest;
import java.util.Collection;

@Component
public class BasicFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(BasicFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies !=null ){
            for (Cookie c:cookies){
                String name = c.getName();
                String value = c.getValue();
                if (name.equals("likelion_login_cookie")){
                    logger.info("likelion_login_cookie의 값 : " + value);
                    SecurityContextHolder.getContext().setAuthentication(new Authentication() {
                        @Override
                        public String getName() {
                            return null;
                        }

                        @Override
                        public Collection<? extends GrantedAuthority> getAuthorities() {
                            return null;
                        }

                        @Override
                        public Object getCredentials() {
                            return null;
                        }

                        @Override
                        public Object getDetails() {
                            return null;
                        }

                        @Override
                        public Object getPrincipal() {
                            return null;
                        }

                        @Override
                        public boolean isAuthenticated() {
                            logger.info("isAuthenticated 현재 정상 로그인유저입니다");
                            return true;
                        }

                        @Override
                        public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

                        }
                    });
                }
            }
        }
        else logger.info(" likelion_login_cookie가 현재 필터에 걸린 게 없음");
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
