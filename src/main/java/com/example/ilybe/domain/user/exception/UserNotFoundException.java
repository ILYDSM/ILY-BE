package com.example.ilybe.domain.user.exception;


import com.example.ilybe.global.error.CustomException;
import com.example.ilybe.global.error.ErrorCode;

public class UserNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}