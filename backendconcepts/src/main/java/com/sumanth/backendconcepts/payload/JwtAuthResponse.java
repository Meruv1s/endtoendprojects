package com.sumanth.backendconcepts.payload;

public class JwtAuthResponse {

    private final String token;
    private final String tokenType = "Bearer";

    public JwtAuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getTokenType() {
        return tokenType;
    }
}