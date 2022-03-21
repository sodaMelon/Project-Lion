package dev.aquashdw.community.config;

import org.apache.catalina.filters.ExpiresFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Collection;

@Component
public class MyFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        this.scanQueryString(httpServletRequest,httpServletResponse);
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

    private void scanQueryString(HttpServletRequest httpServletRequest, HttpServletResponse httpResponse) {
        String result =  httpServletRequest.getQueryString();
        if (result != null) {
            logger.info("Get query String :" + result);
            String target = "likelion_login_cookie=";
            if (result.contains(target) && result.length() > target.length()) {
                String step[] = result.split("=");
                Cookie queryCookie = new Cookie(step[0], step[1]);
                queryCookie.setMaxAge(1000); //변화를 위해 여기는 1000초로 설정
                httpResponse.addCookie(queryCookie);
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
