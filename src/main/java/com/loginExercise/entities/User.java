package com.loginExercise.entities;

import javax.persistence.*;

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

    public User() {
    }

    public User(Long id, String userName, String password) {
        Id = id;
        this.userName = userName;
        this.password = password;
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
}
