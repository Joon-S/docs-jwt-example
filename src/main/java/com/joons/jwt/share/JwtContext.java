package com.joons.jwt.share;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

public class JwtContext {
    private static JwtContext jwtContext;
    private Key signingKey;

    private JwtContext() {}

    public static JwtContext getInstance() {
        //Ignore sync
        if(jwtContext == null)
            jwtContext = new JwtContext();
        return jwtContext;
    }

    public String makeJwt(String id) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        byte[] apiKeySecretBytes = JwtElement.SECRET_KEY.toString().getBytes();
        signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        Date exp = new Date(nowMillis + 86400000);
        String builder = Jwts.builder()
                .setIssuedAt(now)
                .setHeaderParam("typ", "JWT")
                .setSubject("subject")
                .setIssuer("issuer")
                .claim("id", id)
                .setExpiration(exp)
                .signWith(signingKey, signatureAlgorithm)
                .compact();
        return builder;
    }

    public Key getSigningKey() {
        return signingKey;
    }
}
