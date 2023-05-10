package com.loginExercise.entities;

import javax.persistence.*;

@Entity
@Table(name = "Messages")
public class Message {
    @Id
    @GeneratedValue
    private Long Id;

    @Column(name = "context")
    private String context;

    @ManyToOne
    @JoinColumn(name = "sender")
    private User sender;


    @Column(name = "isRead",nullable = false)
    private boolean isRead;

    public Message() {
    }

    public Message(Long id, String context, User sender) {
        Id = id;
        this.context = context;
        this.sender = sender;
        this.isRead = false;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }


    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }


    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
