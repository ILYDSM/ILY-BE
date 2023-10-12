package com.example.ilybe.domain.user.exception;

import com.example.ilybe.global.error.CustomException;
import com.example.ilybe.global.error.ErrorCode;

public class UserExistException extends CustomException {
    public static final CustomException EXCEPTION =
            new UserExistException();

    private UserExistException() {
        super(ErrorCode.USER_EXIST);
    }
}