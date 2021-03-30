package com.example.cripto.service;

import com.example.cripto.model.Chat;
import com.example.cripto.model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface MessageService {
    List<Message> getMessagesFromConversationId(int id);
    int createConvo(int[] parties);
    List<Message> addMessage(int id, Message m);
    ArrayList<Chat> getChatsByUserId(int id);
}
