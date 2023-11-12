package com.example.ilybe.domain.meet.exception;

import com.example.ilybe.global.error.CustomException;
import com.example.ilybe.global.error.ErrorCode;

public class AlreadyBookmarkedException extends CustomException {
    public static final CustomException EXCEPTION =
            new AlreadyBookmarkedException();

    private AlreadyBookmarkedException() {
        super(ErrorCode.ALREADY_BOOKMARKED);
    }
}
