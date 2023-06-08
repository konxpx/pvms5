package com.example.salecar.utils;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class TokenUtils {
    private static long time = 1000 * 60 * 60 * 24 * 7;
    private static String signature = "admin";

    public static String createToken(String username) {
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .claim("username", username)
                .claim("role", "admin")
                .setSubject("admin-login")
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        return jwtToken;
    }

    public static boolean checkToken(String token) {
        if (token == null) {
            return false;
        }
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
