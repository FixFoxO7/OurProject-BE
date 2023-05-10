package com.loginExercise.dto;

public class MessageDto {
    private Long id;
    private String context;
    private String sender;
    private boolean isRead;

    public MessageDto(Long id, String context, String sender,boolean isRead) {
        this.id = id;
        this.context = context;
        this.sender = sender;
        this.isRead = isRead;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }


    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
