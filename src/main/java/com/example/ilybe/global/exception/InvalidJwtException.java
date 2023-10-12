package com.example.ilybe.global.exception;


import com.example.ilybe.global.error.CustomException;
import com.example.ilybe.global.error.ErrorCode;

public class InvalidJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}