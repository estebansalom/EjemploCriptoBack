package com.example.cripto.service;

import com.example.cripto.EjemploCriptoWebApplication;
import com.example.cripto.model.Chat;
import com.example.cripto.model.Conversation;
import com.example.cripto.model.Message;
import com.example.cripto.model.User;
import com.example.cripto.repository.ConversationRepository;
import com.example.cripto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    ConversationRepository conversationRepository;
    @Autowired
    UserRepository userRepo;

    @Override
    public List<Message> getMessagesFromConversationId(int id) {
        return conversationRepository.findOneById(id).getMessages();
    }

    public int createConvo(int[] parties){
        Conversation convo = new Conversation(parties);
        conversationRepository.save(convo);
        return 1;
    }

    public List<Message> addMessage(int id, Message m){
        Conversation convo = conversationRepository.findOneById(id);
        convo.addMessage(m);
        conversationRepository.save(convo);
        return conversationRepository.findOneById(id).getMessages();
    }

    @Override
    public ArrayList<Chat> getChatsByUserId(int id) {
        List<Conversation> allConvos = conversationRepository.findAll();
        ArrayList<Conversation> myConvos = new ArrayList<Conversation>();
        ArrayList<Chat> res = new ArrayList<Chat>();
        for (Conversation c: allConvos
             ) {
            for(int i=0; i<c.getParties().length; i++){
                if(c.getParties()[i] == id){
                    myConvos.add(c);
                }
            }
        }
        for (Conversation c:
             myConvos) {
            for(int i=0; i<c.getParties().length; i++){
                if(c.getParties()[i] != id){
                    User recipient = new User(userRepo.getOne(c.getParties()[i]));
                    Chat newChat = new Chat(c.getId(), recipient.getNombre() + " " + recipient.getApellidos());
                    res.add(newChat);
                }
            }
        }
        return res;
    }
}
