package io.github.alskdjfhgg.springboot.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private static final String Key = "jwt_key";

    public static String JwtGen(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))
                .sign(Algorithm.HMAC256(Key));
    }

    public static Map<String, Object> VailJWT(String token) {
        return JWT.require(Algorithm.HMAC256(Key))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
