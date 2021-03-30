package com.example.cripto.service;

import com.example.cripto.model.PublicKey;
import com.example.cripto.repository.PublicKeyRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.UUID;

@Service
public class PublicKeyServiceImpl implements PublicKeyService {

    @Autowired
    PublicKeyRepository pkRepo;

    @Override
    public PublicKey getKeyByUserId(int usrId) {
        return pkRepo.findOneByUserId(usrId);
    }

    @Override
    public PublicKey generateKey(String param) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String sha256hex = Hashing.sha256()
                .hashString(param, StandardCharsets.UTF_8)
                .toString();
        byte[] key32bytes = sha256digest32(sha256hex);

        return addKey(new PublicKey(DigestUtils.md5DigestAsHex(key32bytes).toUpperCase().substring(0,16)));
    }

    @Override
    public PublicKey addKey(PublicKey pk) {
        return pkRepo.save(pk);
    }

    public static byte[] sha256digest32(String key) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        digest.update(key.getBytes("UTF-8"));
        byte[]  b = digest.digest();
        return Arrays.copyOf(b, 16);
    }
}
