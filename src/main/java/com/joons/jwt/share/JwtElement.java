package com.joons.jwt.share;

public enum JwtElement {
    SECRET_KEY("022db29cd0e211e5bb4c60f81dca7676");

    private final String value;
    JwtElement(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
