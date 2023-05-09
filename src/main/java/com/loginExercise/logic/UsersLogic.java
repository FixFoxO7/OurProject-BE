package com.loginExercise.logic;

import com.loginExercise.dal.IUsersDal;
import com.loginExercise.dto.SuccessfulLoginDetails;
import com.loginExercise.dto.UserDto;
import com.loginExercise.dto.UserLoginData;
import com.loginExercise.entities.User;
import com.loginExercise.enums.ErrorType;
import com.loginExercise.exceptions.ServerException;
import com.loginExercise.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public void addUser(User user) throws ServerException {
        validateUser();
        try{
            iUsersDal.save(user);
        }catch (Exception e){
            throw new ServerException(ErrorType.GENERAL_ERROR);
        }
    }

    private void validateUser() {

    }

    public UserDto getById(long id) throws ServerException {
        try{
            return iUsersDal.getById(id);
        }catch (Exception e){
            throw  new ServerException(ErrorType.GENERAL_ERROR);
        }
    }

    public List<UserDto> getAll() throws ServerException {
        try{
            List <User> users = iUsersDal.findAll();
            List<UserDto>usersDto = new ArrayList<>();
            users.forEach(user -> usersDto.add(new UserDto(user.getId(), user.getUserName(), user.getAge(), user.getGender())));
            return usersDto;
        }catch (Exception e){
            throw new ServerException(ErrorType.GENERAL_ERROR);
        }
    }

    public void update(String authorization, User user) throws ServerException {
        validateUser();
        try{
            iUsersDal.save(user);
        }catch (Exception e){
            throw new ServerException(ErrorType.GENERAL_ERROR);
        }
    }

    public void remove(String authorization, long id) throws ServerException {
        validateUserExist(id);
        try{
            iUsersDal.deleteById(id);
        }catch (Exception e){
            throw new ServerException(ErrorType.GENERAL_ERROR);
        }
    }



    public UserDto getByName(String name) throws ServerException {
        validateString(name);
        try{
            User user = iUsersDal.findByUserName(name);
            return new UserDto(user.getId(), user.getUserName(), user.getAge(), user.getGender());
        }catch (Exception e){
            throw new ServerException(ErrorType.GENERAL_ERROR);
        }
    }

    private void validateString(String name) throws ServerException {
        if (name.isEmpty()){
            throw new ServerException(ErrorType.UNSUPPORTED_REQUEST);
        }
    }
    private void validateUserExist(long id) throws ServerException {
        if (!iUsersDal.existsById(id)){
            throw new ServerException(ErrorType.UNSUPPORTED_REQUEST);
        }
    }
}
