package com.loginExercise.entities;

import javax.persistence.*;

@Entity
@Table(name="Chats")
public class Chat {
    @Id
    @GeneratedValue
    private Long Id;

    @Column(name = "chat_name", unique = true, nullable = false)
    private String chatName;

    @Column(name = "massage_json")
    private String massageJson;

    public Chat() {
    }

    public Chat(Long id, String chatName, String massageJson) {
        Id = id;
        this.chatName = chatName;
        this.massageJson = massageJson;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public String getMassageJson() {
        return massageJson;
    }

    public void setMassageJson(String massageJson) {
        this.massageJson = massageJson;
    }
}
