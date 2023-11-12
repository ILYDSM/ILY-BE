package com.example.ilybe.domain.meet.exception;

import com.example.ilybe.global.error.CustomException;
import com.example.ilybe.global.error.ErrorCode;

public class MeetNotFoundException extends CustomException{
    public static final CustomException EXCEPTION =
            new MeetNotFoundException();

    private MeetNotFoundException(){
        super(ErrorCode.MEET_NOT_FOUND);
    }
}
