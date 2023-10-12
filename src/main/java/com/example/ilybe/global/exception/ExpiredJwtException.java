package com.example.ilybe.global.exception;

import com.example.ilybe.global.error.CustomException;
import com.example.ilybe.global.error.ErrorCode;

public class ExpiredJwtException extends CustomException {
    public static final CustomException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}