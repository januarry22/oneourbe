package com.api.oneourbe.config.security;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final JwtProvider jwtProvider;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = jwtProvider.getToken((HttpServletRequest) request);
        if (token != null && jwtProvider.validateJwtToken(request, token)) {
            // 토큰이 유효하면 토큰으로부터 유저 정보를 받아옵니다.
       //     Authentication authentication = jwtProvider.getToken(token);
            // SecurityContext 에 Authentication 객체를 저장합니다.
        //    SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }
}


