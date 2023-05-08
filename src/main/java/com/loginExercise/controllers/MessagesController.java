package com.loginExercise.controllers;

import com.loginExercise.entities.Message;
import com.loginExercise.exceptions.ServerException;
import com.loginExercise.logic.MessagesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
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

//    @GetMapping("{id}")
//    public CategoryDto get(@PathVariable("id") long id) throws ServerException {
//        return categoriesLogic.getById(id);
//    }
//
//    @GetMapping
//    public List<CategoryDto> getAll() throws ServerException {
//        return categoriesLogic.getAll();
//    }
//
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
