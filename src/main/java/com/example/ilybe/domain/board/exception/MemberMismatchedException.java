package com.example.ilybe.domain.board.exception;

import com.example.ilybe.global.error.CustomException;
import com.example.ilybe.global.error.ErrorCode;

public class MemberMismatchedException extends CustomException {
    public static final CustomException EXCEPTION =
            new MemberMismatchedException();

    private MemberMismatchedException() {
        super(ErrorCode.MEMBER_MISMATCHED);
    }
}
