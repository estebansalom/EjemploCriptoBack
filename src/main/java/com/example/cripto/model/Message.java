package com.example.cripto.model;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="type", nullable = false)
    private String type;
    @Column(name="content", nullable = false)
    private String content;

    public Message() {
    }

//    public int getMessageId() {
//        return messageId;
//    }
//
//    public void setMessageId(int messageId) {
//        this.messageId = messageId;
//    }
//
//    public Conversation getConvo() {
//        return conversation;
//    }
//
//    public void setConvo(Conversation convo) {
//        this.conversation = convo;
//    }

    public Message(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
