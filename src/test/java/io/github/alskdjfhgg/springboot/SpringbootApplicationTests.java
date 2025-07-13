package io.github.alskdjfhgg.springboot;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootApplicationTests {

    @Test
    public void JWTGen() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "hzy");
        String token = JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 6))
                .sign(Algorithm.HMAC256("hzy"));

        System.out.println(token);
    }

    @Test
    public void VailJWT() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6Imh6eSJ9LCJleHAiOjE3NTIzODkxMjh9" +
                ".34AuV9T73fsZBprx3iafXiV58_GrCoasf-htbH2grBI";

        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("hzy")).build().verify(token);

        Map<String, Claim> user = decodedJWT.getClaims();

        System.out.println(user.get("user"));
    }

}
