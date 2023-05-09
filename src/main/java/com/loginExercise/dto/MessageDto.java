package com.loginExercise.dto;

public class MessageDto {
    private Long id;
    private String subject;
    private String context;
    private Long senderId;
    private Long receiverId;
    private boolean isRead;

    public MessageDto(Long id, String subject, String context, Long senderId, Long receiverId,boolean isRead) {
        this.id = id;
        this.subject = subject;
        this.context = context;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.isRead = isRead;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
