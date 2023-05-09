package com.loginExercise.logic;

import com.loginExercise.dal.IChatDal;
import com.loginExercise.dal.IUsersDal;
import com.loginExercise.dto.MassageData;
import com.loginExercise.dto.SuccessfulLoginDetails;
import com.loginExercise.dto.UserLoginData;
import com.loginExercise.entities.Chat;
import com.loginExercise.entities.User;
import com.loginExercise.enums.ErrorType;
import com.loginExercise.exceptions.ServerException;
import com.loginExercise.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatLogic {


    private IChatDal iChatDal;

    @Autowired
    public ChatLogic(IChatDal iChatDal) {
        this.iChatDal = iChatDal;
    }
        public void addMassage(MassageData massageData) throws ServerException {

            String userName = massageData.getUser().getUserName();
            String massage = massageData.getMassage();

            String massageJson = "${name: {userName}, massage: {massage}}";
            Chat chat =new Chat(massageData.getChatID(),massageData.getChatName() ,massageJson);
            iChatDal.save(chat);

        }
}
