package com.api.oneourbe.config.security;

import com.api.oneourbe.api.service.member.CustomUserDetailService;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;


@Component
@RequiredArgsConstructor
public class JwtProvider {
    private final long accessExpireTime = 1 * 60 * 1000L; // 1분
    private final long refreshExpireTime = 1 * 60 * 2000L;  // 60일

    private final CustomUserDetailService customUserDetailService;


    public String createAccessToken(String member_seq) {
        long expiration = System.currentTimeMillis() + accessExpireTime;

        String jwt =
                Jwts.builder()
                        .claim("member_seq", member_seq)
                        .setSubject(member_seq)
                        .setExpiration(new Date(expiration))
                        .signWith(SignatureAlgorithm.HS256, generateKey())
                        .compact();
        return jwt;
    }

    private String secretKey = "secret";

    private byte[] generateKey() {
        byte[] key = null;
        try {
            key = secretKey.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return key;
    }


    private String AUTHORIZATION = "AuthToken";

    /**
     * 토큰 내부의 object 가져오기
     */
    public String getTokenInfo(HttpServletRequest request, String key) {
        String token = request.getHeader(AUTHORIZATION);
        return (String) Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(token).getBody().get(key);
    }

    /**
     * 토큰 내부 member_Seq
     */
    public String getTokenInfo(String token, String key) {
        return (String) Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(token).getBody().get(key);
    }

    /**
     * 토큰 내부 header
     */
    public String getToken(HttpServletRequest request) {
        return request.getHeader(AUTHORIZATION);
    }

    public Authentication getAuthentication(HttpServletRequest request,String token) {
        // TODO: jwt 유저 권한 세팅 하기
        UserDetails userDetails = customUserDetailService.loadUserByUsername(this.getTokenInfo(request,"member_seq"));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public boolean validateJwtToken(ServletRequest request, String authToken) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            request.setAttribute("exception", "MalformedJwtException");
        } catch (ExpiredJwtException e) {
            request.setAttribute("exception", "ExpiredJwtException");
        } catch (UnsupportedJwtException e) {
            request.setAttribute("exception", "UnsupportedJwtException");
        } catch (IllegalArgumentException e) {
            request.setAttribute("exception", "IllegalArgumentException");
        }
        return false;
    }


}
