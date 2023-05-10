package com.loginExercise.logic;

import com.loginExercise.dal.IMessagesDal;
import com.loginExercise.dal.IUsersDal;
import com.loginExercise.dto.MessageDto;
import com.loginExercise.entities.Message;
import com.loginExercise.entities.User;
import com.loginExercise.enums.ErrorType;
import com.loginExercise.exceptions.ServerException;
import com.loginExercise.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessagesLogic {

    private IMessagesDal iMessagesDal;
    private IUsersDal iUsersDal;

    @Autowired
    public MessagesLogic(IMessagesDal iMessagesDal,IUsersDal iUsersDal) {
        this.iMessagesDal = iMessagesDal;
        this.iUsersDal = iUsersDal;
    }

    public void add(String authorization, Message message) throws ServerException {
        try{
        if (authorization!=null) {
            long senderId = JWTUtils.getIdByToken(authorization);
            User sender = iUsersDal.findById(senderId);
            message.setSender(sender);
            iMessagesDal.save(message);
        }
        }catch (Exception e){
            throw new ServerException(ErrorType.GENERAL_ERROR);
        }
    }

    public MessageDto getById(long id) throws ServerException {
        try {
            Message message = iMessagesDal.findById(id);
            message.setRead(true);
            return extractDto(message);
        }catch (Exception e){
            throw new ServerException(ErrorType.GENERAL_ERROR);
        }
    }

//    public List<MessageDto> getAllBySender(long senderId) throws ServerException {
//        try{
//            List<Message>messages = iMessagesDal.findAllBySenderId(senderId);
//            List<MessageDto>messagesDto = new ArrayList<>();
//            messages.forEach(
//                    message -> messagesDto.add(extractDto(message)));
//                    return messagesDto;
//        }catch (Exception e){
//            throw new ServerException(ErrorType.GENERAL_ERROR);
//        }
//    }


    public List<MessageDto> getAll() throws ServerException {
        try{
            List<Message>messages = iMessagesDal.getAll();
            List<MessageDto>messagesDto = new ArrayList<>();
            messages.forEach(
                    message -> messagesDto.add(extractDto(message)));
            return messagesDto;
        }catch (Exception e){
            throw new ServerException(ErrorType.GENERAL_ERROR);
        }
    }
//    public void remove(String authorization, long id) throws ServerException {
//        long userId = JWTUtils.getIdByToken(authorization);
//        Message message = iMessagesDal.findById(id);
//        if (userId!=message.getReceiver().getId()){
//            throw new ServerException(ErrorType.AUTHENTICATION_ERROR);
//        }
//    }
    private MessageDto extractDto(Message message) {
        return new MessageDto(
                message.getId(),
                message.getContext(),
                message.getSender().getUserName(),
                message.isRead());
    }

}
