package com.example.cripto.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "conversation")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="parties", nullable = false)
    private int[] parties;
    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "message_conv_id", referencedColumnName = "id")
    private List<Message> messages = new ArrayList<Message>();

    public Conversation() {
    }

    public Conversation(int[] parties) {
        this.parties = parties;
    }

    public Conversation(int id, int[] parties, List<Message> messages) {
        this.id = id;
        this.parties = parties;
        this.messages = messages;
    }

    public void addMessage(Message m){
        this.messages.add(m);
    }

    public int getId() {
        return id;
    }

    public void setId(int convoId) {
        this.id = convoId;
    }

    public int[] getParties() {
        return parties;
    }

    public void setParties(int[] parties) {
        this.parties = parties;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
