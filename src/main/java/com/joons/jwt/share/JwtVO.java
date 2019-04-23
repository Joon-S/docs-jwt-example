package com.joons.jwt.share;

public class JwtVO {
    private String jws;

    public JwtVO(String jws) {
        this.jws = jws;
    }

    public String getJws() {
        return jws;
    }
}
