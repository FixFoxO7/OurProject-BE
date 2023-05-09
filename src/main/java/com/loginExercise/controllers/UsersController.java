package com.loginExercise.controllers;

import com.loginExercise.dto.UserDto;
import com.loginExercise.dto.UserLoginData;
import com.loginExercise.entities.User;
import com.loginExercise.exceptions.ServerException;
import com.loginExercise.logic.UsersLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping
    public void add(@RequestBody User user) throws ServerException {
        usersLogic.addUser(user);
    }
    @GetMapping("{id}")
    public UserDto getById(@PathVariable("id") long id) throws ServerException {
        return usersLogic.getById(id);
    }
    @GetMapping("{name}")
    public UserDto getByName(@PathVariable("name") String name) throws ServerException {
        return usersLogic.getByName(name);
    }

    @GetMapping
    public List<UserDto> getAll() throws ServerException {
        return usersLogic.getAll();
    }

    @PutMapping
    public void update(@RequestHeader String authorization,@RequestBody User user) throws ServerException {
        usersLogic.update(authorization,user);
    }

    @DeleteMapping("{id}")
    public void delete(@RequestHeader String authorization,@PathVariable("id") long id) throws ServerException {
       usersLogic.remove(authorization,id);
    }
}
