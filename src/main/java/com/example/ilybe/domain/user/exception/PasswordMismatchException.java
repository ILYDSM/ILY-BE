package com.example.ilybe.domain.user.exception;

import com.example.ilybe.global.error.CustomException;
import com.example.ilybe.global.error.ErrorCode;

public class PasswordMismatchException extends CustomException {
    public static final CustomException EXCEPTION =
            new PasswordMismatchException();

    private PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}