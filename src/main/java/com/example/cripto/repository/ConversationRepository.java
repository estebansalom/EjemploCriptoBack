package com.example.cripto.repository;

import com.example.cripto.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Integer> {
    Conversation findOneById(int id);
}
