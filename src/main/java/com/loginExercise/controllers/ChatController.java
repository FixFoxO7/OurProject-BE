package com.loginExercise.controllers;

import com.loginExercise.dto.MassageData;
import com.loginExercise.dto.UserLoginData;
import com.loginExercise.exceptions.ServerException;
import com.loginExercise.logic.ChatLogic;
import com.loginExercise.logic.UsersLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private ChatLogic chatLogic;
        @Autowired
        public ChatController(ChatLogic chatLogic) {
            this.chatLogic = chatLogic;
        }

    @PostMapping("{chatID}/addMassage")
    public void addMassage(@RequestBody MassageData massageData, @PathVariable("chatId") int chatId) throws ServerException {
         chatLogic.addMassage(massageData);
    }
//    @PostMapping
//    public void add(@RequestBody User user) throws ServerException {
//        usersLogic.addUser(user);
//    }
}
