package com.example.ilybe.domain.meet.exception;

import com.example.ilybe.global.error.CustomException;
import com.example.ilybe.global.error.ErrorCode;

public class CreatorMismatchedException extends CustomException {
    public static final CustomException EXCEPTION =
            new CreatorMismatchedException();

    private CreatorMismatchedException() {
        super(ErrorCode.CREATOR_MISMATCHED);
    }
}
