package com.loginExercise.dto;

import com.loginExercise.entities.User;

public class MassageData {

    private String chatName;

    private Long chatID;
    private User user;
    private String massage;

    public MassageData(String chatName, Long chatID, User user, String massage) {
        this.chatName = chatName;
        this.chatID = chatID;
        this.user = user;
        this.massage = massage;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public Long getChatID() {
        return chatID;
    }

    public void setChatID(Long chatID) {
        this.chatID = chatID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
