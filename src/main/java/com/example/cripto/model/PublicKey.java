package com.example.cripto.model;

import javax.persistence.*;

@Entity
public class PublicKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    private int userId;
    private String key;

    public PublicKey() {
    }

    public PublicKey(String key) {
        this.key = key;
    }

    public PublicKey(int userId, String key) {
        this.userId = userId;
        this.key = key;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
