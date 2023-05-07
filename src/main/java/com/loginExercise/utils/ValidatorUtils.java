package com.loginExercise.utils;

import com.loginExercise.enums.ErrorType;
import com.loginExercise.exceptions.ServerException;
import io.jsonwebtoken.Claims;
import org.hibernate.usertype.UserType;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidatorUtils {

    public static boolean isNumberValid(int num) {
        if (num < 1) {
            return false;
        }
        return true;
    }

    public static boolean isNameValid(String name) {
        if (name==null){
            return false;
        }
        if (name.length() < 1) {
            return false;
        }
        if (name.length() > 45) {
            return false;
        }
        if (name.isBlank()){
            return false;
        }
        return true;
    }

    public static boolean isPhoneNumberValid(String phoneNumber) {
        String patterns = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }
    public static Long validateToken(String Authorization) throws ServerException {
        try {
            return JWTUtils.validateToken(Authorization);
        } catch (Exception e) {
            throw new ServerException(e, ErrorType.AUTHENTICATION_ERROR, "Authentication Error , please login ");
        }
    }
    public static void validateUserPermission(String authorization , UserType userType) throws ServerException {

        Claims claims = JWTUtils.decodeJWT(authorization);
        String strUserType = claims.getIssuer();

        if (!Objects.equals(String.valueOf(userType), strUserType)){
            throw new ServerException(ErrorType.PERMISSION_NOT_GRANTED,"Permission not granted");
        }
    }
}