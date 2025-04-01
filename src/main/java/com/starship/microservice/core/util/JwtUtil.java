package com.starship.microservice.core.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;

import static com.starship.microservice.core.config.ResponseConfig.INVALID_JWT_SIGNATURE;
import static com.starship.microservice.core.config.ResponseConfig.INVALID_JWT_TOKEN;

@Slf4j
@Configuration
@Component
public class JwtUtil {

    @Value("${spring.application.name}")
    private String serviceName;

    @Value("${jwt.secretKey}")
    private String secretKey;

    @Value("${jwt.tokenExpiration}")
    private long tokenExpiration;

    @Value("${jwt.refreshExpiration}")
    private long refreshExpiration;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String generateToken(String userID, String username, List<String> roles) {
        return Jwts.builder()
                .setSubject(username)
                .claim("userID", userID)
                .claim("roles", roles)
                .setIssuer(serviceName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateRefreshToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer(serviceName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + refreshExpiration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims validateToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
            throw new RuntimeException(INVALID_JWT_SIGNATURE);
        } catch (Exception e) {
            log.error("Invalid JWT: {}", e.getMessage());
            throw new RuntimeException(INVALID_JWT_TOKEN);
        }
    }

    public String getUsernameFromToken(String token) {
        Claims claims = validateToken(token);
        return claims.getSubject();
    }

    public String getUserIdFromToken(String token) {
        Claims claims = validateToken(token);
        return (String) claims.get("userID");
    }

    @SuppressWarnings("unchecked")
    public List<String> getRolesFromToken(String token) {
        Claims claims = validateToken(token);
        return (List<String>) claims.get("roles");
    }
}
