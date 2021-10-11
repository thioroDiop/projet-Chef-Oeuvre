package com.example.wedding.controllers.dto;

public class JWTDto {
    private final String idToken;

    public JWTDto(String idToken) {
        this.idToken = idToken;
    }

    public String getIdToken() {
        return idToken;
    }
}
