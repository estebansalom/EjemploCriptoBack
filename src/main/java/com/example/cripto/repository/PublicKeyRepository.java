package com.example.cripto.repository;

import com.example.cripto.model.PublicKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicKeyRepository extends JpaRepository<PublicKey, Integer> {
    PublicKey findOneByUserId(int userId);
}
