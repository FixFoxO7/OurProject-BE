package com.loginExercise.logic;

import com.loginExercise.dal.IUsersDal;
import com.loginExercise.dto.SuccessfulLoginDetails;
import com.loginExercise.dto.UserLoginData;
import com.loginExercise.enums.ErrorType;
import com.loginExercise.exceptions.ServerException;
import com.loginExercise.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersLogic {


    private IUsersDal iUsersDal;

    @Autowired
    public UsersLogic(IUsersDal iUsersDal) {
        this.iUsersDal = iUsersDal;
    }
        public String login(UserLoginData userLoginDetails) throws ServerException {

            String userName = userLoginDetails.getUserName();
            String password = userLoginDetails.getPassword();

            SuccessfulLoginDetails userData = iUsersDal.login(userName, password);
            if (userData == null) {
                throw new ServerException(ErrorType.USER_LOGIN_FAILED);
            }
            try {
                return JWTUtils.createJWT(userData);
            } catch (Exception e) {
                throw new ServerException(ErrorType.GENERAL_ERROR);
            }
    }
}
