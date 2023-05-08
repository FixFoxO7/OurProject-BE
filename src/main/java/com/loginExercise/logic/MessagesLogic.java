package com.loginExercise.logic;

import com.loginExercise.dal.IMessagesDal;
import com.loginExercise.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagesLogic {

    private IMessagesDal iMessagesDal;

    @Autowired
    public MessagesLogic(IMessagesDal iMessagesDal) {
        this.iMessagesDal = iMessagesDal;
    }

    public void add(String authorization, Message message) {
        if (authorization!=null){
            iMessagesDal.save(message);
        }
    }
}
