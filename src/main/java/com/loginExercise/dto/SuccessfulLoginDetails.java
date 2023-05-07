package com.loginExercise.dto;
public class SuccessfulLoginDetails {
    private Long id;

    public SuccessfulLoginDetails(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
