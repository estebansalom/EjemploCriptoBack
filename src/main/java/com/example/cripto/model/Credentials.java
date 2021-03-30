package com.example.cripto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials {

    private String email;

    private String password;

    public Credentials(@JsonProperty("email") String email,@JsonProperty("password") String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
