package com.loginExercise.dto;

import com.loginExercise.enums.Gender;

public class UserDto {
    private Long id;
    private String userName;
    private int age;
    private Gender gender;

    public UserDto(Long id, String userName, int age, Gender gender) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
