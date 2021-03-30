package com.example.cripto.model;

public class AuthResponse {
    private String jwt;
    private String pk;

    public AuthResponse(String jwt, String pk){
        this.jwt = jwt;
        this.pk = pk;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }
}
