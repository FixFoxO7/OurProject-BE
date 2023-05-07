package com.loginExercise.enums;

public enum ErrorType {
    GENERAL_ERROR(600, "Something went wrong ,try again later", true),
    INVALID_NAME_LENGTH(601, "Invalid name length entered", false),
    INVALID_USER_NAME(602, "User name must be a valid email", false),
    ERROR_DELETING_EXPIRED_COUPONS(622,"Failure deleting expired coupons",false),
    INVALID_ADDRESS_ENTERED(603, "Address entered is incorrect , enter country followed by ','and town name ", false),
    INVALID_VALUE_INPUT(604, "Invalid value entered ", false),
    INVALID_PHONE_NUMBER(605, "Invalid phone number entered", false),
    UNSUPPORTED_REQUEST(606, "Cannot proceed data requested does not exist", false),
    AUTHENTICATION_ERROR(607, "User details failed authentication", false),
    INVALID_USER_TYPE(608, "Cannot proceed user type undefined ", false),
    INVALID_PASSWORD_PATTERN(609, "Password must contain 2 digits and 2 letters at least ", false),
    OPERATION_CANCELED(610, "Process terminated due to invalid request", false),
    INVALID_INPUT_LENGTH(611, "Check input , it's either too long or too short", false),
    INVALID_DATE_INPUT(612, "Invalid date entered", false),
    EXPIRED_COUPON(613, "Sorry , coupon's end date has passed ", false),
    INVALID_PASSWORD_LENGTH(614, "Password must be at least 4 characters long", false),
    USERNAME_ALREADY_EXISTS(615, "User name taken please choose another one", false),
    INVALID_DESCRIPTION(616, "Description entered invalid ", false),
    USER_LOGIN_FAILED(617, "Users details incorrect , login aborted", false),
    CATEGORY_ALREADY_EXISTS(618, "Category name exists , operation canceled ,have a nice day", false),
    COUPON_NAME_EXISTS(619, "It seems coupon name is taken, please choose another name for your product", false),
    COMPANY_NAME_EXISTS(620, " Under this name there is a company already registered, sorry. Have a nice day", false),
    PERMISSION_NOT_GRANTED(621, "Process terminated request not allowed   ", false);


    private int internalErrorCode;
    private String errorMessage;

    private boolean isShowStackTrace;

    ErrorType(int internalErrorCode, String errorMessage, boolean isShowStackTrace) {
        this(internalErrorCode, " ,"+errorMessage+" ,");
        this.isShowStackTrace = isShowStackTrace;
    }

    ErrorType(int internalErrorCode, String errorMessage) {
        this.internalErrorCode = internalErrorCode;
        this.errorMessage = errorMessage;
    }

    ErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getInternalErrorCode() {
        return internalErrorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isShowStackTrace() {
        return isShowStackTrace;
    }
}
