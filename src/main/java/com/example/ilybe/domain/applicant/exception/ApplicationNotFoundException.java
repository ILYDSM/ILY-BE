package com.example.ilybe.domain.applicant.exception;

import com.example.ilybe.global.error.CustomException;
import com.example.ilybe.global.error.ErrorCode;

public class ApplicationNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new ApplicationNotFoundException();

    private ApplicationNotFoundException() {
        super(ErrorCode.APPLICATION_NOT_FOUND);
    }
}
