package com.loginExercise.controllers;

import com.loginExercise.dto.UserLoginData;
import com.loginExercise.exceptions.ServerException;
import com.loginExercise.logic.UsersLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    private UsersLogic usersLogic;

    @Autowired
    public UsersController(UsersLogic usersLogic) {
        this.usersLogic = usersLogic;
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginData userLoginData) throws ServerException {
        return usersLogic.login(userLoginData);
    }
//    @PostMapping
//    public void add(@RequestBody User user) throws ServerException {
//        usersLogic.addUser(user);
//    }
}
