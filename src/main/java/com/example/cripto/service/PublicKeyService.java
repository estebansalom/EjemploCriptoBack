package com.example.cripto.service;

import com.example.cripto.model.PublicKey;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public interface PublicKeyService {
    PublicKey getKeyByUserId(int usrId);

    PublicKey generateKey(String param) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    PublicKey addKey(PublicKey pk);
}
