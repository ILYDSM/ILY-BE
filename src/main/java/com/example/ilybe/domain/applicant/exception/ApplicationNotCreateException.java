package com.example.ilybe.domain.applicant.exception;


import com.example.ilybe.global.error.CustomException;
import com.example.ilybe.global.error.ErrorCode;

public class ApplicationNotCreateException extends CustomException {
    public static final CustomException EXCEPTION =
            new ApplicationNotCreateException();

    private ApplicationNotCreateException() {
        super(ErrorCode.APPLICATION_NOT_CREATE);
    }
}
