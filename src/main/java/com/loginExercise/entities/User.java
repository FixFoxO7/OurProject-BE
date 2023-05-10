package com.loginExercise.entities;

import com.loginExercise.enums.Gender;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue
    private Long Id;

    @Column(name = "user_name", unique = true,nullable = false)
    private String userName;

    @Column(name = "Password")
    private String password;
    @Column(name = "Age")
    private int age;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;


    public User() {
    }

    public User(Long id, String userName, String password, int age, Gender gender, List<Message> sentMessages, List<Message> receivedMessages) {
        Id = id;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
