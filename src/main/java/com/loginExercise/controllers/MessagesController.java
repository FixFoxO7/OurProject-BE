package com.loginExercise.controllers;

import com.loginExercise.dto.MessageDto;
import com.loginExercise.entities.Message;
import com.loginExercise.exceptions.ServerException;
import com.loginExercise.logic.MessagesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessagesController {

    private MessagesLogic messagesLogic;


    @Autowired
    public MessagesController(MessagesLogic messagesLogic) {
        this.messagesLogic = messagesLogic;
    }


    @PostMapping
    public void add(@RequestHeader String authorization, @RequestBody Message message) throws ServerException {
        messagesLogic.add(authorization,message);
    }

    @GetMapping("{id}")
    public MessageDto getById(@PathVariable("id") Long id) throws ServerException {
        return messagesLogic.getById(id);
    }

    @GetMapping("/bySender/{senderId}")
    public List<MessageDto> getAllBySender(@PathVariable("senderId") long senderId) throws ServerException {
        return messagesLogic.getAllBySender(senderId);
    }

    @GetMapping("/byReceiver/{receiverId}")
    public List<MessageDto> getAllByReceiver(@PathVariable("receiverId")long receiverId) throws ServerException {
        return messagesLogic.getAllByReceiver(receiverId);
    }
//    @PutMapping
//    public void update(@RequestHeader String authorization,@RequestBody Category category) throws ServerException {
//        categoriesLogic.update(authorization,category);
//    }
//
//    @DeleteMapping("{id}")
//    public void delete(@RequestHeader String authorization,@PathVariable("id") long id) throws ServerException {
//        categoriesLogic.remove(authorization,id);
//    }
}
