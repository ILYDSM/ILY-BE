package com.example.ilybe.global.exception;


import com.example.ilybe.global.error.CustomException;
import com.example.ilybe.global.error.ErrorCode;

public class InvalidRefreshTokenException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidRefreshTokenException();

    private InvalidRefreshTokenException() {
        super(ErrorCode.INVALID_REFRESH_TOKEN);
    }
}