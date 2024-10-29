package com.zeze.board_back.common;

public interface ResponseMessage {

    // HTTP Status 200 (성공)
    public static final String SUCCESS = "Success.";

    // HTTP Status 400
    String VALIDATION_FAILED = "Validation failed.";
    String DUPLICATE_EMAIL = "Duplicate email.";
    String DUPLICATE_NICKNAME = "Duplicate nickname.";
    String DUPLICATE_TEL_NUMBER = "Duplicate tel number.";
    String NOT_EXISTED_USER = "This user does not exist.";
    String NOT_EXISTED_BOARD = "This board does not exist.";
 
    // HTTP Status 401
    String SING_IN_FAIL = "Login information mismatch.";
    String AUTHORIZATION_FAIL = "Authorization Failed.";
 
    // HTTP Status 403 (권한 없음)
    String NO_PERMISSION = "Do not have permission.";
 
    // HTTP Status 500
    String DATABASE_ERROR = "Database error.";
}
